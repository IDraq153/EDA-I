public class testArbol {
    public static void main(String[] args) {
        ArbolBB<Integer> abb = new ArbolBB<>();
        abb.agregar(2);
        abb.agregar(3);
        abb.agregar(5);
        abb.agregar(1);
        abb.agregar(10);
        abb.agregar(7);

        abb.inorden();
    }
}