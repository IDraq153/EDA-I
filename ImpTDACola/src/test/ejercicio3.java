package test;
import tda.Cola;

public class ejercicio3 {
    // 1 -> 2 -> 3 -> 4 -> 5 
    public static void insertarAlFrente(Cola<String> cola, String item) {
        Cola<String> aux = new Cola<>();
        aux.encolar(item);
        
        while (!cola.estaVacia()) {
            String temp = cola.desencolar();
            aux.encolar(temp);
        }
        
        while (!aux.estaVacia()) {
            String temp = aux.desencolar();
            cola.encolar(temp);
        }
    }
    public static void mostrar(Cola<String> cola) {
        Cola<String> aux = new Cola<>();

        while (!cola.estaVacia()) {
            String temp = cola.desencolar();
            System.out.print(temp+"\t");
            aux.encolar(temp);
        }
        
        while (!aux.estaVacia()) {
            String temp = aux.desencolar();
            cola.encolar(temp);
        }
    }
    public static void main(String[] args) {
        Cola<String> prueba = new Cola<>();
        prueba.encolar("p1");
        insertarAlFrente(prueba, "p0");
        insertarAlFrente(prueba, "p-1");
        prueba.encolar("p2");
        prueba.encolar("p3");
        mostrar(prueba);
    }
}
