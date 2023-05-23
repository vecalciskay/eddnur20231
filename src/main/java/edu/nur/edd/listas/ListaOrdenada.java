package edu.nur.edd.listas;

public class ListaOrdenada<E> extends ListaDoble<E> {
    public ListaOrdenada() {
        super();
    }

    public void insertar(E o) {
        if (raiz == null) {
            super.insertar(o);
            return;
        }
        if (!(o instanceof Comparable)) {
            super.insertar(o);
            return;
        }
        Comparable comparableO = (Comparable)o;
        Nodo<E> nuevo = new Nodo<E>(o);
        Nodo<E> actual = raiz;
        if (comparableO.compareTo(raiz.getContenido()) < 0) {
            super.insertar(o);
            return;
        }
        while(comparableO.compareTo(
                actual.getSiguiente().getContenido()) >= 0) {
            actual = actual.getSiguiente();
        }

        nuevo.setSiguiente(actual.getSiguiente());
        actual.getSiguiente().setAnterior(nuevo);
        actual.setSiguiente(nuevo);
        nuevo.setAnterior(actual);

        cantidad++;
    }
}
