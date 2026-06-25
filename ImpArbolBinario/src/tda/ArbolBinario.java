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

    // agregar un hijo izq a un nodo especifico
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

    // agregar un hijo der a un nodo especifico
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

    // obtener tamaño
    public int tamanio() {
        return t;
    }

    // recorrido en pre-orden de raiz luego a izquierda luego derecha
    public void preOrden(Nodo<T> nodoRaiz) {
        if (nodoRaiz != null) {
            System.out.print(nodoRaiz.getItem() + "    ");
            // Recorrido en preorden del sub arbol izquierdo
            preOrden(nodoRaiz.getHijoIzq());
            // Recorrido en preorden del sub arbol derecho
            preOrden(nodoRaiz.getHijoDer());
        }
    }

    // in-orden va de izquierda a raiz luego derecha
    public void inOrden(Nodo<T> nodo) {
        if (nodo != null) {
            inOrden(nodo.getHijoIzq());
            System.out.print(nodo.getItem() + "    ");
            inOrden(nodo.getHijoDer());
        }
    }

    // pos-orden va de izquierda a derecha finalmente la raiz
    public void posOrden(Nodo<T> nodo) {
        if (nodo != null) {
            posOrden(nodo.getHijoIzq());
            posOrden(nodo.getHijoDer());
            System.out.print(nodo.getItem() + "    ");
        }
    }

    // 2) Contar nodos del arbol
    public int contarNodosArbol() {
        return contarNodosArbol(this.raiz);
    }

    private int contarNodosArbol(Nodo<T> nodo) {
        if (nodo == null)
            return 0;
        else {
            return 1 + contarNodosArbol(nodo.getHijoIzq()) +
                    contarNodosArbol(nodo.getHijoDer());
        }
    }

    // 3) Imprime todos los nodos derechos
    public void listarHijosDerecha() {
        if (estaVacio())
            throw new RuntimeException("El arbol esta vacio!");
        imprimeDerechaRecursivo(this.raiz);
    }

    private void imprimeDerechaRecursivo(Nodo<T> nodo) {
        if (nodo != null) {
            if (nodo.getHijoDer() != null) {
                System.out.print(nodo.getHijoDer().getItem() + "    ");
            }
            imprimeDerechaRecursivo(nodo.getHijoDer());
            imprimeDerechaRecursivo(nodo.getHijoIzq());
        }
    }

    // 4) Cantidad de nodos que tienen un solo hijo
    public int unSoloHijo() {
        if (estaVacio())
            throw new RuntimeException("El arbol esta vacio!");
        return unSoloHijoRecursivo(this.raiz);
    }

    private int unSoloHijoRecursivo(Nodo<T> nodo) {
        if (nodo == null)
            return 0;
        boolean tieneUnHijo = ((nodo.getHijoDer() != null) && (nodo.getHijoIzq() == null)
                || (nodo.getHijoDer() == null) && (nodo.getHijoIzq() != null));

        int contaNodo = tieneUnHijo ? 1 : 0;
        return contaNodo +
                unSoloHijoRecursivo(nodo.getHijoDer()) +
                unSoloHijoRecursivo(nodo.getHijoIzq());
    }

    // 5) Cantidad de ambos hijos de un nodo
    public int ambosHijos() {
        if (estaVacio())
            throw new RuntimeException("El arbol esta vacio!");
        return contarAmbosHijosRecursivo(this.raiz);
    }

    private int contarAmbosHijosRecursivo(Nodo<T> nodo) {
        if (nodo == null)
            return 0;

        int contaActual;
        if (nodo.getHijoDer() != null && nodo.getHijoIzq() != null)
            contaActual = 1;
        else
            contaActual = 0;

        return contaActual +
                contarAmbosHijosRecursivo(nodo.getHijoDer()) +
                contarAmbosHijosRecursivo(nodo.getHijoIzq());
    }

    // 6) Busqueda de elemento X
    public boolean buscar(T item) {
        return buscar(raiz, item);
    }

    public boolean buscar(Nodo<T> nodo, T item) {
        if (nodo != null) {
            if (nodo.getItem().equals(item))
                return true;
            else
                return buscar(nodo.getHijoIzq(), item) ||
                       buscar(nodo.getHijoDer(), item);
        } else
            return false;
    }
}
