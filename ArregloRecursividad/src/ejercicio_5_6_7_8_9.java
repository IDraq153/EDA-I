public class ejercicio_5_6_7_8_9 {
    public static void main(String[] args) {
        int[] array = {1,5,11,13,15,19,41,53};
        System.out.println("Array:" + eje5_recursiva(array, array.length));
        System.out.println("Menores que X: " + eje6_recursiva(array, array.length, 3));
        System.out.println("Buscar: " + eje7_recursiva(array, array.length, 1));
        System.out.println("Mayor: " + eje8_recursiva(array, array.length, 0));
        System.out.println("Negativos: " + eje9_recursiva(array, array.length));
        System.out.println("Busqueda: " + busquedaBinaria(array, 0, array.length - 1, 11));
    }

    public static int eje5_recursiva(int[] array, int pos) {
        if (pos == 0) return 0;
        else return array[pos - 1] + eje5_recursiva(array, pos - 1);
    }
 
    public static int eje6_recursiva(int[] array, int pos, int x) {
        if (pos == 0) return 0;
        else {
            if (array[pos - 1] <= x) return 1 + eje6_recursiva(array, pos - 1, x);
            else return eje6_recursiva(array, pos - 1, x);
        }
    }

    public static boolean eje7_recursiva(int[] array, int pos, int elem) {
        if (pos == 0) return false;
        else {
            if (array[pos - 1] == elem) return true;
            else return eje7_recursiva(array, pos - 1, elem);
        }
    }

    public static int eje8_recursiva(int[] array, int pos, int mayor) {
        if (pos == 0) return mayor;
        else {
            if (array[pos - 1] > mayor) mayor = array[pos - 1];
            return eje8_recursiva(array, pos - 1, mayor);
        }
    }

    public static boolean eje9_recursiva(int[] array, int pos) {
        if (pos == 0) return false;
        else {
            if (array[pos - 1] < 0) return true;
            else return eje9_recursiva(array, pos - 1);
        }
    }

    public static int busquedaBinaria(int[] array, int ini, int fin, int x) {
        if (ini > fin) return -1;
        else {
            int medio = (ini + fin) / 2;
            if (array[medio] == x) return medio;
            else if (array[medio] > x) return busquedaBinaria(array, ini, medio - 1, x);
            else return busquedaBinaria(array, medio + 1, fin, x);
        }
    }
}
