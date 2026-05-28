package test;
import tda.Cola;

public class ejercicio4 {
    // Teniendo una cola 1 , 2 , 3 , 1 , 1  --> remplaza por 5: 5 , 2 , 3 , 5 , 5
    public static<T> void remplazarOcu(Cola<T> cola, T nuevoElem, T antiguoElem) {
        Cola<T> aux = new Cola<>();
        while (!cola.estaVacia()) {
            T temp = cola.desencolar();
            
            if (antiguoElem.equals(temp)) temp = nuevoElem;
            aux.encolar(temp);
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
        cola.encolar(1);
        cola.encolar(2);
        cola.encolar(1);
        cola.encolar(3);
        remplazarOcu(cola, 10, 1);
        mostrar(cola);
    }
}
