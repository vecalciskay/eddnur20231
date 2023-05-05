package edu.nur.edd.redes.srvclttxt;

import edu.nur.edd.redes.chat.Conversacion;
import edu.nur.edd.redes.chat.Protocolo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;

public class ServidorClienteChatPanel extends JPanel {
    private static Logger logger = LogManager.getRootLogger();
    private DibujoChatPanel chatPanel;
    private JTextField itemTexto;
    public ServidorClienteChatPanel() {
        Conversacion modelo = Conversacion.getOrCreate();

        this.setLayout(new BorderLayout());

        chatPanel = new DibujoChatPanel();

        JScrollPane scrollDibujo = new JScrollPane(chatPanel);
        scrollDibujo.setPreferredSize(new Dimension(600, 400));
        this.add(scrollDibujo, BorderLayout.CENTER);

        JPanel panelTextoSalida = new JPanel();
        panelTextoSalida.setLayout(new BorderLayout());
        itemTexto = new JTextField();
        panelTextoSalida.add(itemTexto, BorderLayout.CENTER);
        JButton botonEnviar = new JButton("Enviar");
        botonEnviar.addActionListener(e -> {
            String texto = itemTexto.getText();
            if (texto != null && !texto.isEmpty()) {
                modelo.envioMensaje(texto);
                itemTexto.setText("");
            }
        });
        panelTextoSalida.add(botonEnviar, BorderLayout.EAST);

        JButton botonDesconectar = new JButton("Desconectar");
        botonDesconectar.addActionListener(e -> {
            logger.info("Se termina la comunicacion enviando EXIT");
            modelo.envioSalir();
        });
        this.add(botonDesconectar, BorderLayout.NORTH);

        this.add(panelTextoSalida, BorderLayout.SOUTH);
    }

    public void setModelo(Conversacion modelo) {
        modelo.addObserver(chatPanel);
    }
}
