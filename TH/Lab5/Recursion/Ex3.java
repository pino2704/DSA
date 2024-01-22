public class Ex3 {
    public static double a(int n) {
        return (n == 0) ? 2 : 2 - 1.0/2 * a(n - 1);
    }

    public static double b(int n) {
        return (n < 10) ? 1 : 1 + b(n/10);
    }

    public static int c(int n, int k) {
        return (k == 1) ? n : n + c(n, k - 1); 
    }

    public static int d(int n) {
        if(n == 0)  return 0;
        return (n == 1) ? 1 : d(n - 1) + d(n - 2); 
    }
    public static void main(String[] args) {

    }
}
