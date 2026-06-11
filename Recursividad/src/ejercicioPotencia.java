public class ejercicioPotencia {

    public static int potencia(int base, int exp) {
        if (exp == 0)
            return 1;
        if (exp == 0 && base == 0)
            throw new RuntimeException("Solucion indeterminada");

        int p = 1;
        for (int i = 1; i <= exp; i++) {
            p = p * base;
        }
        return p;
    }

    public static int potenciaRecursiva(int base, int exp) {
        // Problema
        if (exp == 0 && base == 0)
            throw new RuntimeException("Solucion indeterminada");
        // Caso base
        if (exp == 0)
            return 1;
        // Caso recurrente
        else
            return base * potenciaRecursiva(base, exp - 1);
    }

    public static void main(String[] args) {
        System.out.println(potenciaRecursiva(10, 4));
    }
}
