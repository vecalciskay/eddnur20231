package edu.nur.edd.listas;

import java.util.HashMap;

public class TestHashtable {
    public static void main(String[] args) {
        HashMap<Long, Persona> tabla = new HashMap<Long, Persona>();
        tabla.put(Long.valueOf(5684951), new Persona(5684951, "Hugo", 10));
        tabla.put(Long.valueOf(6674952), new Persona(6674952, "Paco", 15));
        tabla.put(Long.valueOf(7764953), new Persona(7764953, "Luis", 14));
        tabla.put(Long.valueOf(8854954), new Persona(8854954, "Luis", 19));

        System.out.println("Buscar: 7764953");
        Persona p = tabla.get(Long.valueOf(7764953));
        System.out.println("Encontrado: " + p);
    }
}
