package edu.nur.edd.listas;

import java.util.Iterator;

public class ListaDoble<E> implements Iterable<E> {
    protected Nodo<E> raiz;
    protected Nodo<E> cola;
    protected int cantidad;
    public ListaDoble() {
        raiz = null;
        cola = null;
        cantidad = 0;
    }
    public void insertar(E o) {
        Nodo<E> nuevo = new Nodo<>(o);
        nuevo.setSiguiente(raiz);
        if (raiz != null) {
            raiz.setAnterior(nuevo);
        } else {
            cola = nuevo;
        }
        raiz = nuevo;
        cantidad++;
    }

    public int tamano() {
        return cantidad;
    }
    @Override
    public Iterator<E> iterator() {
        return null;
    }

    public String toString() {
        if (raiz == null ) {
            return "(" + cantidad + ") [VACIA]";
        }
        StringBuilder resultado = new StringBuilder();
        resultado.append("(").append(tamano()).append(") : ");
        Nodo<E> actual = raiz;
        while(actual != null) {
            resultado.append(actual).append(" --> ");
            actual = actual.getSiguiente();
        }
        return resultado.toString();
    }

    class Nodo<E> {
        private E contenido;
        private Nodo<E> siguiente;
        private Nodo<E> anterior;

        public Nodo(E o) {
            contenido = o;
            siguiente = null;
            anterior = null;
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

        public Nodo<E> getAnterior() {
            return anterior;
        }

        public void setAnterior(Nodo<E> anterior) {
            this.anterior = anterior;
        }
        @Override
        public String toString() {
            return contenido.toString();
        }
    }

    class ListaDobleIterator<E> implements Iterator<E> {

        private Nodo<E> actual;

        public ListaDobleIterator(Nodo<E> r) {
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
