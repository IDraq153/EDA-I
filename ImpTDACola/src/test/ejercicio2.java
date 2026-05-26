package test;
import tda.Cola;

public class ejercicio2 {
    public static boolean positivo(Cola<Integer> cola) {
        Cola<Integer> aux = new Cola<>();
        boolean flag = true;

        while (!cola.estaVacia()) {
            int num = cola.desencolar();
            aux.encolar(num);

            if (num < 0) {
                flag = false;
                return flag;
            }
        }

        while (!aux.estaVacia()) {
            cola.encolar(aux.desencolar());
        }
        return flag;
    }

    public static void main(String[] args) {
        Cola<Integer> cola = new Cola<>();
        cola.encolar(1);
        cola.encolar(2);
        cola.encolar(3);
        cola.encolar(-3);

        System.out.println(positivo(cola));
    }
}
