package tda;

public class NodoA<T> {
    private T item;
    private NodoA<T> padre;
    private NodoA<T> hijoIzq;
    private NodoA<T> hijoDer;

    public NodoA(T item, NodoA<T> padre, NodoA<T> hijoIzq, NodoA<T> hijoDer) {
        this.item = item;
        this.padre = padre;
        this.hijoIzq = hijoIzq;
        this.hijoDer = hijoDer;
    }
    public NodoA() {
        this.item = null;
        this.padre = null;
        this.hijoDer = null;
        this.padre = null;
    }

    public T getItem() {
        return item;
    }
    public void setItem(T item) {
        this.item = item;
    }
    public NodoA<T> getPadre() {
        return padre;
    }
    public void setPadre(NodoA<T> padre) {
        this.padre = padre;
    }
    public NodoA<T> getHijoIzq() {
        return hijoIzq;
    }
    public void setHijoIzq(NodoA<T> hijoIzq) {
        this.hijoIzq = hijoIzq;
    }
    public NodoA<T> getHijoDer() {
        return hijoDer;
    }
    public void setHijoDer(NodoA<T> hijoDer) {
        this.hijoDer = hijoDer;
    }
}
