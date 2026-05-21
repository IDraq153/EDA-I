package ejercicios;
import tda.ListaSimpleEnlazada;

public class ejercicio2 {
/**
*2. Considere la operación sonIguales (L1, L2) que determina si dos listas 
*   enlazadas simples son iguales (en tamaño y contenido).    
**/
    public static boolean sonIguales(ListaSimpleEnlazada l1, ListaSimpleEnlazada l2) {
        if (l1.longitud() != l2.longitud()) return false;
        
        else {
            for (int i = 1; i < l1.longitud(); i++) {
                if (l1.iesimo(i) != l2.iesimo(i)) {
                    return false;
                }
            }
            return true;
        }
    }
    public static void main(String[] args) {
        ListaSimpleEnlazada<Integer> l1 = new ListaSimpleEnlazada();
        ListaSimpleEnlazada<Integer> l2 = new ListaSimpleEnlazada();
        ListaSimpleEnlazada<Integer> l3 = new ListaSimpleEnlazada();
        
        l1.agregarAlFinal(2);
        l1.agregarAlFinal(5);
        l1.agregarAlFinal(6);
        
        l2.agregarAlFinal(2);
        l2.agregarAlFinal(5);
        l2.agregarAlFinal(6);
        
        l3.agregarAlFinal(2);
        l3.agregarAlFinal(3);
        l3.agregarAlFinal(6);
        
        System.out.println("-------Son Iguales----------");
        System.out.println(sonIguales(l1,l2));
        System.out.println(l1.sonIguales(l2));
        System.out.println(l1.sonIguales(l2,l3));
        
    }
}
