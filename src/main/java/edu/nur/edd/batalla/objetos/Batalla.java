package edu.nur.edd.batalla.objetos;

import edu.nur.edd.batalla.red.Protocolo;

import java.awt.*;

public class Batalla {
    private static Batalla instancia;
    private Jugador local;
    private Jugador remoto;
    private Protocolo protocolo;
    public static Batalla getOrCreate() {
        if (instancia == null) {
            instancia = new Batalla();
        }
        return instancia;
    }

    private Batalla() {
        local = new Jugador(Color.red);
        remoto = new Jugador(Color.blue);
        protocolo = null;
    }

    public Jugador getLocal() {
        return local;
    }

    public Jugador getRemoto() {
        return remoto;
    }

    public Protocolo getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(Protocolo protocolo) {
        this.protocolo = protocolo;
    }

    public void enviarPiezasInicial() {
        protocolo.enviarMensaje(Protocolo.PIEZAS,local.getPiezasParaRed());
    }
}
