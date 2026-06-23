package test;
import tda.ArbolBinario;
import tda.Nodo;

public class pruebaArbol2 {
    public static void main(String[] args) {
        ArbolBinario<Character> ab = new ArbolBinario<>();
        Nodo<Character> r = ab.creaRaiz('A');
        Nodo<Character> a = ab.agregarHijoIzq(r, 'B');
        @SuppressWarnings("unused")
        Nodo<Character> c = ab.agregarHijoIzq(a, 'D');
        
        Nodo<Character> h = ab.agregarHijoDer(r, 'C');
        @SuppressWarnings("unused")
        Nodo<Character> j = ab.agregarHijoDer(h, 'F');
        Nodo<Character> k = ab.agregarHijoIzq(h, 'E');
        @SuppressWarnings("unused")
        Nodo<Character> l = ab.agregarHijoIzq(k, 'G');
        @SuppressWarnings("unused")
        Nodo<Character> m = ab.agregarHijoDer(k, 'H');

        System.out.println(ab.tamanio()+'\n');
        System.out.println("RECORRIDO PRE-ORDEN");
        ab.preOrden(r);
    }
}
