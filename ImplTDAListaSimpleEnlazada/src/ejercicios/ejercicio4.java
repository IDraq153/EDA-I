package ejercicios;
import tda.ListaSimpleEnlazada;
/*
* 4.	Considere la operación InvertirLista (L), que consiste en construir
* una nueva lista que contenga los elementos de la lista L en orden inverso.
*/

public class ejercicio4 {
    public static void main(String[] args) {
        ListaSimpleEnlazada<Integer> lista = new ListaSimpleEnlazada<>();
        lista.agregarAlFinal(1);   
        lista.agregarAlFinal(2);   
        lista.agregarAlFinal(3);
        lista.mostrar();

        lista.invertir();
        lista.mostrar();
    }
}
