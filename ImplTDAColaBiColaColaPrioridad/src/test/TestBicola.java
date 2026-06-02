package test;
import tda.BiCola;
public class TestBicola {
    public static void mostrar(BiCola<String> cola){
        BiCola<String> aux = new BiCola<>();
        // Desencolar todos los items de la cola original y 
        // almacenarlas temporalmente en la cola auxiliar
        while(!cola.estaVacia()){
            String tmp = cola.desencolar();
            System.out.print(tmp + "\t");
            aux.encolar(tmp);
        }
        // reestablecer la cola original, devolviendo los items de aux a cola
        while (!aux.estaVacia()){
            cola.encolar(aux.desencolar());
        }
    }
    public static void main(String[] args) {
        BiCola<String> cola = new BiCola();
        cola.encolar("a");
        cola.encolar("b");
        cola.encolar("c");
        cola.encolar("d");
        cola.encolar("e");
        cola.encolar("f");
        cola.encolarFrente("AA");
        cola.encolarFrente("BB");
        System.out.println(cola.desencolar());
        System.out.println(cola.desencolar());
        System.out.println(cola.desencolar_final());
        System.out.println(cola.desencolar_final());
        cola.encolar("ZZ");
        mostrar(cola);
    }
    
}
