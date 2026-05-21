package tda;

public class NodoDoble<T> {
    private T item;
    private NodoDoble<T> sgtNodo;
    private NodoDoble<T> antNodo;

    public NodoDoble() {
        item = null;
        sgtNodo = null;
        antNodo = null;
    }

    public NodoDoble(T item, NodoDoble<T> sgtNodo, NodoDoble<T> antNodo) {
        this.item = item;
        this.sgtNodo = sgtNodo;
        this.antNodo = antNodo;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public NodoDoble<T> getSgtNodo() {
        return sgtNodo;
    }

    public void setSgtNodo(NodoDoble<T> sgtNodo) {
        this.sgtNodo = sgtNodo;
    }

    public NodoDoble<T> getAntNodo() {
        return antNodo;
    }

    public void setAntNodo(NodoDoble<T> antNodo) {
        this.antNodo = antNodo;
    }    
}
