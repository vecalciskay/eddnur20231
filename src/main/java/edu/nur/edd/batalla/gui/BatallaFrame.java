package edu.nur.edd.batalla.gui;

import edu.nur.edd.batalla.objetos.Batalla;
import edu.nur.edd.batalla.red.Protocolo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BatallaFrame extends JFrame {
    private static Logger logger = LogManager.getRootLogger();
    private JugadorPanel panelLocal;
    private JugadorPanel panelRemoto;

    public BatallaFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());
        initMenu();
        initPanels();

        this.pack();
        this.setVisible(true);
    }

    private void initPanels() {
        Batalla juego = Batalla.getOrCreate();

        panelLocal = new JugadorPanel(true);
        panelRemoto = new JugadorPanel(false);

        panelLocal.setModelo(juego.getLocal());
        panelRemoto.setModelo(juego.getRemoto());

        this.getContentPane().add(panelLocal, BorderLayout.WEST);
        this.getContentPane().add(panelRemoto, BorderLayout.EAST);
    }


    public void initMenu(){
        JMenuBar bar = new JMenuBar();

        JMenu menu = new JMenu("Archivo");
        JMenuItem item = new JMenuItem("Esperar Conexión");
        item.addActionListener(e -> menuArchivo_EsperarConexion());
        menu.add(item);

        item = new JMenuItem("Conectar");
        item.addActionListener(e -> menuArchivo_Conectar());
        menu.add(item);

        item = new JMenuItem("Salir");
        item.addActionListener(e -> System.exit(0));
        menu.add(item);

        bar.add(menu);

        this.setJMenuBar(bar);
    }

    private void menuArchivo_Conectar() {
        String ipServidor = "";
        String regex = "^(?:[0-9]{1,3}\\.){3}[0-9]{1,3}$";
        while (!ipServidor.matches(regex)) {
            ipServidor = JOptionPane.showInputDialog("Ingrese la dirección IP del servidor");
            if (ipServidor == null) {
                logger.info("El usuario hizo clic en cancel");
                return;
            }
        }

        final String ip = ipServidor;

        Thread t = new Thread(() -> conectar(ip));
        t.start();
    }

    private void menuArchivo_EsperarConexion() {
        JOptionPane.showMessageDialog(this,
                "Al cerrar esta ventana comenzara a escuchar", "Mensaje",
                JOptionPane.INFORMATION_MESSAGE);

        Thread t = new Thread(() -> esperarConexion());
        t.start();
    }

    public void esperarConexion() {

        ServerSocket srv = null;
        Socket clt = null;
        try {
            srv = new ServerSocket(Protocolo.PUERTO);
            logger.info("El usuario abrió el puerto y esta escuchando");
            clt = srv.accept();
            iniciar(clt);
        } catch (IOException e) {
            logger.error("No pudo abrir el puerto", e);
        } finally {
            if (clt != null)
                try { clt.close();} catch(Exception e) {
                    logger.error("Error al cerrar el socket", e);
                }
            if (srv != null) {
                try { srv.close();}
                catch(Exception e) {
                    logger.error("Error al cerrar el server socket", e);
                }
            }
        }
    }

    public void conectar(String ipServidor) {
        try  {
            Socket clt = new Socket(ipServidor, Protocolo.PUERTO);
            logger.info("El usuario se conectó al servidor");
            iniciar(clt);
        } catch(IOException e) {
            logger.error("Error al conectar con el servidor", e);
            JOptionPane.showMessageDialog(this, "Error al conectar con el servidor", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void iniciar(Socket clt) {
        Protocolo protocolo = new Protocolo(clt);
        Batalla juego = Batalla.getOrCreate();
        juego.setProtocolo(protocolo);
        juego.enviarPiezasInicial();
        protocolo.procesarRecepcion();
    }
}
