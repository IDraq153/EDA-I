package test;
import tda.ArbolBinario;
import tda.NodoA;

public class pruebaArbol2 {
    public static void main(String[] args) {
        ArbolBinario<Character> ab = new ArbolBinario<>();
        NodoA<Character> A = ab.creaRaiz('A');
        NodoA<Character> B = ab.agregarHijoIzq(A, 'B');
        @SuppressWarnings("unused")
        NodoA<Character> D = ab.agregarHijoIzq(B, 'D');
        
        NodoA<Character> C = ab.agregarHijoDer(A, 'C');
        @SuppressWarnings("unused")
        NodoA<Character> F = ab.agregarHijoDer(C, 'F');
        NodoA<Character> E = ab.agregarHijoIzq(C, 'E');
        @SuppressWarnings("unused")
        NodoA<Character> G = ab.agregarHijoIzq(E, 'G');
        @SuppressWarnings("unused")
        NodoA<Character> H = ab.agregarHijoDer(E, 'H');
        
        System.out.println(ab.tamanio()+'\n');

        System.out.println("RECORRIDO PRE-ORDEN");
        ab.preOrden(A);

        System.out.println("\nRECORRIDO IN-ORDEN");
        ab.inOrden(A);

        System.out.println("\nRECORRIDO POS-ORDEN");
        ab.posOrden(A);

        System.out.println("\nRECORRIDO DERECHO");
        ab.listarHijosDerecha();

        System.out.println("\nUN SOLO HIJO");
        System.out.println(ab.unSoloHijo());

        System.out.println("AMBOS HIJOS");
        System.out.println(ab.ambosHijos());

        System.out.println("Cantidad de nodos: " + ab.contarNodoAsArbol());

        System.out.println(ab.buscar('z'));
    }
}
