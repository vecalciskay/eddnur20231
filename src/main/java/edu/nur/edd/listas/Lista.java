package edu.nur.edd.listas;

import java.util.Iterator;

public class Lista<E> implements Iterable<E> {
    private Nodo<E> raiz;

    public Lista() {
        raiz = null;
    }

    public void insertar(E o) {
        Nodo<E> nuevo = new Nodo<>(o);
        nuevo.setSiguiente(raiz);
        raiz = nuevo;
    }

    public void agregar(E o) {
        if (raiz == null) {
            insertar(o);
            return;
        }

        Nodo<E> actual = raiz;
        while(actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }

        Nodo<E> nuevo = new Nodo<>(o);
        actual.setSiguiente(nuevo);
    }

    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder();
        Nodo<E> actual = raiz;
        while(actual != null) {
            resultado.append(actual).append(" --> ");
            actual = actual.getSiguiente();
        }
        return resultado.toString();
    }

    public Iterator<E> iterator() {
        return new ListaIterator<>(raiz);
    }

    class Nodo<E> {
        private E contenido;
        private Nodo<E> siguiente;

        public Nodo(E o) {
            contenido = o;
            siguiente = null;
        }

        public E getContenido() {
            return contenido;
        }

        public void setContenido(E contenido) {
            this.contenido = contenido;
        }

        public Nodo<E> getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo<E> siguiente) {
            this.siguiente = siguiente;
        }

        @Override
        public String toString() {
            return contenido.toString();
        }
    }

    class ListaIterator<E> implements Iterator<E> {

        private Nodo<E> actual;

        public ListaIterator(Nodo<E> r) {
            actual = r;
        }

        @Override
        public boolean hasNext() {
            return actual != null;
        }

        @Override
        public E next() {
            E obj = actual.getContenido();
            actual = actual.getSiguiente();
            return obj;
        }
    }
}
