package edu.nur.edd.arboles;

import edu.nur.edd.archivos.LectorArbol;

import java.io.File;

public class TestDfs {
    public static void main(String[] args) throws Exception {
        File archivo = new File("C:\\Users\\Aula-106\\prog3\\practicos\\p5\\dfs.txt");
        if (!archivo.exists() || !archivo.canRead()) {
            System.out.println("No existe o no podemos leer");
            System.exit(0);
        }
        LectorArbol lector = new LectorArbol(archivo);
        Arbol<String> arbol = lector.leer();

        System.out.println("BFS");
        arbol.bfs();
        System.out.println();
        System.out.println("DFS");
        arbol.dfs();
    }
}
