package edu.nur.edd.hanoi.gui;

import edu.nur.edd.hanoi.objects.Anillo;
import edu.nur.edd.hanoi.objects.Hanoi;
import edu.nur.edd.hanoi.objects.Torre;

import java.awt.*;

public class DibujoHanoi {
    private Hanoi modelo;

    public DibujoHanoi(Hanoi modelo) {
        this.modelo = modelo;
    }

    public void dibujar(Graphics g, int x, int y) {
        g.fillRect(x, y - 10, 300, 10);

        int tx = x+50;
        for (Torre t : modelo.getTorres()) {
            dibujarTorre(g, t, tx, y);
            tx += 100;
        }
    }

    private void dibujarTorre(Graphics g, Torre t, int x, int y) {
        g.fillRect(x, y-150, 5, 150);

        int ax = x;
        int ay = y - 30;

        for (Anillo a : t.getAnillos()) {
            g.fillRect(ax - a.getTamano()*10, ay, a.getTamano()*20, 10);
            ay -= 20;
        }
    }
}
