
package tdaBi;

import javax.management.RuntimeErrorException;


public class BiCola<T> {
    private Nodo<T> frente;
    private Nodo<T> ultimo;

    // Operacion para crear una cola
    public BiCola() {
        frente = null;
        ultimo = null;
    }
    public boolean estaVacia() {
        return frente == null;
    }
    // Encolar: Agrega un item al final de la cola
    public void encolarAlFinal(T item) {
        Nodo<T> nuevoNodo = new Nodo<>(item,null);
        if (estaVacia()) {
            frente = nuevoNodo;
            ultimo = nuevoNodo;
        } else {
            ultimo.setSgteNodo(nuevoNodo);
            ultimo = nuevoNodo;
        }
    }
    //EncolarAlFrente: Agrega un item al frente de la cola
    public void encolarAlFrente(T item) {
        Nodo<T> nuevNodo = new  Nodo<>(item, null);
        if (estaVacia()) {
            frente = nuevNodo;
            ultimo = nuevNodo;
        } else {
            nuevNodo.setSgteNodo(frente);
            frente = nuevNodo;
        }
    }
    // Desencolar: eliminar el item que esta al frente de la cola y devuelve ese item
    public T desencolarFrente() {
        if (estaVacia()) {
            throw new RuntimeErrorException(null, "Error: la cola esta VACIA!");
        } else {
            T itemAux = frente.getItem();
            frente = frente.getSgteNodo();
            return itemAux;
        }
    }
    
    // DesencolarFinal: eliminar el item que esta al fondo de la cola y devuelve ese item
    public T desencolarFinal() {
        if (estaVacia()) {
            throw new RuntimeErrorException(null, "Error: la cola esta VACIA!");
        } else {
            T itemAux = ultimo.getItem();
            ultimo = ultimo.getSgteNodo();
            return itemAux;
        }
    }
}