package test;

import tda.Pila;

public class ejercicios {
    public static <T> Integer contar(Pila<T> pila) {
        Integer conta = 0;
        Pila<T> aux = new Pila<>();

        while (!pila.estaVacia()) {
            aux.apilar(pila.desapilar());
            conta++;
        }
        while (!aux.estaVacia())
            pila.apilar(aux.desapilar());

        return conta;
    }

    public static <T> boolean encontrar(T item, Pila<T> pila) {
        boolean flag = false;
        Pila<T> aux = new Pila<>();

        while (!pila.estaVacia()) {
            T elem = pila.desapilar();
            if (elem.equals(item)) {
                flag = true;
            }
            aux.apilar(elem);
        }
        while (!aux.estaVacia())
            pila.apilar(aux.desapilar());

        return flag;
    }

    public static <T> void invertir(Pila<T> pila) {
        Pila<T> aux = new Pila<>();
        Pila<T> aux2 = new Pila<>();

        while (!pila.estaVacia())
            aux.apilar(pila.desapilar());
        while (!aux.estaVacia())
            aux2.apilar(aux.desapilar());
        while (!aux2.estaVacia())
            pila.apilar(aux2.desapilar());
    }

    public static <T> void ingresarFondo(T item, Pila<T> pila) {
        Pila<T> aux = new Pila<>();

        while (!pila.estaVacia())
            aux.apilar(pila.desapilar());
        aux.apilar(item);
        while (!aux.estaVacia())
            pila.apilar(aux.desapilar());
    }

    public static boolean todoPositivo(Pila<Integer> pila) {
        Pila<Integer> aux = new Pila<>();
        boolean flag = true;

        while (!pila.estaVacia()) {
            Integer item = pila.desapilar();
            if (item < 0)
                flag = false;
            aux.apilar(item);
        }
        while (!aux.estaVacia())
            pila.apilar(aux.desapilar());
        while (!aux.estaVacia())
            pila.apilar(aux.desapilar());

        return flag;
    }

    public static void remplazar(Integer item, Integer itemNuevo, Pila<Integer> pila) {
        Pila<Integer> aux = new Pila<>();

        while (!pila.estaVacia()) {
            Integer itemAnt = pila.desapilar();
            if (itemAnt == item)
                itemAnt = itemNuevo;
            aux.apilar(itemAnt);
        }
        while (!aux.estaVacia())
            pila.apilar(aux.desapilar());
    }

    public static <T> boolean igualesPilas(Pila<T> pila1, Pila<T> pila2) {
        boolean flag = true;
        Pila<T> aux1 = new Pila<>();
        Pila<T> aux2 = new Pila<>();

        if (contar(pila1) != contar(pila2)) {
            flag = false;
            return flag;
        }

        while (!pila1.estaVacia() && !pila2.estaVacia()) {
            T item1 = pila1.desapilar();
            T item2 = pila2.desapilar();

            if (!item1.equals(item2))
                flag = false;

            aux1.apilar(item1);
            aux2.apilar(item2);
        }
        while (!aux1.estaVacia() && !aux2.estaVacia()) {
            pila1.apilar(aux1.desapilar());
            pila2.apilar(aux2.desapilar());
        }

        return flag;
    }

    public static void main(String[] args) {
        Pila<Integer> pila = new Pila<>();
        pila.apilar(1);
        pila.apilar(2);
        pila.apilar(1);
        Pila<Integer> pila2 = new Pila<>();
        pila2.apilar(1);
        pila2.apilar(2);
        pila2.apilar(1);

        pila.mostrar();

        System.out.println("CONTANDO ELEMENTOS");
        System.out.println(pila.contarElementos());
        System.out.println(contar(pila));

        System.out.println("ENCONTRANDO VALOR");
        System.out.println(pila.encontrar(2));
        System.out.println(encontrar(1, pila));

        pila.mostrar();
        System.out.println("INVERTIR");
        pila.invertir();
        invertir(pila);
        pila.mostrar();

        System.out.println("AL FONDO");
        ingresarFondo(10, pila);
        pila.mostrar();

        System.out.println("POSITIVO");
        System.out.println(todoPositivo(pila));

        System.out.println("REMPLAZAR");
        remplazar(1, 5, pila);
        pila.mostrar();

        System.out.println("SON IGUALES");
        System.out.println(igualesPilas(pila, pila2));
    }
}
