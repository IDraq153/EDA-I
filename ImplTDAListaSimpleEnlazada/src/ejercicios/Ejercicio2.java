package ejercicios;

/**
 * 2.	Considere la operación sonIguales (L1, L2) que determina si dos listas 
 * enlazadas simples son iguales (en tamaño y contenido).
 * 
 */
import tda.ListaSimpleEnlazada;

public class Ejercicio2 {
    public static boolean sonIguales(ListaSimpleEnlazada L1, ListaSimpleEnlazada L2){
        if (L1.longitud()!=L2.longitud()){
            return false;
        }else{
            for (int i = 1; i < L1.longitud(); i++) {
                if (L1.iesimo(i)!=L2.iesimo(i)){
                    return false;
                }
            }
            return true;
        }       
    }
    public static void main(String[] args) {
        ListaSimpleEnlazada<Integer> L1 = new ListaSimpleEnlazada<>();
        ListaSimpleEnlazada<Integer> L2 = new ListaSimpleEnlazada<>();
        L1.agregarAlFinal(12);L1.agregarAlFinal(9);L1.agregarAlFinal(1);L1.agregarAlFinal(5);
        L2.agregarAlFinal(12);L2.agregarAlFinal(2);L2.agregarAlFinal(1);L2.agregarAlFinal(5);
        System.out.println("Son iguales: "+sonIguales(L1,L2));
        
    }
}
