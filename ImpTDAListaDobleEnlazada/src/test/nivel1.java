package test;
import tda.ListaDobleEnlazada;

public class nivel1 {
    public static void main(String[] args) {
        ListaDobleEnlazada<Integer> lista = new ListaDobleEnlazada<>();
        lista.agregarAlFinal(2);
        lista.agregarAlFinal(22);
        lista.agregarAlFinal(21);
        lista.agregarAlFinal(1);
        lista.agregarAlFinal(21);
        lista.agregarAlFinal(12);
        lista.agregarAlFinal(12);

        lista.eliminarAlInicio();
        lista.eliminarAlFinal();
        lista.eliminar(1);
        lista.intercambioInicioFin();
        lista.mostrar();
        System.out.println();
        System.out.println(lista.ultimo());
    }
}
