public class busquedaBinaria {
    public static int busquedaBinaria(int[] a, int clave) {
        int ini = 0, fin = a.length - 1;

        while (ini <= fin) {
            int medio = (ini + fin) / 2;
            if (a[medio] == clave) {
                return medio;
            } else if (a[medio] > clave) {
                fin = medio - 1;
            } else if (a[medio] < clave) {
                ini = medio + 1;
            }
        }
        return -1;
    }

    public static int busquedaBinariaRec(int[] a, int clave, int ini, int fin) {
        if (ini > fin) return -1;
        else {
            int medio = (ini + fin) /2;
            if (a[medio] == clave) {
                return medio;
            } else if (a[medio] > clave) {
                return busquedaBinariaRec(a, clave, ini, medio - 1);
            } else {
                return busquedaBinariaRec(a, clave, medio + 1, fin);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5, 6 };
        System.out.println(busquedaBinaria(a, 3));
        System.out.println(busquedaBinariaRec(a, 3, 0, a.length - 1));
    }
}
