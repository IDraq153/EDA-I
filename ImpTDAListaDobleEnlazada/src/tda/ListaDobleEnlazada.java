package tda;

public class ListaDobleEnlazada<T> {
    //ATRIBUTOS
    private NodoDoble<T> cabeza;
    private NodoDoble<T> ultimo;
    
    //CONSTRUCTOR
    public ListaDobleEnlazada() {
        cabeza = null;
        ultimo = null;
    }
    
    //OPERACIONES
    //estaVacia: comprueba si la lista contiene elementos
    public boolean estaVacia() {
        return cabeza == null;
    }
    //agregarAlFinal: agrega elemento al final de la lista
    public void agregarAlFinal(T item) {
        NodoDoble<T> nuevoNodo = new NodoDoble(item, null, null);

        if (estaVacia()) {
            cabeza = nuevoNodo;
            ultimo = nuevoNodo;
            return;
        } else {
            ultimo.setSgtNodo(nuevoNodo);
            nuevoNodo.setAntNodo(ultimo);
            ultimo =  nuevoNodo;
        }
    }
    //mostrar: muestra los elementos de la lista en pantalla
    public void mostrar() {
        NodoDoble<T> aux = cabeza;

        while (aux!=null) {
            System.out.print(aux.getItem()+"\t");
            aux = aux.getSgtNodo();
        }
    }
    //mostrarInvertir: muestra los elementos de forma invertida en pantalla
    public void mostrarInvertido() {
        NodoDoble<T> aux = ultimo;

        while (aux!=null) {
            System.out.print(aux.getItem()+"\t");
            aux = aux.getAntNodo();
        }
    }
}