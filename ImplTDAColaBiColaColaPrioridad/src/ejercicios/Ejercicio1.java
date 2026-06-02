package ejercicios;

/*
* 1.	Contar los elementos de una cola C sin modificarla.
*/
import tda.Cola;

public class Ejercicio1 {
    public static int contarElementos(Cola<String> cola){
        Cola<String> aux = new Cola<>();
        int c = 0;
        // Desencolar todos los items de la cola original y 
        // almacenarlas temporalmente en la cola auxiliar
        while(!cola.estaVacia()){
            String tmp = cola.desencolar();
            c++;
            aux.encolar(tmp);
        }
        // reestablecer la cola original, devolviendo los items de aux a cola
        while (!aux.estaVacia()){
            cola.encolar(aux.desencolar());
        }
        return c;
    }
    public static void main(String[] args) {
        Cola<String> cola = new Cola();
        cola.encolar("a");
        cola.encolar("b");
        cola.encolar("c");
        cola.encolar("d");
        cola.encolar("e");
        cola.encolar("f");
        System.out.println("Numero de items: "+contarElementos(cola));
    }
    
}
