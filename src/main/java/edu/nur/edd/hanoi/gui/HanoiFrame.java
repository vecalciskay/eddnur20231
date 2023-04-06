package edu.nur.edd.hanoi.gui;

import edu.nur.edd.hanoi.objects.Hanoi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HanoiFrame extends JFrame {
    private final Hanoi modelo ;
    public HanoiFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());
        HanoiPanel panel = new HanoiPanel();

        modelo = new Hanoi(3);
        modelo.adjuntarObservador(panel);

        this.getContentPane().add(panel, BorderLayout.CENTER);


        JButton btn = new JButton("Hacer");
        this.getContentPane().add(btn, BorderLayout.SOUTH);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnHacer_clicked();
            }
        });

        this.pack();
        this.setVisible(true);
    }

    private void btnHacer_clicked() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                modelo.resolver(0,2,1,3);
            }
        });
        t.start();
    }

    public static void main(String[] args) {
        HanoiFrame f = new HanoiFrame();
    }
}
