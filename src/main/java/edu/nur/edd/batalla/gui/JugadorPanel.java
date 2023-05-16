package edu.nur.edd.batalla.gui;

import edu.nur.edd.batalla.objetos.Batalla;
import edu.nur.edd.batalla.objetos.Jugador;
import edu.nur.edd.batalla.red.Protocolo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class JugadorPanel extends JPanel implements PropertyChangeListener, MouseListener {
    private Jugador modelo;


    public JugadorPanel(boolean esLocal) {
        modelo = null;
        if (!esLocal) {
            this.addMouseListener(this);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300,400);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (modelo != null) {
            modelo.dibujar(g);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        repaint();
    }

    public Jugador getModelo() {
        return modelo;
    }

    public void setModelo(Jugador modelo) {
        this.modelo = modelo;
        this.modelo.addListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Batalla juego= Batalla.getOrCreate();
        String msg = e.getX() + "," + e.getY();
        juego.getProtocolo()
                .enviarMensaje(Protocolo.DISPARO,
                        msg);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
