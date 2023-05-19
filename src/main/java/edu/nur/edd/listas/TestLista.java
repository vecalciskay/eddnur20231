package edu.nur.edd.listas;

import edu.nur.edd.hanoi.objects.Hanoi;

import java.util.Iterator;

public class TestLista {
    public static void main(String[] args) {
        Lista<String> l = new Lista<>();
        l.insertar("Hugo");
        l.insertar("Paco");
        l.insertar("Luis");
        System.out.println(l);


        Iterator<String> i = l.iterator();
        while(i.hasNext()) {
            String s = i.next();
            System.out.println("Obj: " + s);
        }

        for(String s : l) {
            System.out.println("Obj: " + s);
        }

        Lista<String> l2 = new Lista<>();
        l2.agregar("Hugo");
        l2.agregar("Paco");
        l2.agregar("Luis");
        System.out.println(l2);
    }
}
