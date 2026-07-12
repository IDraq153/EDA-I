
@SuppressWarnings("rawtypes")
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
    @SuppressWarnings("unchecked")
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
        if (estaVacio())  throw new RuntimeException("Arbol vacio!");    
        if (subArbolIzq!=null) subArbolIzq.inorden();
        System.out.print(raiz + "\t");
        if (subArbolDer!=null) subArbolDer.inorden();        
    }
    
    public void preorden() {
        if (estaVacio())  throw new RuntimeException("Arbol vacio!");    
        System.out.print(raiz + "\t");
        if (subArbolIzq!=null) subArbolIzq.preorden();
        if (subArbolDer!=null) subArbolDer.preorden();            
    }
    
    public void posorden() {
        if (estaVacio())  throw new RuntimeException("Arbol vacio!");    
        if (subArbolIzq!=null) subArbolIzq.posorden();
        if (subArbolDer!=null) subArbolDer.posorden();
        System.out.print(raiz + "\t");
    }

    public T min() {
        if (estaVacio()) throw new RuntimeException("Errors arbol vacios");    
        else {
            if (subArbolIzq == null) return raiz;
            else return subArbolIzq.min();
        }
    }

    public T max() {
        if(estaVacio()) throw new RuntimeException("Error arbol vacio");
        else{   
            if(subArbolDer==null) return raiz;
            else return subArbolDer.max();
        }
    }

    public Pila<T> mayoresque(T x){
        Pila<T> pila =new Pila<>();
        obtenerMayoresque(x,pila);
        return pila;    
    }
    private void obtenerMayoresque(T x, Pila<T> pila){
        if(estaVacio()) return;       
        if(subArbolIzq!=null) subArbolIzq.obtenerMayoresque(x, pila);
        if(raiz.compareTo(x)>0) pila.apilar(raiz);
        if(subArbolDer!=null) subArbolDer.obtenerMayoresque(x, pila);   
    }

    public void mostrarAntecesores(T item){
        if(!estaVacio()){
            int comparacion = item.compareTo(raiz);

            if(comparacion<0){  
                System.out.println(raiz+"");
                if(subArbolIzq!=null) subArbolIzq.mostrarAntecesores(item);
            } else if(comparacion>0) {
                System.out.println(raiz+"");
                if(subArbolDer!=null) subArbolDer.mostrarAntecesores(item);
            }   
        }   
    }

    public boolean buscar(T item) {
        if (item.compareTo(raiz) == 0) {
            return true;
        } else if (item.compareTo(raiz) < 0) {
            return subArbolIzq != null && subArbolIzq.buscar(item);
        } else {
            return subArbolDer != null && subArbolDer.buscar(item);
        }
    }

    public void eliminar(T item) {
        if (estaVacio()) throw new RuntimeException("Error arbol vacio");
        
        // arbol no vacio
        if (item.compareTo(raiz) == 0) {
            if (subArbolIzq == null && subArbolDer == null) {
                raiz = null;
            } else if (subArbolIzq != null && subArbolDer == null) {
                raiz = subArbolIzq.getRaiz();
                subArbolDer = subArbolIzq.getSubArbolDer();
                subArbolIzq = subArbolIzq.getSubArbolIzq();
            } else if (subArbolIzq == null && subArbolDer != null) {
                raiz = subArbolDer.getRaiz();
                subArbolIzq = subArbolDer.getSubArbolIzq();
                subArbolDer = subArbolDer.getSubArbolDer();
            } else if (subArbolIzq != null && subArbolDer != null) {
                T itemMin = subArbolDer.min();
                raiz = itemMin;
                subArbolDer.eliminar(itemMin);
            } 
        } else if (item.compareTo(raiz) < 0) {
            if (subArbolIzq != null) {
                subArbolIzq.eliminar(item);
            }
        } else if (item.compareTo(raiz) > 0) {
            if (subArbolDer != null) {
                subArbolDer.eliminar(item);
            }
        } 
    }

    public void registrarNota(T item) {
        if (estaVacio()) raiz = item;
    }
}
