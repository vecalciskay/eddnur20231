package edu.nur.edd.imagenes.obj;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Imagen {
    private int ancho;
    private int alto;
    private int[][] pixeles;

    public Imagen(int w, int h) {
        ancho = w;
        alto = h;
        pixeles = new int[w][h];
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

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int[][] getPixeles() {
        return pixeles;
    }

    public void setPixeles(int[][] pixeles) {
        this.pixeles = pixeles;
    }

    public void todoUnColor() {
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                pixeles[i][j] = 0xFFFFFF;
            }
        }
    }

    public void bandera() {
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto/3; j++) {
                pixeles[i][j] = 0xFF0000;
            }
            for (int j = alto/3; j < 2*alto/3; j++) {
                pixeles[i][j] = 0xF8F32B;
            }
            for (int j = 2*alto/3; j < alto; j++) {
                pixeles[i][j] = 0x32CD32;
            }
        }
    }

    public void leer() {
        BufferedImage bi = null;
        try {
            File f = new File("C:\\temp\\primero.jpg");
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
    }

    public void gris() {
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                int r = pixeles[i][j] >> 16;
                int g = (pixeles[i][j] >> 8) & 0x0000FF;
                int b = pixeles[i][j] & 0x0000FF;
                int prom = (r+g+b)/3;
                pixeles[i][j] = prom | (prom << 8) | (prom << 16);
            }
        }
    }
}
