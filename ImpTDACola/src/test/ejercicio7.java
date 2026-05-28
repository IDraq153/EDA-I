package test;
import tda.Cola;

public class ejercicio7 {
    public static Cola<Integer> mezclaCola(Cola<Integer> c1, Cola<Integer> c2) {
        Cola<Integer> c3 = new Cola<>();
        Integer elem1 = null;
        Integer elem2 = null;

        while (!c1.estaVacia() || !c2.estaVacia() || elem1!=null || elem2!=null) {
            if (elem1 == null && !c1.estaVacia()) elem1 = c1.desencolar();
            if (elem2 == null && !c2.estaVacia()) elem2 = c2.desencolar();
            
            if (elem1!=null && elem2!=null) {
                if (elem1 <= elem2) {
                    c3.encolar(elem1);
                    elem1 = null;
                } 
                else if (elem1 > elem2) {
                    c3.encolar(elem2);
                    elem2 = null;
                }
            } 
            else if (elem2!=null) {
                c3.encolar(elem2);
                elem2 = null;
            }
            else if (elem1!=null) {
                c3.encolar(elem1);
                elem1 = null;
            } 
        }
        return c3;
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
        Cola<Integer> colaA = new Cola<>();
        Cola<Integer> colaB = new Cola<>();
        Cola<Integer> colaC = new Cola<>();
        
        colaA.encolar(1);
        colaA.encolar(2);
        colaA.encolar(3);

        colaB.encolar(1);
        colaB.encolar(5);
        colaB.encolar(6);
        colaB.encolar(7);

        colaC = mezclaCola(colaA, colaB);
        mostrar(colaC);
    }
}
