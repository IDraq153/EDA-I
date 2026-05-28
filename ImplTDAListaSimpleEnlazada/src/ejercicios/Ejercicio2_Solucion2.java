package ejercicios;

import tda.ListaSimpleEnlazada;

public class Ejercicio2_Solucion2 {
    public static void main(String[] args) {
        ListaSimpleEnlazada<Integer> L1 = new ListaSimpleEnlazada<>();
        ListaSimpleEnlazada<Integer> L2 = new ListaSimpleEnlazada<>();
        ListaSimpleEnlazada<Integer> L3 = new ListaSimpleEnlazada<>();
        L1.agregarAlFinal(12);L1.agregarAlFinal(2);L1.agregarAlFinal(1);L1.agregarAlFinal(5);
        L2.agregarAlFinal(12);L2.agregarAlFinal(2);L2.agregarAlFinal(1);L2.agregarAlFinal(5);
        
        System.out.println("Son iguales: "+L1.sonIguales(L2));
        System.out.println("Son iguales: "+L3.sonIguales(L1,L2));
        
    }
}
