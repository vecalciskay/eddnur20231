package edu.nur.edd.imagenes.obj;

import edu.nur.edd.imagenes.gui.ImagenPanel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.io.IOException;

public class Imagen {
    private int ancho;
    private int alto;
    private int[][] pixeles;

    private PropertyChangeSupport observado;
    private static Logger logger = LogManager.getRootLogger();

    public Imagen(int w, int h) {
        ancho = w;
        alto = h;
        pixeles = new int[w][h];
        observado = new PropertyChangeSupport(this);
        logger.info("Se crea una imagen vacia de " + w + "x" + h);
    }

    public void dibujar(Graphics g) {
        BufferedImage rsm = new BufferedImage(
                ancho,alto, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = rsm.createGraphics();

        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                g2d.setColor(new Color(pixeles[i][j]));
                g2d.drawLine(i,j,i,j);
            }
        }

        g.drawImage(rsm, 0, 0, null);
    }

    public int getAncho() {
        return ancho;
    }
    public int getAlto() {
        return alto;
    }
    public int[][] getPixeles() {
        return pixeles;
    }

    public void todoUnColor() {
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                pixeles[i][j] = 0xFFFFFF;
            }
        }
        observado.firePropertyChange("IMAGEN", false, true);
    }

    public void leer(File f) {
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(f);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ancho = bi.getWidth();
        alto = bi.getHeight();

        pixeles = new int[ancho][alto];

        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                pixeles[i][j] = bi.getRGB(i,j);
            }
        }

        observado.firePropertyChange("IMAGEN", false, true);
    }

    public void gris() {
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                int r = (pixeles[i][j] >> 16) & 0x000000FF;
                int g = (pixeles[i][j] >> 8) & 0x000000FF;
                int b = pixeles[i][j] & 0x000000FF;
                int prom = (r+g+b)/3;

                pixeles[i][j] = prom + prom * 256 + prom * 256 * 256;
            }
        }
        observado.firePropertyChange("IMAGEN", false, true);
    }

    public void addObserver(PropertyChangeListener listener) {
        observado.addPropertyChangeListener(listener);
    }

    public void cambiosImagen() {
        observado.firePropertyChange("IMAGEN", false, true);
    }
}
