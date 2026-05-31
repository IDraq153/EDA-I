package ejercicios;
import tda.ListaSimpleEnlazada;

/*
6.	Sean L1 y L2 dos listas enlazadas ordenadas. Considere la operación de mezclar 
* las listas L1 y L2, esto es, formar la lista enlazada ordenada L3 intercalando los elementos de L1 y L2.   
* Ejemplo:   L1 = 1,3,5;  L2 = 2,6,8   entonces   L3 =  1,2,3,5,6,8
*/
public class ejercicio6 {
    public static void main(String[] args) {
        ListaSimpleEnlazada<Integer> lista = new ListaSimpleEnlazada<>();
        ListaSimpleEnlazada<Integer> lista2 = new ListaSimpleEnlazada<>();
        ListaSimpleEnlazada<Integer> lista3 = new ListaSimpleEnlazada<>();
        lista.agregarAlFinal(1);
        lista.agregarAlFinal(8);
        lista.agregarAlFinal(10);

        lista2.agregarAlFinal(5);
        lista2.agregarAlFinal(6);
        lista2.agregarAlFinal(7);

        lista3.mezclarListas(lista, lista2);
        lista3.mostrar();
    }    
}
