package edu.nur.edd.hanoi;

import edu.nur.edd.hanoi.objects.Hanoi;

public class TestHanoi {
    public static void main(String[] args) {
        /*TestHanoi h = new TestHanoi();
        h.resolver(0, 2, 1, 3);*/

        int n = 3;
        Hanoi h = new Hanoi(n);
        System.out.println(h);

        h.resolver(0, 2, 1, n);

        System.out.println(h);
    }

    /**
     * Este metodo devuelve la lista de movimientos que se deben realizar para resolver
     * el problema de las torres de hanoi
     * @param de Torre de origen
     * @param a Torre destino
     * @param pp Torre intermedia
     * @param n Numero de discos
     */
    private void resolver(int de, int a, int pp, int n) {
        if(n == 1) {
            System.out.println(de + " -> " + a);
        } else {
            resolver(de, pp, a, n-1);
            resolver(de,a, pp, 1);
            resolver(pp, a, de, n-1);
        }
    }

    public String resolverHanoi(int de, int a, int pp, int n) {
        StringBuilder sb = new StringBuilder();
        if (n == 1) {
            sb.append(de).append(" -> ").append(a);
        } else {
            sb.append(resolverHanoi(de, pp, a, n - 1));
            sb.append(resolverHanoi(de, a, pp, 1));
            sb.append(resolverHanoi(pp, a, de, n - 1));
        }

        return sb.toString();
    }
}
