package tda;

public class Pila<T> {
    private Nodo<T> cima; 

    public Pila() {
        cima = null;
    }

    public boolean estaVacia() {
        return cima == null;
    }

    // apilar: agrega un item en la cima de la pila
    public void apilar(T item) {
        Nodo<T> nuevoNodo = new Nodo(item, null);
        if(estaVacia()) {
            cima = nuevoNodo;
        } else {
            nuevoNodo.setSgteNodo(cima);
            cima = nuevoNodo;
        }
    } 
    // desapilar: extrae el item de la cima de la pila devuelve el item
    public T desapilar() {
        if(estaVacia()) throw new RuntimeException("Error: Pila vacia!!");        
        T item = cima.getItem();
        cima = cima.getSgteNodo();
        return item;
    }
}
