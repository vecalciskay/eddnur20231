package edu.nur.edd.listas;

public class TestCola {

    public static void main(String[] args) {
        Cola<String> l = new Cola<>();
        l.push("Hugo");
        l.push("Paco");
        l.push("Luis");
        System.out.println(l);

        System.out.println("saca " + l.pull());
        System.out.println("saca " + l.pull());
        System.out.println("saca " + l.pull());
        System.out.println(l);
    }
}
