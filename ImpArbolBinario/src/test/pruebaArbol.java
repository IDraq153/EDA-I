package test;
import tda.ArbolBinario;
import tda.Nodo;

public class pruebaArbol {
    public static void main(String[] args) {
        ArbolBinario<Integer> ab = new ArbolBinario<>();
        Nodo<Integer> r = ab.creaRaiz(5);
        @SuppressWarnings("unused")
        Nodo<Integer> i = ab.agregarHijoIzq(r, 3);
        Nodo<Integer> e = ab.agregarHijoDer(r, 1);
        @SuppressWarnings("unused")
        Nodo<Integer> f = ab.agregarHijoDer(e, 8);
        System.out.println(ab.tamanio());
    }
}
