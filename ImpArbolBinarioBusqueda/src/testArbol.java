public class testArbol {
    public static void main(String[] args) {
        ArbolBB<Integer >abb  = new ArbolBB<>();
        
        abb.agregar(12);
        abb.agregar(7);
        abb.agregar(3);
        abb.agregar(9);
        abb.agregar(17);
        abb.agregar(13);
        abb.agregar(16);
        abb.agregar(89);
        System.out.println("Recorrido");
        abb.inorden();
        System.out.println("---------------------");
        System.out.println("Encontrar el maximo");
        
        Integer resultado2= abb.max();
        
        System.out.println(resultado2);
        System.out.println(abb.max());
        
        System.out.println("Encontrar el minimo");
        System.out.println(abb.min());
        
        //Ejercicio 5
        Pila<Integer> pilaMayores=abb.mayoresque(16);
        System.out.println("Elemento mayores que X son:");
        
        while(!pilaMayores.esVacia()){
            System.out.println(" "+pilaMayores.desapilar());   
        }
        
        System.out.println("---------------------------");
        System.out.println("Sus antecesores son");
        //Ejercicio 6
        abb.mostrarAntecesores(3);
    }
}