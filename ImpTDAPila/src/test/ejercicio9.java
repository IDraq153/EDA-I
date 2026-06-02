package test;

import tda.Pila;

public class ejercicio9 {
    public static void mostrar(Pila<Integer> pila) {
        Pila<Integer> aux = new Pila<>();
        while(!pila.estaVacia()) {
            Integer item = pila.desapilar();
            System.out.println(item);
            aux.apilar(item);
        }
        while(!aux.estaVacia()) pila.apilar(aux.desapilar());
    }
    public static Pila<Integer> copiar(Pila<Integer> pila) {
        Pila<Integer> aux1 = new Pila<>();
        Pila<Integer> aux2 = new Pila<>();
        
        while(!pila.estaVacia()) aux1.apilar(pila.desapilar());
        while(!aux1.estaVacia()) {
            Integer temp = aux1.desapilar();
            pila.apilar(temp);
            aux2.apilar(temp);
        }
        return aux2;
    }
    public static void main(String[] args) {
        Pila<Integer> pila = new Pila<>();
        Pila<Integer> pila2 = new Pila<>();

        pila2.apilar(2);
        pila.apilar(1);
        pila.apilar(2);
        pila.apilar(7);
        pila.apilar(3);
        mostrar(pila);
        
        System.out.println("Haciendo copia de pila");
        pila2 = copiar(pila);
        mostrar(pila2);
    }
}
