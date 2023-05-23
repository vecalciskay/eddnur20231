package edu.nur.edd.listas;

public class TestListaDoble {
    public static void main(String[] args) {
        ListaDoble<String> l = new ListaDoble<>();
        l.insertar("Hugo");
        l.insertar("Paco");
        l.insertar("Luis");
        System.out.println(l);
    }
}
