public class sumaItemsArray {
    public static int sumaItems(int[] a) {
        int suma = 0;
        for (int i = 0; i < a.length; i++) {
            suma = suma + a[i];
        }
        return suma;
    }

    public static int sumaItemsRecursivo(int pos, int[] a) {
        if (pos == a.length - 1) return a[a.length - 1];
        else return a[pos] + sumaItemsRecursivo(pos + 1, a);
    }

    public static int sumaItemsRecursivo(int ini, int fin, int[] a) {
        if (ini == fin) return a[ini];
        else {
            int medio = (ini + fin)/2;
            return sumaItemsRecursivo(ini, medio, a) +
                sumaItemsRecursivo(medio + 1, fin, a);
        }        
    }

    public static void main(String[] args) {
        int[] a = { 1, 2 };
        System.out.println(sumaItems(a));
        System.out.println(sumaItemsRecursivo(0, a));
        System.out.println(sumaItemsRecursivo(0,a.length - 1, a));
    }
}
