package edu.nur.edd.batalla.red;

import edu.nur.edd.batalla.objetos.Batalla;
import edu.nur.edd.batalla.objetos.Jugador;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Protocolo {
    private static Logger logger = LogManager.getRootLogger();
    public static final int PUERTO = 7658;
    public static final String DISPARO = "SHOOT";
    public static final String PIEZAS = "PIEZAS";
    public static final String SALIR = "EXIT";

    private Socket cliente;
    private BufferedReader in;
    private PrintWriter out;

    public Protocolo(Socket clt) {
        cliente = clt;
        try {
            in = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            out = new PrintWriter(cliente.getOutputStream(), true);
        } catch (Exception e) {
            try {
                cliente.close();
            } catch (IOException ex) {
                logger.error("No pudo cerrar el socket");
            }
            logger.error("Error al crear el protocolo", e);
            return;
        }
    }

    public void procesarRecepcion() {
        try {
            logger.info("Comienza escuchando el socket");
            String linea = in.readLine();
            while (!linea.equals(SALIR)) {
                logger.info("Recibido: {0}", linea);
                String regexMsg = "^(" + DISPARO + "|" + PIEZAS + ")\\s(.+)$";
                String mensaje = "";
                if (linea.matches(regexMsg)) {
                    if (linea.startsWith(DISPARO)) {
                        comandoDisparo(linea);
                    } else if(linea.startsWith(PIEZAS)) {
                        comandoPiezas(linea);
                    }

                    logger.info("Mensaje: " + mensaje.toString());
                } else {
                    logger.warn("Comando desconocido");
                }

                linea = in.readLine();
            }
        }
        catch(Exception e) {
            logger.error("Error al procesar la recepcion, cierra todo", e);
        } finally {
            try {
                cliente.close();
            } catch (Exception e) {
                logger.error("Error al cerrar el socket", e);
            }
        }
    }

    private void comandoPiezas(String linea) {
        Batalla juego = Batalla.getOrCreate();
        Jugador remoto = juego.getRemoto();
        String coordenadas = linea.substring(PIEZAS.length()).trim();
        String[] coordXY = coordenadas.split(",");

        int i=0;
        int nroPieza = 0;
        while(i<21) {
            nroPieza = i / 3;
            int x = Integer.parseInt(coordXY[i + 0]);
            int y = Integer.parseInt(coordXY[i + 1]);
            int estado = Integer.parseInt(coordXY[i + 2]);

            remoto.posicionPiezaYEstado(nroPieza, x, y, estado);

            i+=3;
        }
        remoto.notificar();
    }

    /**
     * SHOOT 32,21
     * @param linea
     */
    private void comandoDisparo(String linea) {
        Batalla juego = Batalla.getOrCreate();
        Jugador local = juego.getLocal();
        String coordenadas = linea.substring(DISPARO.length()).trim();
        String[] coordXY = coordenadas.split(",");
        int x = Integer.parseInt(coordXY[0]);
        int y = Integer.parseInt(coordXY[1]);
        if (local.matoPieza(x,y)) {
            enviarMensaje(PIEZAS,local.getPiezasParaRed());
            local.notificar();
        } else {
            logger.info("JA JA, no me dio");
        }
    }

    public void enviarMensaje(String cmd, String texto) {
        logger.info("Envia: " + texto);
        out.println(cmd + " " + texto);
    }

    public void enviarSalir() {
        logger.info("Envia: Salir");
        out.println(SALIR);

        try {
            cliente.close();
        } catch (IOException e) {
            logger.warn("El socket cliente ya estaba cerrado");
        }
    }
}
