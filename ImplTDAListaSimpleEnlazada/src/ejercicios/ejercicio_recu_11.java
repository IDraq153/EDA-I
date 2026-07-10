package ejercicios;
import tda.ListaSimpleEnlazada;

public class ejercicio_recu_11 {
    public static void main(String[] args) {
        ListaSimpleEnlazada<Integer> l1 = new ListaSimpleEnlazada<>();
        l1.agregarAlFinal(1);
        l1.agregarAlFinal(2);
        l1.agregarAlFinal(3);
        l1.agregarAlFinal(4);
        l1.agregarAlFinal(5);
        System.out.println("n: " + numElementosLista(l1, 0));
        System.out.println("Nodos: " + l1.contarNodos(l1));
        l1.mostrar();
        l1.inversoImprimir(l1);
        l1.mostrar();
    }

    public static int numElementosLista(ListaSimpleEnlazada<?> l1, int pos) {
        if (l1.longitud() <= pos) return 0;
        else return 1 + numElementosLista(l1, pos + 1);
    }
}
