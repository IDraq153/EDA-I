package test;

import javax.management.RuntimeErrorException;

import tda.Pila;

public class ejercicio10 {
    public static void mostrar(Pila<Integer> pila) {
        Pila<Integer> aux = new Pila<>();
        while (!pila.estaVacia()) {
            Integer item = pila.desapilar();
            System.out.println(item);
            aux.apilar(item);
        }
        while (!aux.estaVacia())
            pila.apilar(aux.desapilar());
    }

    public static Pila<Integer> copiar(Pila<Integer> pila) {
        Pila<Integer> aux1 = new Pila<>();
        Pila<Integer> aux2 = new Pila<>();

        while (!pila.estaVacia())
            aux1.apilar(pila.desapilar());
        while (!aux1.estaVacia()) {
            Integer temp = aux1.desapilar();
            pila.apilar(temp);
            aux2.apilar(temp);
        }
        return aux2;
    }

    public static Integer mininimo(Pila<Integer> pila) {
        Pila<Integer> aux = copiar(pila);

        if (pila.estaVacia())
            throw new RuntimeErrorException(null, "ERROR, La pila no tiene elementos!");
        else {
            Integer min = Integer.MAX_VALUE;
            while (!aux.estaVacia()) {
                Integer elem = aux.desapilar();
                if (elem < min) {
                    min = elem;
                }
            }
            return min;
        }

    }

    public static void eliminar(Pila<Integer> pila, Integer item) {
        Pila<Integer> aux = new Pila<>();

        while (!pila.estaVacia()) {
            Integer tmp = pila.desapilar();
            if (item != tmp)
                aux.apilar(tmp);
        }
        while (!aux.estaVacia())
            pila.apilar(aux.desapilar());
    }

    public static void main(String[] args) {
        Pila<Integer> pila = new Pila<>();
        pila.apilar(10);
        pila.apilar(2);
        pila.apilar(7);
        pila.apilar(3);
        mostrar(pila);

        System.out.println("Minimo valor");
        System.out.println(mininimo(pila));

        System.out.println("");
        eliminar(pila, mininimo(pila));
        mostrar(pila);
    }
}
