package edu.nur.edd.redes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorBasico {
    public static void main(String[] args) throws Exception {
        ServerSocket srv = new ServerSocket(4949);

        Socket sck = srv.accept();

        PrintWriter out = new PrintWriter( sck.getOutputStream());

        InputStreamReader reader = new InputStreamReader(sck.getInputStream());
        BufferedReader in = new BufferedReader(reader);

        String nombre = in.readLine();
        System.out.println(" --<<-- " + nombre);

        out.println("Hola, como estas " + nombre);
        out.flush();
        System.out.println(" -->>-- Hola, como estas " + nombre);
        sck.close();
        srv.close();
    }
}
