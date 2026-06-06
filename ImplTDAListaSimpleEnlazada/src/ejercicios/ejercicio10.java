package ejercicios;
import tda.ListaSimpleEnlazada;

public class ejercicio10 {
    public static void main(String[] args) {
        ListaSimpleEnlazada<Integer> lista = new ListaSimpleEnlazada<>();
        ListaSimpleEnlazada<Integer> lista2 = new ListaSimpleEnlazada<>();
        lista.agregarAlFinal(1);
        lista.agregarAlFinal(2);
        lista.agregarAlFinal(3);
        
        lista2.agregarAlFinal(3);
        lista2.agregarAlFinal(2);
        lista2.agregarAlFinal(1);
        lista2.agregarAlFinal(5);
        
        lista.mostrar();

        lista.intercambioElementos(1);
        lista.mostrar();
        System.out.println(lista.ultimoNodoMayorLongitud());

        System.out.println();
        lista.recorrerListas(lista, lista2);
    }
}
