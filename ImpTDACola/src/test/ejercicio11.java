package test;

import tda.Cola;

public class ejercicio11 {

    public static Cola<Integer> copiar(Cola<Integer> cola) {
        Cola<Integer> colaCopia = new Cola<>();
        Cola<Integer> aux = new Cola<>();

        while (!cola.estaVacia()) {
            Integer item = cola.desencolar();
            aux.encolar(item);
            colaCopia.encolar(item);
        }

        while (!aux.estaVacia())
            cola.encolar(aux.desencolar());

        return colaCopia;
    }

    public static boolean existeEnCola(Cola<Integer> cola, Integer num) {
        boolean flag = false;
        Cola<Integer> aux = copiar(cola);

        while (!aux.estaVacia()) {
            Integer item = aux.desencolar();

            if (num.equals(item)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static Cola<Integer> interseccion(Cola<Integer> cola1, Cola<Integer> cola2) {
        Cola<Integer> cola3 = new Cola<>();
        Cola<Integer> colaA1 = copiar(cola1);

        while (!colaA1.estaVacia()) {
            Cola<Integer> colaA2 = copiar(cola2);
            Integer item1 = colaA1.desencolar();

            if (existeEnCola(cola3, item1)) {
                continue;
            }

            while (!colaA2.estaVacia()) {
                Integer item2 = colaA2.desencolar();

                if (item1.equals(item2)) {
                    cola3.encolar(item2);
                    break;
                }
            }
        }
        return cola3;
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
        Cola<Integer> cola3 = new Cola<>();

        cola1.encolar(1);
        cola1.encolar(2);
        cola1.encolar(9);
        cola1.encolar(5);
        cola1.encolar(10);

        cola2.encolar(3);
        cola2.encolar(10);
        cola2.encolar(10);
        cola2.encolar(1);
        cola2.encolar(5);

        cola3 = interseccion(cola1, cola2);
        mostrar(cola3);
    }
}
