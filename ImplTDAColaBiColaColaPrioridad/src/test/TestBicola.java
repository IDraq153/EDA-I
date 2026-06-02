package test;
import tda.BiCola;
public class TestBicola {
    public static void mostrar(BiCola<String> cola){
        BiCola<String> aux = new BiCola<>();
        // Desencolar todos los items de la cola original y 
        // almacenarlas temporalmente en la cola auxiliar
        while(!cola.estaVacia()){
            String tmp = cola.desencolar_frente();
            System.out.print(tmp + "\t");
            aux.encolarFinal(tmp);
        }
        // reestablecer la cola original, devolviendo los items de aux a cola
        while (!aux.estaVacia()){
            cola.encolarFinal(aux.desencolar_frente());
        }
    }
    public static void main(String[] args) {
        BiCola<String> cola = new BiCola();
        cola.encolarFinal("a");
        cola.encolarFinal("b");
        cola.encolarFinal("c");
        cola.encolarFinal("d");
        cola.encolarFinal("e");
        cola.encolarFinal("f");
        cola.encolarFrente("AA");
        cola.encolarFrente("BB");

        System.out.println("MOSTRANDO BICOLA ACTUAL");
        mostrar(cola);
        System.out.println("");

        System.out.println("ELIMINANDO ITEMS ...");
        System.out.println(cola.desencolar_frente());
        System.out.println(cola.desencolar_frente());
        System.out.println(cola.desencolar_final());
        System.out.println(cola.desencolar_final());
        cola.encolarFinal("ZZ");
        mostrar(cola);
    }
}
