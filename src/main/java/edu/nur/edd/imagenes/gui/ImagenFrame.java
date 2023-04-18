package edu.nur.edd.imagenes.gui;

import edu.nur.edd.imagenes.obj.ComandoFiltro;
import edu.nur.edd.imagenes.obj.Imagen;
import edu.nur.edd.imagenes.obj.filtros.Bandera;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;

public class ImagenFrame extends JFrame {
    private static Logger logger = LogManager.getRootLogger();
    private Imagen modelo;
    public ImagenFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());

        modelo = new Imagen(600,400);
        ImagenPanel panel = new ImagenPanel(modelo);
        modelo.addObserver(panel);
        this.getContentPane().add(panel, BorderLayout.CENTER);

        menu();

        this.pack();
        this.setVisible(true);
    }

    private void menu() {
        JMenuBar bar = new JMenuBar();

        JMenu menu = new JMenu("Archivo");
        JMenuItem item = new JMenuItem("Abrir");
        item.addActionListener(e -> {
            menuArchivoItemAbrir();
        });
        menu.add(item);

        menu.addSeparator();

        item = new JMenuItem("Salir");
        item.addActionListener(e -> {
            logger.info("El usuario sale del programa");
            System.exit(0);
        });

        bar.add(menu);

        menu = new JMenu("Imagen");
        item = new JMenuItem("Gris");
        item.addActionListener(e -> {
            logger.info("El usuario convierte la imagen a escala de grises");
            modelo.gris();
        });
        menu.add(item);

        item = new JMenuItem("Bandera");
        item.addActionListener(e -> {
            logger.info("El usuario convierte la imagen en una bandera BOB");
            ComandoFiltro cmd = new Bandera(modelo);
            cmd.ejecutar();
        });
        menu.add(item);

        bar.add(menu);

        this.setJMenuBar(bar);
    }

    private void menuArchivoItemAbrir() {
        logger.info("Abrimos el file chooser para escoger un archivo");
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            logger.info(chooser.getSelectedFile().getAbsolutePath());
            modelo.leer(chooser.getSelectedFile());
        }
        this.pack();
    }

    public static void main(String[] args) {
        ImagenFrame obj = new ImagenFrame();
    }
}
