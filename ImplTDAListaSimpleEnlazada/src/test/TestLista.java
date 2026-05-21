package test;
import tda.*;
public class TestLista {
    public static void main(String[] args) {
        // Crear una lista
        ListaSimpleEnlazada<String> lista = new ListaSimpleEnlazada<String>();
        System.out.println(lista.estaVacia());
        lista.agregarAlFinal("Juan"); // 1
        lista.agregarAlFinal("Ana"); // 2
        lista.agregarAlFinal("Juan"); // 3
        lista.agregarAlFinal("Roger");// 4
        lista.agregarAlFinal("Sonia");// 5
        lista.agregarAlFinal("Hernan");// 6
        System.out.println("Mostrar los elementos de la lista: ");
        lista.mostrar();
        System.out.println("Longitud: "+lista.longitud());
        System.out.println("Iesimo 4: "+lista.iesimo(2));
        System.out.println("Ubicacion: "+"Hernan: "+lista.ubicacion("Hernan"));
        System.out.println("Eliminando el primer nodo");
        lista.eliminar(1);
        lista.mostrar();
        System.out.println("Eliminando el ultimo nodo");
        lista.eliminar(5);
        lista.mostrar();
        System.out.println("Eliminando un nodo entre el primero y ultimo nodo");
        lista.eliminar(3);
        lista.mostrar();
        System.out.println("Inserta en la pos 1: ");
        lista.insertar("Hernan", 1);
        lista.mostrar();
        System.out.println("Insertar en la ultima posicion: ");
        lista.insertar("Adriana", 5);
        lista.mostrar();
        System.out.println("Insertar entre la primera y ultima: ");
        lista.insertar("Raquel", 3);
        lista.mostrar();
        
    }
    
}
