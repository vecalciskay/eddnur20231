package edu.nur.edd.listas;

public class Pila<E> extends ListaDoble<E> {
    public Pila() {
        super();
    }
    public void push(E o) {
        insertar(o);
    }

    public E pop() {
        E o = raiz.getContenido();
        raiz = raiz.getSiguiente();
        if (raiz != null) {
            raiz.setAnterior(null);
        } else {
            cola = null;
        }
        cantidad--;
        return o;
    }
}
