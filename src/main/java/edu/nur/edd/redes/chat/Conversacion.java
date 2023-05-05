package edu.nur.edd.redes.chat;

import java.awt.*;
import java.beans.PropertyChangeSupport;

public class Conversacion {
    public static final int ALTO_LINEA = 12;
    private static Conversacion instance;
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    private ItemConversacion[] items = new ItemConversacion[100];
    private int numeroMensajes;
    private Protocolo protocolo;
    public static Conversacion getOrCreate() {
        if (instance == null)
            instance = new Conversacion();
        return instance;
    }
    private Conversacion() {
        protocolo = null;
        numeroMensajes = 0;
    }

    public void setProtocolo(Protocolo protocolo) {
        this.protocolo = protocolo;
    }

    public void addObserver(java.beans.PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void dibujar(Graphics g, int x, int y, int ancho) {
        int yTotal = numeroMensajes * ALTO_LINEA;
        int yActual = y + yTotal;
        for (ItemConversacion item : items) {
            if (item != null) {
                item.dibujar(g, x, yActual, ancho);
                yActual -= ALTO_LINEA;
            }
        }
    }

    public void envioSalir() {
        protocolo.enviarSalir();
    }

    public void envioMensaje(String texto) {
        protocolo.enviarMensaje(texto);
        addMensaje(texto, true);
    }
    public void reciboMensaje(String texto) {
        addMensaje(texto, false);
    }

    private void addMensaje(String texto, boolean mensajeSalida) {
        ItemConversacion item = new MensageTexto(texto, mensajeSalida);
        items[numeroMensajes] = item;
        numeroMensajes++;
        propertyChangeSupport.firePropertyChange("CHAT", numeroMensajes - 1, numeroMensajes);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Conversacion tiene ").append(items.length).append(" mensajes\n");
        for (ItemConversacion item : items) {
            sb.append(item).append("\n");
        }
        return sb.toString();
    }
}
