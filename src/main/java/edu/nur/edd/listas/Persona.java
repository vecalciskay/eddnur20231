package edu.nur.edd.listas;

public class Persona implements Comparable<Persona> {
    private String nombre;
    private int edad;

    public Persona(String n, int e) {
        nombre = n;
        edad = e;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
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
