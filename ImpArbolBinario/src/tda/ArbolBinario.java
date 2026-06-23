package tda;

public class ArbolBinario<T extends Comparable<?>> {
    private Nodo<T> raiz;
    private int t; // tamaño

    public ArbolBinario() {
        raiz = null;
    }
    public boolean estaVacio() {
        return raiz == null;
    }
    // obtener raiz del arbol
    public Nodo<T> obtRaiz() {
        return raiz;
    }
    // obtener el hijo izquierdo de un determinado nodo
    public Nodo<T> obtHijoIzq(Nodo<T> nodo) {
        if (nodo == null || estaVacio()) 
            throw new RuntimeException("No existe el nodo o el arbol!");
        return nodo.getHijoIzq();
    }
    // obtener el hijo derecho de un determinado nodo
    public Nodo<T> obtHijoDer(Nodo<T> nodo) {
        if (nodo == null || estaVacio()) 
            throw new RuntimeException("No existe el nodo o el arbol!");
        return nodo.getHijoDer();
    }
    // Crear la Raiz del arbol binario
    public Nodo<T> creaRaiz(T item) {
        if (!estaVacio()) 
            throw new RuntimeException("Error, el arbol tiene una raiz");
        Nodo<T> nuevoNodo = new Nodo<>(item, null, null, null);
        raiz = nuevoNodo;
        t++;
        return raiz; 
    }
    //agregar un hijo izq a un nodo especifico
    public Nodo<T> agregarHijoIzq(Nodo<T> padre, T item) {
        if (padre == null) 
            throw new RuntimeException("Nodo nulo");
        if (padre.getHijoIzq() != null) 
            throw new RuntimeException("Nodo con hijo");

        Nodo<T> nuevoNodo = new Nodo<>(item, padre, null, null);
        padre.setHijoIzq(nuevoNodo);
        t++;
        return padre.getHijoIzq();
    }
    //agregar un hijo der a un nodo especifico
    public Nodo<T> agregarHijoDer(Nodo<T> padre, T item) {
        if (padre == null) 
            throw new RuntimeException("Nodo nulo");
        if (padre.getHijoDer() != null) 
            throw new RuntimeException("Nodo con hijo");

        Nodo<T> nuevoNodo = new Nodo<>(item, padre, null, null);
        padre.setHijoDer(nuevoNodo);
        t++;
        return padre.getHijoDer();
    }
}
