package ejercicios;
import tda.ListaSimpleEnlazada;
        
public class ejercicio3 {
/*
*3.Considere la operación ConcatenarListas (L1, L2), que consiste en concatenar 
*  las listas enlazadas L1 y L2 en una sola lista de tal forma que el último 
*  nodo de la primera lista (L1) apunte al primer nodo de la segunda lista (L2).    
*/
    public static void main(String[] args) {
        ListaSimpleEnlazada<Integer> lista = new ListaSimpleEnlazada<>();
        ListaSimpleEnlazada<Integer> lista2 = new ListaSimpleEnlazada<>();
        lista.agregarAlFinal(1);
        lista.agregarAlFinal(3);
        lista.agregarAlFinal(1);
        
        lista2.agregarAlFinal(1);
        lista2.agregarAlFinal(2);
        lista2.agregarAlFinal(3);
        System.out.println("");
        lista.mostrar();
        System.out.println("");
        lista2.mostrar();

        lista.concatenarLista(lista2);
        lista.mostrar();
    }
}
