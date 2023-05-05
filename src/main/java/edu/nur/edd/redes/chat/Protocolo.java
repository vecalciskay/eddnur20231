package edu.nur.edd.redes.chat;

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
    public static final String MENSAJE = "MSG";
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
                String regexMsg = "^" + MENSAJE + "\\s(.+)$";
                String mensaje = "";
                if (linea.matches(regexMsg)) {
                    mensaje = linea.replaceFirst(regexMsg, "$1");
                    logger.info("Mensaje: " + mensaje.toString());
                } else {
                    logger.warn("Comando desconocido");
                }
                Conversacion chat = Conversacion.getOrCreate();
                chat.reciboMensaje(mensaje);

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

    public void enviarMensaje(String texto) {
        logger.info("Envia: " + texto);
        out.println(MENSAJE + " " + texto);
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
