package edu.nur.edd.archivos;

import edu.nur.edd.arboles.Arbol;

import java.io.File;

public class TestLectorArbol {
    public static void main(String[] args) throws Exception {
        File archivo = new File("C:\\Users\\Aula-106\\prog3\\practicos\\p5\\arbol.txt");
        if (!archivo.exists() || !archivo.canRead()) {
            System.out.println("No existe o no podemos leer");
            System.exit(0);
        }
        LectorArbol lector = new LectorArbol(archivo);
        Arbol<String> arbol = lector.leer();

        arbol.existe("Hugo");

        System.out.println(arbol);
    }

}
