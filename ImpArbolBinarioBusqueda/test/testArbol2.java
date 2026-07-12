public class testArbol2 {
    public static void main(String[] args) {
        ArbolBB<Integer> ab1 = new ArbolBB<>();
        ArbolBB<Integer> ab2 = new ArbolBB<>();

        ab1.agregar(5);
        ab1.agregar(9);
        ab1.agregar(7);
        ab1.agregar(3);
        ab1.agregar(8);
        ab1.agregar(12);
        ab1.buscar(8);
        
        ab2.agregar(12);
        ab2.agregar(8);
        ab2.agregar(3);
        ab2.agregar(7);
        ab2.agregar(9);
        ab2.agregar(5);
        ab2.buscar(8);
    }
}
