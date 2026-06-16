package test;

import tda.ListaSimpleEnlazadaR;

public class ejercicio {
    public static void main(String[] args) {
        ListaSimpleEnlazadaR<Integer> lista = new ListaSimpleEnlazadaR<>();
        lista.agregarAlFinal(1);
        lista.agregarAlFinal(2);
        lista.agregarAlFinal(3);

        System.out.println(lista.obtenerTamano());
        System.out.println();
        lista.mostrarRec();
        System.out.println("\n");
        lista.mostrarIesimo(2);
    }
}
