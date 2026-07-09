public class Nodo<T> {
    // ATRIBUTOS
    private T item; // Datos
    private Nodo<T> sgteNodo;       // Puntero
    // METODOS
    public Nodo(){
        this.item = null;
        this.sgteNodo = null;
    }
    public Nodo(T item, Nodo<T> sgteNodo){
        this.item = item;
        this.sgteNodo = sgteNodo;
    }

    public T getItem() {
        return item;
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
