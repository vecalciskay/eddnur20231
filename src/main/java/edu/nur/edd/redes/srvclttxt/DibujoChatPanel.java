package edu.nur.edd.redes.srvclttxt;

import edu.nur.edd.redes.chat.Conversacion;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class DibujoChatPanel extends JPanel implements PropertyChangeListener {
    private static Logger logger = LogManager.getRootLogger();
    public DibujoChatPanel() {
        Conversacion modelo = Conversacion.getOrCreate();
        modelo.addObserver(this);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600,2000);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Conversacion modelo = Conversacion.getOrCreate();
        modelo.dibujar(g, 0, 0, getWidth());
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        Conversacion conversacion = Conversacion.getOrCreate();
        logger.info((conversacion == null ? "NULL" : conversacion.toString()));
        repaint();
    }
}
