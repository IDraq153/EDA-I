
package test;
import tda.Cola;

public class ejercicio1 {
    public static int contarElementos(Cola<String> cola) {
        Cola<String> aux = new Cola<>();

        int c = 0;
        // Desencolar todos los items de la cola original
        // Almacenarlos temporalmente en la cola auxiliar
        while (!cola.estaVacia()) {
            String tmp = cola.desencolar();
            aux.encolar(tmp);
            c++;
        }

        while (!aux.estaVacia()) {
            cola.encolar(aux.desencolar());
        }

        return c;
    }
    public static void main(String[] args) {
        Cola<String> cola = new Cola<>();
        cola.encolar("A");
        cola.encolar("B");
        cola.encolar("C");
        cola.encolar("D");
        cola.encolar("E");
        cola.encolar("F");
        
        System.out.println(contarElementos(cola));
    }
}
