package tda;

import java.util.LinkedList;
import java.util.Queue;

public class ArbolBinario<T extends Comparable<?>> {
    private NodoA<T> raiz;
    private int t; // tamaño

    public ArbolBinario() {
        raiz = null;
    }

    public boolean estaVacio() {
        return raiz == null;
    }

    // obtener raiz del arbol
    public NodoA<T> obtRaiz() {
        return raiz;
    }

    // obtener el hijo izquierdo de un determinado NodoA
    public NodoA<T> obtHijoIzq(NodoA<T> NodoA) {
        if (NodoA == null || estaVacio())
            throw new RuntimeException("No existe el NodoA o el arbol!");
        return NodoA.getHijoIzq();
    }

    // obtener el hijo derecho de un determinado NodoA
    public NodoA<T> obtHijoDer(NodoA<T> NodoA) {
        if (NodoA == null || estaVacio())
            throw new RuntimeException("No existe el NodoA o el arbol!");
        return NodoA.getHijoDer();
    }

    // Crear la Raiz del arbol binario
    public NodoA<T> creaRaiz(T item) {
        if (!estaVacio())
            throw new RuntimeException("Error, el arbol tiene una raiz");
        NodoA<T> nuevoNodoA = new NodoA<>(item, null, null, null);
        raiz = nuevoNodoA;
        t++;
        return raiz;
    }

    // agregar un hijo izq a un NodoA especifico
    public NodoA<T> agregarHijoIzq(NodoA<T> padre, T item) {
        if (padre == null)
            throw new RuntimeException("NodoA nulo");
        if (padre.getHijoIzq() != null)
            throw new RuntimeException("NodoA con hijo");

        NodoA<T> nuevoNodoA = new NodoA<>(item, padre, null, null);
        padre.setHijoIzq(nuevoNodoA);
        t++;
        return padre.getHijoIzq();
    }

    // agregar un hijo der a un NodoA especifico
    public NodoA<T> agregarHijoDer(NodoA<T> padre, T item) {
        if (padre == null)
            throw new RuntimeException("NodoA nulo");
        if (padre.getHijoDer() != null)
            throw new RuntimeException("NodoA con hijo");

        NodoA<T> nuevoNodoA = new NodoA<>(item, padre, null, null);
        padre.setHijoDer(nuevoNodoA);
        t++;
        return padre.getHijoDer();
    }

    // obtener tamaño
    public int tamanio() {
        return t;
    }

    // recorrido en pre-orden de raiz luego a izquierda luego derecha
    public void preOrden(NodoA<T> NodoARaiz) {
        if (NodoARaiz != null) {
            System.out.print(NodoARaiz.getItem() + "    ");
            // Recorrido en preorden del sub arbol izquierdo
            preOrden(NodoARaiz.getHijoIzq());
            // Recorrido en preorden del sub arbol derecho
            preOrden(NodoARaiz.getHijoDer());
        }
    }

    // in-orden va de izquierda a raiz luego derecha
    public void inOrden(NodoA<T> NodoA) {
        if (NodoA != null) {
            inOrden(NodoA.getHijoIzq());
            System.out.print(NodoA.getItem() + "    ");
            inOrden(NodoA.getHijoDer());
        }
    }

    // pos-orden va de izquierda a derecha finalmente la raiz
    public void posOrden(NodoA<T> NodoA) {
        if (NodoA != null) {
            posOrden(NodoA.getHijoIzq());
            posOrden(NodoA.getHijoDer());
            System.out.print(NodoA.getItem() + "    ");
        }
    }

    // 2) Contar NodoAs del arbol
    public int contarNodoAsArbol() {
        return contarNodoAsArbol(this.raiz);
    }
    private int contarNodoAsArbol(NodoA<T> NodoA) {
        if (NodoA == null)
            return 0;
        else {
            return 1 + contarNodoAsArbol(NodoA.getHijoIzq()) +
                    contarNodoAsArbol(NodoA.getHijoDer());
        }
    }

    // 3) Imprime todos los NodoAs derechos
    public void listarHijosDerecha() {
        if (estaVacio())
            throw new RuntimeException("El arbol esta vacio!");
        imprimeDerechaRecursivo(this.raiz);
    }
    private void imprimeDerechaRecursivo(NodoA<T> NodoA) {
        if (NodoA != null) {
            if (NodoA.getHijoDer() != null) {
                System.out.print(NodoA.getHijoDer().getItem() + "    ");
            }
            imprimeDerechaRecursivo(NodoA.getHijoDer());
            imprimeDerechaRecursivo(NodoA.getHijoIzq());
        }
    }

    // 4) Cantidad de NodoAs que tienen un solo hijo
    public int unSoloHijo() {
        if (estaVacio())
            throw new RuntimeException("El arbol esta vacio!");
        return unSoloHijoRecursivo(this.raiz);
    }
    private int unSoloHijoRecursivo(NodoA<T> NodoA) {
        if (NodoA == null)
            return 0;
        boolean tieneUnHijo = ((NodoA.getHijoDer() != null) && (NodoA.getHijoIzq() == null)
                || (NodoA.getHijoDer() == null) && (NodoA.getHijoIzq() != null));
        int contaNodoA = tieneUnHijo ? 1 : 0;
        
        return contaNodoA +
                unSoloHijoRecursivo(NodoA.getHijoDer()) +
                unSoloHijoRecursivo(NodoA.getHijoIzq());
    }

    // 5) Cantidad de ambos hijos de un NodoA
    public int ambosHijos() {
        if (estaVacio())
            throw new RuntimeException("El arbol esta vacio!");
        return contarAmbosHijosRecursivo(this.raiz);
    }
    private int contarAmbosHijosRecursivo(NodoA<T> NodoA) {
        if (NodoA == null) return 0;
        
        boolean tieneAmbosHijos = ((NodoA.getHijoDer() != null && NodoA.getHijoIzq() != null));
        int contaActual = tieneAmbosHijos ? 1 : 0;

        return contaActual +
                contarAmbosHijosRecursivo(NodoA.getHijoDer()) +
                contarAmbosHijosRecursivo(NodoA.getHijoIzq());
    }

    // 6) Busqueda de elemento X
    public boolean buscar(T item) {
        return buscar(raiz, item);
    }
    public boolean buscar(NodoA<T> NodoA, T item) {
        if (NodoA != null) {
            if (NodoA.getItem().equals(item))
                return true;
            else
                return buscar(NodoA.getHijoIzq(), item) ||
                       buscar(NodoA.getHijoDer(), item);
        } else
            return false;
    }

    public int nodosSinHijosRecursivo() {
        if (estaVacio()) throw new RuntimeException("Arbol vacio!");
        return SinHijosRecursivo(raiz);
    }
    private int SinHijosRecursivo(NodoA<T> nodo) {
        if (nodo.getHijoIzq() != null && nodo.getHijoDer() != null) {
            return SinHijosRecursivo(nodo.getHijoIzq()) +
                   SinHijosRecursivo(nodo.getHijoDer());
        } else if (nodo.getHijoIzq() != null && nodo.getHijoDer() == null) {
            return SinHijosRecursivo(nodo.getHijoIzq());
        } else if (nodo.getHijoIzq() == null && nodo.getHijoDer() != null) {
            return SinHijosRecursivo(nodo.getHijoDer());
        } else {
            return 1;
        }
    }

    public void recoPrimeroAncho() {
        if (estaVacio()) throw new RuntimeException("Arbol vacio!");
        Queue<NodoA<T>> cola = new LinkedList<>();
        cola.offer(raiz);
        recorridoAnchoRecursivo(cola);
    }
    private void recorridoAnchoRecursivo(Queue<NodoA<T>> cola) {
        if (cola.isEmpty()) return;

        NodoA<T> actual = cola.poll();
        System.out.print(actual.getItem() + "    ");

        if (actual.getHijoIzq() != null) 
            cola.offer(actual.getHijoIzq());
        if (actual.getHijoDer() != null) 
            cola.offer(actual.getHijoDer());   

        recorridoAnchoRecursivo(cola);
    }

    public void remplazoProm(String NN, float promedio) {
        if (estaVacio()) throw new RuntimeException("El arbol esta vacio");
        if (remplazoPromRecu(NN, promedio, (NodoA<Alumno>) raiz)) {
            System.out.println("Promedio Actualizado!");
        } 
    }
    private boolean remplazoPromRecu(String NN, float prom, NodoA<Alumno> nodoAlumno) {
        if (nodoAlumno == null) return false;
        
        Alumno alumnoA = nodoAlumno.getItem();
        if (alumnoA.getNom().equals(NN)) {
            alumnoA.setPromedio(prom);
            return true;
        } else {
            return remplazoPromRecu(NN, prom, nodoAlumno.getHijoIzq()) ||
                   remplazoPromRecu(NN, prom, nodoAlumno.getHijoDer());
        }
    }

    public Alumno promMasAlto() {
        if (estaVacio()) throw new RuntimeException("El arbol esta vacio!");
        Alumno mayorProm = new Alumno();
        return promAltoRecu((NodoA<Alumno>) raiz, mayorProm);
    }
    private Alumno promAltoRecu(NodoA<Alumno> nodoA, Alumno mayorA) {
        if (nodoA == null) return mayorA;
        
        Alumno actual = nodoA.getItem();
        if (actual.getPromedio() > mayorA.getPromedio()) {
            mayorA = actual;
        } 
        mayorA = promAltoRecu(nodoA.getHijoIzq(), mayorA);
        mayorA = promAltoRecu(nodoA.getHijoDer(), mayorA);

        return mayorA;
    }
}
