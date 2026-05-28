package test;
import tda.Cola;

public class ejercicio6 {
    public static<T> void copiar(Cola<T> cola, Cola<T> cola_copia) {
        Cola<T> aux = new Cola<>();
        while (!cola_copia.estaVacia()) cola_copia.desencolar();
        
        while (!cola.estaVacia()) {
            T temp = cola.desencolar();
            aux.encolar(temp);
            cola_copia.encolar(temp);
        }
        while (!aux.estaVacia()) {
            T temp = aux.desencolar();
            cola.encolar(temp);
        }
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
        Cola<Integer> cola_copia = new Cola<>();
        cola.encolar(1);
        cola.encolar(2);
        cola.encolar(3);
        cola_copia.encolar(3);
        System.out.println("ORIGINAL");
        mostrar(cola);
        
        System.out.println("\nCOPIA");
        copiar(cola,cola_copia);
        mostrar(cola_copia);
    }
}
