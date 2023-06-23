package edu.nur.edd.arboles;

import java.util.HashMap;

public class ArbolBinario<E> {
    protected Nodo<E> raiz;
    protected HashMap<Integer, Nodo<E>> nodos;

    public ArbolBinario() {
        nodos = new HashMap<Integer, Nodo<E>>();
        raiz = null;
    }

    /**
     * Este metodo agrega un nodo al arbol. El nodo se agrega como hijo del
     * nodo con id. Si el nodo con id no existe, el nodo se agrega como raiz.
     * @param id
     * @param contenido
     */
    public void agregarNodo(Integer id, E contenido, PosicionNodo posicion) {
        Nodo<E> nuevo = new Nodo<E>(contenido);

        if (raiz == null) {
            raiz = nuevo;
            nodos = new HashMap<Integer, Nodo<E>>();
            nodos.put(contenido.hashCode(), nuevo);
            return;
        }
        Nodo<E> padre = nodos.get(id);
        if (padre == null) {
            raiz = nuevo;
            nodos = new HashMap<Integer, Nodo<E>>();
            nodos.put(contenido.hashCode(), nuevo);
            return;
        }
        if (posicion == PosicionNodo.Izquierda) {
            padre.setIzquierda(nuevo);
            nuevo.setPadre(padre);
        }
        if (posicion == PosicionNodo.Derecha) {
            padre.setDerecha(nuevo);
            nuevo.setPadre(padre);
        }
        nodos.put(contenido.hashCode(), nuevo);
    }

    @Override
    public String toString() {
        if (raiz == null) {
            return "Arbol vacio";
        }
        return raiz.toString();
    }

    public Nodo<E> getRaiz() {
        return raiz;
    }

    public boolean existe(E o) {
        for (Nodo<E> n:
                nodos.values()) {
            if (n.getContenido().equals(o)) {
                return true;
            }
        }
        return false;
    }

    public static class Nodo<E> {
        private int id;
        private Nodo<E> padre;
        private E contenido;
        private Nodo<E> derecha;
        private Nodo<E> izquierda;
        private boolean visitado;

        public Nodo(E contenido) {
            this.padre = null;
            this.id = contenido.hashCode();
            this.contenido = contenido;
            this.izquierda = null;
            this.derecha = null;
        }

        public boolean isVisitado() {
            return visitado;
        }

        public void setVisitado(boolean visitado) {
            this.visitado = visitado;
        }

        public E getContenido() {
            return contenido;
        }

        public Nodo<E> getDerecha() {
            return derecha;
        }
        public Nodo<E> getIzquierda() {
            return izquierda;
        }

        public int getId() {
            return id;
        }

        public void setPadre(Nodo<E> padre) {
            this.padre = padre;
        }

        public void setDerecha(Nodo<E> hijo) {
            derecha = hijo;
        }
        public void setIzquierda(Nodo<E> hijo) {
            izquierda = hijo;
        }

        public String toString() {
            if (contenido instanceof ObjetoAritmetico) {
                return toStringExpresion();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(contenido.toString());
            if (noTieneHijos()) {
                return sb.toString();
            }
            String separator = "";
            sb.append(" (");
            if (izquierda != null) {
                sb.append(separator).append(izquierda);
                separator = ",";
            }
            if (derecha != null) {
                sb.append(separator).append(derecha);
            }
            sb.append(")");

            return sb.toString();
        }

        private String toStringExpresion() {
            StringBuilder sb = new StringBuilder();

            if (noTieneHijos()) {
                return contenido.toString();
            }
            sb.append("(");
            if (izquierda != null) {
                sb.append(izquierda);
            }
            sb.append(contenido.toString());
            if (derecha != null) {
                sb.append(derecha);
            }
            sb.append(")");

            return sb.toString();
        }

        private boolean noTieneHijos() {
            return derecha == null && izquierda == null;
        }
    }
}
