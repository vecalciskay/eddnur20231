package edu.nur.edd.redes.srvclttxt;

import edu.nur.edd.redes.chat.Conversacion;
import edu.nur.edd.redes.chat.Protocolo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorClienteChatFrame extends JFrame {
    private static final Logger logger = LogManager.getRootLogger();

    public ServidorClienteChatFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());

        initMenu();

        ServidorClienteChatPanel panel = new ServidorClienteChatPanel();
        this.getContentPane().add(panel, BorderLayout.CENTER);

        this.pack();
        this.setVisible(true);
    }

    public void initMenu(){
        JMenuBar bar = new JMenuBar();

        JMenu menu = new JMenu("Archivo");
        JMenuItem item = new JMenuItem("Esperar Conexión");
        item.addActionListener(e -> {
            menuArchivo_EsperarConexion();
        });
        menu.add(item);

        item = new JMenuItem("Conectar");
        item.addActionListener(e -> {
            menuArchivo_Conectar();
        });
        menu.add(item);

        item = new JMenuItem("Salir");
        item.addActionListener(e -> {
            System.exit(0);
        });
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
        Conversacion conversacion = Conversacion.getOrCreate();
        conversacion.setProtocolo(protocolo);
        Thread t = new Thread(() -> protocolo.procesarRecepcion());
        t.start();
    }

    private void menuArchivo_EsperarConexion() {
        JOptionPane.showMessageDialog(this,
                "Al cerrar esta ventana comenzara a escuchar", "Mensaje",
                JOptionPane.INFORMATION_MESSAGE);

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
                try { clt.close();} catch(Exception e) {}
            if (srv != null) {
                try { srv.close();} catch(Exception e) {}
            }
        }
    }
}
