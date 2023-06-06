package edu.nur.edd.listas;

import java.util.HashMap;

public class TestHashtable {
    public static void main(String[] args) {
        HashMap<String, Persona> tabla = new HashMap<String, Persona>();
        tabla.put("A-123", new Persona(5684951, "Hugo", 10));
        tabla.put("B-456", new Persona(6674952, "Paco", 15));
        tabla.put("C-789", new Persona(7764953, "Luis", 14));
        tabla.put("D-753", new Persona(8854954, "Luis", 19));
        tabla.put("B-456", new Persona(7764953, "Pedro", 14));

        System.out.println("Buscar: 7764953");
        Persona p = tabla.get("B-456");
        System.out.println("Encontrado: " + p);
    }
}
