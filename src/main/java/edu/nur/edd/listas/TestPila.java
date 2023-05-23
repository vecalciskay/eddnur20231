package edu.nur.edd.listas;

public class TestPila {
    public static void main(String[] args) {
        Pila<String> l = new Pila<>();
        l.push("Hugo");
        l.push("Paco");
        l.push("Luis");
        System.out.println(l);

        System.out.println("saca " + l.pop());
        System.out.println("saca " + l.pop());
        System.out.println("saca " + l.pop());
        System.out.println(l);
    }
}
