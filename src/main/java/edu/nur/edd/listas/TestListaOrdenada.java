package edu.nur.edd.listas;

public class TestListaOrdenada {
    public static void main(String[] args) {
        testStrings();

        testPersonas();
    }

    private static void testPersonas() {
        ListaOrdenada<Persona> lista = new ListaOrdenada<Persona>();
        lista.insertar(new Persona(2216565,"Hugo", 10));
        lista.insertar(new Persona(6623621,"Paco", 15));
        lista.insertar(new Persona(9989456,"Luis", 14));
        lista.insertar(new Persona(5561584,"Luis", 19));
        lista.insertar(new Persona(5651578,"Mickey", 50));
        lista.insertar(new Persona(3326589,"Mickey", 30));
        lista.insertar(new Persona(6625874,"Goofy", 70));

        System.out.println("Lista ordenada: " + lista);
    }

    private static void testStrings() {
        ListaOrdenada<String> lista = new ListaOrdenada<String>();
        lista.insertar("Hugo");
        lista.insertar("Paco");
        lista.insertar("Luis");
        lista.insertar("Donald");
        lista.insertar("Mickey");
        lista.insertar("Minnie");
        lista.insertar("Goofy");
        lista.insertar("Pluto");

        System.out.println("Lista ordenada: " + lista);
    }
}
