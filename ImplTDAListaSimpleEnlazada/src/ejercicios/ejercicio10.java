package ejercicios;
import tda.ListaSimpleEnlazada;

public class ejercicio10 {
    public static void main(String[] args) {
        ListaSimpleEnlazada<Integer> lista = new ListaSimpleEnlazada<>();
        lista.agregarAlFinal(1);
        lista.agregarAlFinal(2);
        lista.agregarAlFinal(3);
        lista.agregarAlFinal(4);
        lista.mostrar();
        
        System.out.println();
        lista.eliminarPenultimo();
        lista.eliminarPenultimo();

        lista.intercambioElementos(1);
        lista.mostrar();
    }
}
