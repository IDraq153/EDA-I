package test;
import tda.ListaDobleEnlazada;

public class TestListaDobleEnlazada {
    public static void main(String[] args) {
        ListaDobleEnlazada<Integer> lista = new ListaDobleEnlazada<>();
        lista.agregarAlFinal(1);
        lista.agregarAlFinal(2);
        lista.agregarAlFinal(3);

        lista.mostrar();
        System.out.println("\n---------------------");
        lista.mostrarInvertido();
    }
}
