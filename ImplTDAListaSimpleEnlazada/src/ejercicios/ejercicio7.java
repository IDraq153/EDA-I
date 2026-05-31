package ejercicios;

import tda.ListaSimpleEnlazada;

public class ejercicio7 {
    public static void main(String[] args) {
        ListaSimpleEnlazada<Integer> lista = new ListaSimpleEnlazada<>();
        lista.agregarAlFinal(1);
        lista.agregarAlFinal(2);
        lista.agregarAlFinal(1);
        lista.agregarAlFinal(4);

        System.out.println(lista.ordenadaAsc(lista));
    }
}
