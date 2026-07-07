
public class ArbolBB<T extends Comparable> {
    // elementos
    private T raiz;
    private ArbolBB<T> subArbolIzq;
    private ArbolBB<T> subArbolDer;

    // operaciones
    public ArbolBB() {
        raiz = null;
        subArbolIzq = null;
        subArbolIzq = null;
    }

    public ArbolBB(T raiz, ArbolBB<T> subArbolIzq, ArbolBB<T> subArbolDer) {
        this.raiz = raiz;
        this.subArbolIzq = subArbolIzq;
        this.subArbolDer = subArbolDer;
    }

    public T getRaiz() {
        return raiz;
    }

    public ArbolBB<T> getSubArbolIzq() {
        return subArbolIzq;
    }

    public ArbolBB<T> getSubArbolDer() {
        return subArbolDer;
    }

    public boolean estaVacio() {
        return raiz == null;
    }
    
    /* 
    si es mayor a 0 item es mayor, si es igual es
    igual a raiz, si es menor es menor a raiz compareTo
    */ 
    public void agregar(T item) {
        if (estaVacio()) raiz = item;
        else if (item.compareTo(raiz) < 0) {
            if (subArbolIzq == null) {
                subArbolIzq = new ArbolBB<>(item, null, null);
            } else {
                subArbolIzq.agregar(item);
            }
        } else if (item.compareTo(raiz) > 0) {
            if (subArbolDer == null) {
                subArbolDer = new ArbolBB<>(item, null, null);
            } else {
                subArbolDer.agregar(item);
            }
        } else {
            System.out.print("Error el item ya existe!");
        }
    }

    public void inorden() {
        if (!estaVacio()) {
            if (subArbolIzq!=null) subArbolIzq.inorden();
        }
        System.out.println(raiz + "\t");
        if (subArbolDer!=null) subArbolDer.inorden();        
    }
}
