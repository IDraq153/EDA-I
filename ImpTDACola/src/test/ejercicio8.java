package test;

import tda.Cola;

public class ejercicio8 {
    public static <T> void eliminarFondo(Cola<T> cola) {
        Cola<T> aux = new Cola<>();
        int i = 0;
        int longit = longitud(cola);

        while (i < longit - 1) {
            aux.encolar(cola.desencolar());
            i++;
        }
        
        cola.desencolar();

        while (!aux.estaVacia()) {
            cola.encolar(aux.desencolar());
        }
    }

    public static <T> Integer longitud(Cola<T> cola) {
        Cola<T> aux = new Cola<>();
        int contador = 0;

        while (!cola.estaVacia()) {
            aux.encolar(cola.desencolar());
            contador++;
        }
        while (!aux.estaVacia())
            cola.encolar(aux.desencolar());

        return contador;
    }
    public static<T> void mostrar(Cola<T> cola) {
        Cola<T> aux = new Cola<>();

        while (!cola.estaVacia()) {
            T temp = cola.desencolar();
            System.out.print(temp+"\t");
            aux.encolar(temp);
        }
        
        while (!aux.estaVacia()) {
            T temp = aux.desencolar();
            cola.encolar(temp);
        }
    }
    public static void main(String[] args) {
        Cola<Integer> cola = new Cola<>();
        cola.encolar(1);
        cola.encolar(2);
        cola.encolar(3);
        cola.encolar(3);
        cola.encolar(3);
        cola.encolar(4);
        mostrar(cola);

        System.out.println();
        System.out.println(longitud(cola));
        eliminarFondo(cola);
        mostrar(cola);
    }
}
