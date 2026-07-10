public class ejercicio_1_2_3_4 {
    public static void main(String[] args) {
        System.out.println("EJERCICIO 1: " + eje1_recursiva(5));
        System.out.println("EJERCICIO 2: " + eje2_recursiva(3,3));
        System.out.println("EJERCICIO 3: " + eje3_recursiva(5,3));
        System.out.println("EJERCICIO 4: " + eje4_recursiva(5,3));
    }

    public static double eje1_recursiva(int n) {
        if (n == 1) return 1;
        else return (1.0 / n) + eje1_recursiva(n - 1);
    }

    public static int eje2_recursiva(int x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        else {
            if (n % 2 == 0) return eje2_recursiva(x * x, n / 2);
            else return x * eje2_recursiva(x, n - 1);
        }
    }

    public static int eje3_recursiva(int n, int m) {
        if (n < 0 || m < 0 || m > n) return 0;
        if (m == 0 || n == m) return 1;
        else {
            return eje3_recursiva(n - 1, m - 1) +
                    eje3_recursiva(n - 1, m);
        }
    }

    public static int eje4_recursiva(int x, int y) {
        int G = 0;
        if (y == 0) G = 1;
        else G = x * eje4_recursiva(x, y - 1);
        return G;
    }
}
