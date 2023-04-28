package edu.nur.edd.expreg;

public class TestExpReg {
    public static void main(String[] args) {
        String[] frases = {
                "algo@acme.com","esta es una frase",
                "malo909@slkkd.org"
        };

        String regex = "^[a-z0-9]+@[a-z0-9]+\\.(com|org)$";

        for (String s:
             frases) {
            if (s.matches(regex)) {
                System.out.println(s + " es un correo");
            } else {
                System.out.println(s + " es cualquier cosa");
            }
        }
    }
}
