package test;

import tda.Cola;

public class ejercicio9 {
    public static void concatenar(Cola<Integer> cola1, Cola<Integer> cola2) {
        while (!cola2.estaVacia())
            cola1.encolar(cola2.desencolar());
    }

    public static void barajear(Cola<Integer> cola1, Cola<Integer> cola2) {
        Cola<Integer> cola3 = new Cola<>();

        while (!cola1.estaVacia() && !cola2.estaVacia()) {
            cola3.encolar(cola2.desencolar());
            cola3.encolar(cola1.desencolar());
        }

        while (!cola1.estaVacia())
            cola3.encolar(cola1.desencolar());
        while (!cola2.estaVacia())
            cola3.encolar(cola2.desencolar());

        while (!cola3.estaVacia()) {
            cola1.encolar(cola3.desencolar());
        }

    }

    public static <T> void mostrar(Cola<T> cola) {
        Cola<T> aux = new Cola<>();

        while (!cola.estaVacia()) {
            T temp = cola.desencolar();
            System.out.print(temp + "\t");
            aux.encolar(temp);
        }

        while (!aux.estaVacia()) {
            T temp = aux.desencolar();
            cola.encolar(temp);
        }
    }

    public static void main(String[] args) {
        Cola<Integer> cola1 = new Cola<>();
        Cola<Integer> cola2 = new Cola<>();

        cola1.encolar(1);
        cola1.encolar(1);
        cola1.encolar(1);
        cola1.encolar(1);
        cola2.encolar(2);
        cola2.encolar(2);
        cola2.encolar(2);
        cola2.encolar(2);
        cola2.encolar(2);

        barajear(cola1, cola2);
        mostrar(cola1);
    }
}
