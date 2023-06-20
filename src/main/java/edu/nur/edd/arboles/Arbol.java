package edu.nur.edd.arboles;

import edu.nur.edd.listas.Cola;
import edu.nur.edd.listas.ListaDoble;
import edu.nur.edd.listas.Pila;

import java.util.HashMap;

public class Arbol<E> {
    private Nodo<E> raiz;
    private HashMap<Integer,Nodo<E>> nodos;

    public Arbol() {
        nodos = new HashMap<Integer,Nodo<E>>();
        raiz = null;
    }

    /**
     * Este metodo agrega un nodo al arbol. El nodo se agrega como hijo del
     * nodo con id. Si el nodo con id no existe, el nodo se agrega como raiz.
     * @param id
     * @param contenido
     */
    public void agregarNodo(Integer id, E contenido) {
        Nodo<E> nuevo = new Nodo<E>(contenido);

        if (raiz == null) {
            raiz = nuevo;
            nodos = new HashMap<Integer,Nodo<E>>();
            nodos.put(contenido.hashCode(), nuevo);
            return;
        }
        Nodo<E> padre = nodos.get(id);
        if (padre == null) {
            raiz = nuevo;
            nodos = new HashMap<Integer,Nodo<E>>();
            nodos.put(contenido.hashCode(), nuevo);
            return;
        }
        padre.agregarHijo(nuevo);
        nuevo.setPadre(padre);
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

    public void bfs() {
        for (Nodo<E> nodo:
             nodos.values()) {
            nodo.setVisitado(false);
        }

        Cola<Nodo<E>> visitar = new Cola<>();
        visitar.push(raiz);
        while(visitar.tamano() > 0) {
            Nodo<E> nodoAVisitar = visitar.pull();
            // ----------------------------------------------
            // Aqui visitamos el nodo y hacemos algo
            System.out.print(nodoAVisitar.getContenido() + " ");
            // ----------------------------------------------
            nodoAVisitar.setVisitado(true);
            for(Nodo<E> hijo : nodoAVisitar.getHijos()) {
                if (hijo.isVisitado())
                {
                    continue;
                }
                visitar.push(hijo);
            }
        }
    }

    public void dfs() {
        for (Nodo<E> nodo:
                nodos.values()) {
            nodo.setVisitado(false);
        }

        Pila<Nodo<E>> visitar = new Pila<>();
        visitar.push(raiz);
        while(visitar.tamano() > 0) {
            Nodo<E> nodoAVisitar = visitar.pop();
            // ----------------------------------------------
            // Aqui visitamos el nodo y hacemos algo
            System.out.print(nodoAVisitar.getContenido() + " ");
            // ----------------------------------------------
            nodoAVisitar.setVisitado(true);
            for(Nodo<E> hijo : nodoAVisitar.getHijos()) {
                if (hijo.isVisitado())
                {
                    continue;
                }
                visitar.push(hijo);
            }
        }
    }

    public static class Nodo<E> {
        private int id;
        private Nodo<E> padre;
        private E contenido;
        private ListaDoble<Nodo<E>> hijos;
        private boolean visitado;

        public Nodo(E contenido) {
            this.padre = null;
            this.id = contenido.hashCode();
            this.contenido = contenido;
            hijos = new ListaDoble<Nodo<E>>();
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

        public ListaDoble<Nodo<E>> getHijos() {
            return hijos;
        }

        public int getId() {
            return id;
        }

        public void setPadre(Nodo<E> padre) {
            this.padre = padre;
        }

        public void agregarHijo(Nodo<E> hijo) {
            hijos.insertar(hijo);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(contenido.toString());
            if (hijos.tamano() == 0) {
                return sb.toString();
            }
            String separator = "";
            sb.append(" (");
            for (Nodo<E> hijo : hijos) {
                sb.append(separator).append(hijo);
                separator = ",";
            }
            sb.append(")");

            return sb.toString();
        }
    }
}
