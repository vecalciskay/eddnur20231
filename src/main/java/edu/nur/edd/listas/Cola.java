package edu.nur.edd.listas;

public class Cola<E> extends ListaDoble<E>{
    public Cola() {
        super();
    }

    public void push(E o) {
        insertar(o);
    }
    public E pull() {
        E o = cola.getContenido();
        cola = cola.getAnterior();
        if (cola != null) {
            cola.setSiguiente(null);
        } else {
            raiz = null;
        }
        cantidad--;
        return o;
    }
}
