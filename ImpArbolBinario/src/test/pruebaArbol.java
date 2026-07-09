package test;
import tda.ArbolBinario;
import tda.NodoA;

public class pruebaArbol {
    public static void main(String[] args) {
        ArbolBinario<Integer> ab = new ArbolBinario<>();
        NodoA<Integer> r = ab.creaRaiz(5);
        @SuppressWarnings("unused")
        NodoA<Integer> i = ab.agregarHijoIzq(r, 3);
        NodoA<Integer> e = ab.agregarHijoDer(r, 1);
        @SuppressWarnings("unused")
        NodoA<Integer> f = ab.agregarHijoDer(e, 8);
        System.out.println(ab.tamanio());

        System.out.println("\nRecorrido pre orden");
        ab.preOrden(r);
    }
}
