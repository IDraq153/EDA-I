public class ejercicioTorresHanoi {
    public static void hanoi(int n, String posA, String posB, String posC) {
        if (n == 1) {
            System.out.println("Mover disco: " + n + " de " + posA + " a " + posC);
        } else {
            hanoi(n - 1, posA, posC, posB);
            System.out.println("Mover disco: " + n + " de " + posA + " a " + posC);
            hanoi(n - 1, posB, posA, posC);
        }
    }

    public static void main(String[] args) {
        hanoi(2, "A", "B", "C");
    }
}
