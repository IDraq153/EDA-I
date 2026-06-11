public class ejercicioFactorial {
    public static int factorial(int n) {
        int f = 1;
        if (n == 0)
            return f;

        for (int i = n; i > 0; i--) {
            f = f * i;
        }
        return f;
    }

    public static int factorialRecursivo(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        else return n * factorialRecursivo(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(factorial(1));
        System.out.println(factorialRecursivo(5));
    }
}
