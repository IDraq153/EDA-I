package test;
import tda.Cola;

public class ejercicio5 {
    public static<T> boolean iguales(Cola<T> cola, Cola<T> cola2) {
        Cola<T> aux = new Cola<>();
        Cola<T> aux2 = new Cola<>();
        boolean flag = true;
        
        // contando longitud
        int c1 = 0;
        int c2 = 0;
        while (!cola.estaVacia()) {
            T temp = cola.desencolar();
            aux.encolar(temp);
            c1++;
        }
        while (!aux.estaVacia()) {
            T temp = aux.desencolar();
            cola.encolar(temp);
        }

        while (!cola2.estaVacia()) {
            T temp2 = cola2.desencolar();
            aux2.encolar(temp2);
            c2++;
        }
        while (!aux2.estaVacia()) {
            T temp2 = aux2.desencolar();
            cola2.encolar(temp2);
        }

        if (c1!=c2) return false;

        // ambos iguales
        while (!cola.estaVacia()) {
            T temp = cola.desencolar();
            T temp2 = cola2.desencolar();
            if (!temp.equals(temp2)) flag = false;

            aux.encolar(temp);
            aux2.encolar(temp2);
        }
        while (!aux.estaVacia()) {
            T temp = aux.desencolar();
            T temp2 = aux2.desencolar();

            cola.encolar(temp);
            cola2.encolar(temp2);
        }
        return flag;
    }
    public static void main(String[] args) {
        Cola<Integer> cola = new Cola<>();
        Cola<Integer> cola2 = new Cola<>();
        cola.encolar(1);
        cola.encolar(2);
        cola.encolar(3);

        cola2.encolar(1);
        cola2.encolar(2);
        cola2.encolar(3);
        
        System.out.println(iguales(cola, cola2));
    }
}
