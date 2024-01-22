public class Ex4 {
    public static int ex4a(int n, int i) {
        return (i > n) ? 0 : ex4a(n, i + 1) + 2 * i + 1;
    }

    public static int rCalFactorial(int n) {
        if (n == 0 || n == 1) return 1;
        return rCalFactorial(n - 1) * n;
    }

    public static int ex4b(int n, int i) {
        return (i > n) ? 0 : ex4b(n, i + 1) + rCalFactorial(i);
    }

    public static int ex4c(int n, int i) {
        return (i > n) ? 1 : ex4c(n, i + 1) * rCalFactorial(i);
    }

    public static int ex4d(int n, int r) {
        return (r > 0 && r >= n) ? 1 : ex4d(n, r + 2) * (n - r + 1);
    }

    public static int ex4e(int n) {
        return (n == 1) ? 3 : (int)Math.pow(2, n) + n*n + ex4e(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(ex4a(100, 1));
        System.out.println(ex4b(4, 1));
        System.out.println(ex4c(4, 1));
        System.out.println(ex4d(3, 1));
        System.err.println(ex4e(3));

    }
}
