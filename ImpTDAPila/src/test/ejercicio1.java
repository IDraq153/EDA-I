package test;

import tda.Pila;

public class ejercicio1 {
    public static void main(String[] args) {
        Pila<Integer> pila = new Pila<>();
        pila.apilar(1);
        pila.apilar(2);
        pila.apilar(3);
        pila.mostrar();

        System.out.println("CONTANDO ELEMENTOS");
        System.out.println(pila.contarElementos());
        
        System.out.println("ENCONTRANDO VALOR");
        System.out.println(pila.encontrar(2));
        
        pila.mostrar();
        System.out.println("INVERTIR");
        pila.invertir();
        pila.mostrar();
        
    }
}
