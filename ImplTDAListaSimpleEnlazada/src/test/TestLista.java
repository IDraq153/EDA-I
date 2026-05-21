package test;
import tda.*;
public class TestLista {
    public static void main(String[] args) {
        // Crear una lista
        ListaSimpleEnlazada<String> lista = new ListaSimpleEnlazada<>();
        System.out.println(lista.estaVacia());
        lista.agregarAlFinal("Juan");
        lista.agregarAlFinal("Ana");
        lista.agregarAlFinal("Juan");
        lista.agregarAlFinal("Roger");
        lista.agregarAlFinal("Sonia");
        lista.agregarAlFinal("Hernan");
        
        System.out.println("------------ELEMENTOS-------------");
        System.out.println("Mostrar los elementos de la lista: ");
        lista.mostrar();
        System.out.println("Longitud: "+lista.longitud());
        
        System.out.println("------------UBICACION-------------");
        System.out.println("Iesimo 4: "+lista.iesimo(2));
        System.out.println("Ubicacion: "+"Hernan: "+lista.ubicacion("Hernan"));
        
        System.out.println("------------ELIMINAR_POS-------------");
        lista.eliminar(1);
        lista.mostrar();
        
        System.out.println("------------INSERTAR-------------");
        lista.insertar("Mario", 1);
        System.out.println("Insertar POS 3");
        lista.mostrar();
        lista.insertar("-Leo-", 3);
        System.out.println("");
        lista.insertar("-Pedro-", 6);
        lista.mostrar();
        System.out.println("");
        System.out.println("Insertar POS 2");
        lista.insertarDerecha("-DDD-", 2);
        lista.mostrar();
    }
    
}
