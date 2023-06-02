package edu.nur.edd.arboles;

import edu.nur.edd.listas.ListaDoble;

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
            nodos.put(contenido.hashCode(), nuevo);
            return;
        }
        Nodo<E> padre = nodos.get(id);
        if (padre == null) {
            raiz = nuevo;
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

    class Nodo<E> {
        private int id;
        private Nodo<E> padre;
        private E contenido;
        private ListaDoble<Nodo<E>> hijos;

        public Nodo(E contenido) {
            this.padre = null;
            this.id = contenido.hashCode();
            this.contenido = contenido;
            hijos = new ListaDoble<Nodo<E>>();
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
