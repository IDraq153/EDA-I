package tda;

public class NodoPrioridad<T> {
    private T item;
    private int prioridad;
    private NodoPrioridad<T> sgteNodo;

    public NodoPrioridad() {
        item = null;
        sgteNodo = null;
        prioridad=0;
    }

    public NodoPrioridad(T item, int prioridad, NodoPrioridad<T> sgteNodo) {
        this.item = item;
        this.prioridad=prioridad;
        this.sgteNodo = sgteNodo;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public NodoPrioridad<T> getSgteNodo() {
        return sgteNodo;
    }

    public void setSgteNodo(NodoPrioridad<T> sgteNodo) {
        this.sgteNodo = sgteNodo;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
    
}
