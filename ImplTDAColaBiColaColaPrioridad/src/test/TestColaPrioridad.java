package test;
import tda.*;
public class TestColaPrioridad {
    public static void mostrar(ColaPrioridad<String> cola){
        ColaPrioridad<String> aux = new ColaPrioridad<>();
        // Desencolar todos los items de la cola original y 
        // almacenarlas temporalmente en la cola auxiliar
        while(!cola.estaVacia()){
            NodoPrioridad<String> tmp = cola.desencolar();
            System.out.println(tmp.getItem()+" "+ tmp.getPrioridad());
            aux.encolar(tmp.getItem(),tmp.getPrioridad());
        }
        // reestablecer la cola original, devolviendo los items de aux a cola
        while (!aux.estaVacia()){
            NodoPrioridad<String> tmp = aux.desencolar();
            cola.encolar(tmp.getItem(),tmp.getPrioridad());
        }
    }
    public static void main(String[] args) {
        ColaPrioridad<String> cola = new ColaPrioridad();
        cola.encolar("a",10);
        cola.encolar("b",5);
        cola.encolar("c",90);
        cola.encolar("d",80);
        cola.encolar("e",20);
        cola.encolar("f",100);
        System.out.println(cola.desencolar().getItem());
        cola.encolar("ZZ",80);
        mostrar(cola);
    }
    
}
