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

    public static Integer cima(Pila<Integer> pila) {
        if (pila.estaVacia())
            throw new RuntimeErrorException(null, "Error, pila vacias");

        Integer item = pila.desapilar();
        pila.apilar(item);
        return item;
    }

    public static Pila<Integer> ordenar(Pila<Integer> pila) {
        Pila<Integer> aux0 = copiar(pila);
        Pila<Integer> aux1 = new Pila<>();
        Pila<Integer> aux2 = new Pila<>();

        // tmp1 = sacado de la pila original
        // tmp2 = sacando de aux1 a aux2 para acomodar al fondo 
        while (!aux0.estaVacia()) {
            Integer tmp1 = aux0.desapilar();

            // si esta vacia se pone el primero
            if (aux1.estaVacia())
                aux1.apilar(tmp1);
            else {
                //Integer tmp2 = cima(aux1);

                // sacamos elementos menores
                while (!aux1.estaVacia() &&  tmp1 > cima(aux1)) {
                    aux2.apilar(aux1.desapilar());
                }

                // ponemos el elemento mayor al fondo
                aux1.apilar(tmp1);

                // los sobrantes de la columna van devuelta
                while (!aux2.estaVacia())
                    aux1.apilar(aux2.desapilar());
            }
        }
        return aux1;
    }

    public static void main(String[] args) {
        Pila<Integer> pila = new Pila<>();
        Pila<Integer> pilaOrdenada = new Pila<>();
        pila.apilar(10);
        pila.apilar(2);
        pila.apilar(7);
        pila.apilar(3);
        pila.apilar(12);
        mostrar(pila);

        System.out.println("Minimo valor");
        System.out.println(mininimo(pila));

        System.out.println("");
        eliminar(pila, mininimo(pila));
        mostrar(pila);

        System.out.println("ORDENAR LA PILA");
        pilaOrdenada = ordenar(pila);
        mostrar(pilaOrdenada);
    }
}
