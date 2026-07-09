package test;

import tda.Pila;

public class ejercicio11 {
    public static <T> Pila<T> copiar(Pila<T> pila) {
        Pila<T> aux = new Pila<>();
        Pila<T> aux2 = new Pila<>();

        while (!pila.estaVacia()) {
            aux.apilar(pila.desapilar());
        }
        while (!aux.estaVacia()) {
            T item = aux.desapilar();
            aux2.apilar(item);
            pila.apilar(item);
        }
        return aux2;
    }

    public static Integer cima(Pila<Integer> pila) {
        if (pila.estaVacia()) {
            throw new RuntimeException("Esta vacia!");
        }
        Integer item = pila.desapilar();
        pila.apilar(item);
        return item;
    }

    public static Pila<Integer> ordenar(Pila<Integer> pila) {
        Pila<Integer> aux1 = copiar(pila);
        Pila<Integer> aux2 = new Pila<>();
        Pila<Integer> aux3 = new Pila<>();

        while (!aux1.estaVacia()) {
            Integer item = aux1.desapilar();

            if (aux2.estaVacia()) {
                aux2.apilar(item);
            } else {
                while (!aux2.estaVacia() && item > cima(aux2)) {
                    aux3.apilar(aux2.desapilar());
                }
                aux2.apilar(item);

                while (!aux3.estaVacia()) {
                    aux2.apilar(aux3.desapilar());
                }
            }
        }
        return aux1;
    }

    public static void main(String[] args) {

    }
}
