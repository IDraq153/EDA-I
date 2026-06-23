package test;
import tdaBi.BiCola;

public class testBicola {
    public static void main(String[] args) {
        BiCola<Integer> bicola = new BiCola<>();
        bicola.encolarAlFinal(8);
        bicola.encolarAlFinal(5);
        bicola.encolarAlFinal(4);

        bicola.encolarAlFrente(1);
        bicola.encolarAlFrente(2);
        bicola.encolarAlFrente(3);
        
        while (!bicola.estaVacia()) {
            int temp = bicola.desencolarFrente();
            System.err.print(temp + "\t");
        }
    }    
}
