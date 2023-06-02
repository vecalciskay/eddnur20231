package edu.nur.edd.listas;

public class Persona implements Comparable<Persona> {
    private long ci;
    private String nombre;
    private int edad;

    public Persona(long ci, String n, int e) {
        this.ci = ci;
        nombre = n;
        edad = e;
    }

    @Override
    public String toString() {
        return nombre + " (" + edad + ")";
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public int compareTo(Persona o) {
        int comparaNombres = nombre.compareTo(o.getNombre());
        if (comparaNombres == 0) {
            if (edad > o.getEdad()) {
                return 1;
            }
            if (edad < o.getEdad()){
                return -1;
            }
            return 0;
        }
        return comparaNombres;
    }
}
