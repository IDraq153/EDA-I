package test;
import tda.ArbolBinario;
import tda.Nodo;

public class pruebaArbol2 {
    public static void main(String[] args) {
        ArbolBinario<Character> ab = new ArbolBinario<>();
        Nodo<Character> A = ab.creaRaiz('A');
        Nodo<Character> B = ab.agregarHijoIzq(A, 'B');
        @SuppressWarnings("unused")
        Nodo<Character> D = ab.agregarHijoIzq(B, 'D');
        
        Nodo<Character> C = ab.agregarHijoDer(A, 'C');
        @SuppressWarnings("unused")
        Nodo<Character> F = ab.agregarHijoDer(C, 'F');
        Nodo<Character> E = ab.agregarHijoIzq(C, 'E');
        @SuppressWarnings("unused")
        Nodo<Character> G = ab.agregarHijoIzq(E, 'G');
        @SuppressWarnings("unused")
        Nodo<Character> H = ab.agregarHijoDer(E, 'H');

        System.out.println(ab.tamanio()+'\n');
        System.out.println("RECORRIDO PRE-ORDEN");
        ab.preOrden(A);
        System.out.println("\nRECORRIDO IN-ORDEN");
        ab.inOrden(A);
        System.out.println("\nRECORRIDO POS-ORDEN");
        ab.posOrden(A);
    }
}
