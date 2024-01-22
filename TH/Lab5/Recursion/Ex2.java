public class Ex2 {
    public static int a(int n) {
        if(n == 0)  return 0;
        return a(n - 1) + (int)Math.pow(2, n);
    }

    public static double b(int n) {
        if (n == 0) return 1.0/2;
        return b(n - 1) + (n + 1)/2.0;
    }

    public static int gt(int n) {
        return n == 1 ? n : n * gt(n - 1);
    }

    public static int d(int n) {
        return (n == 1) ? (n * (n - 1)) : (n * ( n - 1) + d(n - 1));
    }

    public static double c(int n) {
        return (n == 1) ? (gt(n) / gt(n - 1)) : ((gt(n) / gt(n - 1)) + c(n - 1));
    }

    public static int e(int n) {
        return (n == 1) ? n : n * e(n - 1);
    }
    
    public static void main(String[] args) {
        System.out.println(gt(3));
    }
}
