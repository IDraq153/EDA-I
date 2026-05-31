package ejercicios;

import tda.ListaSimpleEnlazada;

public class ejercicio8 {
    public static void main(String[] args) {
        ListaSimpleEnlazada<Integer> lista = new ListaSimpleEnlazada<>();
        lista.agregarAlFinal(1);
        lista.agregarAlFinal(2);
        lista.agregarAlFinal(3);

        lista.ultimoNodo();
        lista.mostrar();
    }
}
