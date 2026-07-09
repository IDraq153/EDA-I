package tda;

public class Nodo<T> {
    private T item;
    private Nodo<T> sgteNodo;

    public Nodo(){
        item = null;
        sgteNodo = null;
    }

    public T getItem() {
        return item;
    }
    public Nodo(T item, Nodo<T> sgteNodo){
        this.item = item;
        this.sgteNodo = sgteNodo;
    }
    public void setItem(T item) {
        this.item = item;
    }

    public Nodo<T> getSgteNodo() {
        return sgteNodo;
    }

    public void setSgteNodo(Nodo<T> sgteNodo) {
        this.sgteNodo = sgteNodo;
    }
}
