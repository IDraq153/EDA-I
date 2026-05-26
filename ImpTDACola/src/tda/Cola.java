package src.tda;

import javax.management.RuntimeErrorException;

public class Cola<T> {
    private Nodo<T> frente;
    private Nodo<T> ultimo;

    // Operacion para crear una cola
    public Cola() {
        frente = null;
        ultimo = null;
    }
    public boolean estaVacia() {
        return frente == null;
    }
    // Encolar: Agrega un item al final de la cola
    public void encolar(T item) {
        Nodo<T> nuevoNodo = new Nodo<>(item,null);
        if (estaVacia()) {
            frente = nuevoNodo;
            ultimo = nuevoNodo;
        } else {
            ultimo.setSgteNodo(nuevoNodo);
            ultimo = nuevoNodo;
        }
    }
    // Desencolar: eliminar el item que esta al frente de la cola y devuelve ese item
    public T desencolar() {
        if (estaVacia()) {
            throw new RuntimeErrorException(null, "Error: la cola esta VACIA!");
        } else {
            T itemAux = frente.getItem();
            frente = frente.getSgteNodo();
            return itemAux;
        }
    }
}
