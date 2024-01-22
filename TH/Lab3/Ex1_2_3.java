public class Ex1_2_3 {
    public static int calFactorial(int n) {
        int result = 1;
        if (n == 0) return result;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static int calXpowN(int x, int n) {
        if (x == 0)  return 0;
        if (n == 0  )    return 1;

        for (int i = 1; i < n - 1; i++) {
            x *= x;
        }
        return x;
    }

    public static int countNumberOfDigits(int n) {
        int count = 1;
        while(n > 9) {
            n /= 10;
            count++;
        }
        return count;
    }

    public static boolean isPrime(int n) {
        if (n == 0 || n == 1) return false;
        if (n == 2) return true;
        for (int i = 2; i < n/2; i++) {
            if (n%i == 0)   return false;
        }
        return true;
    }

    public static int calGDC(int n1, int n2) {
        for(int i = Math.min(n1, n2); i > 0; --i) {
            if (n1 % i == 0 && n2 % i == 0)
                return i;
        }
        return -1;
    }

    public static int rCalFactorial(int n) {
        if (n == 0 || n == 1) return 1;
        return rCalFactorial(n - 1) * n;
    }
    
    public static int rCalXpowN(int x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        return rCalFactorial(n - 1) * x;
    }

    public static int rCountNumberOfDigits(int n) {
        return n < 10 ? 1 : rCountNumberOfDigits(n/10) + 1;
    }
    
    public static int rCalGDC(int n1, int n2) {
        if (n1 == 0)    return n2;
        return rCalGDC(n2 % n1, n1);
    }

    public static boolean rIsPrime(int n, int d) {
        if (n == 0 || n == 1) return false;
        if (n == 2) return true;
        if (d > n/2)    return true;
        return n%d == 0 ? false : rIsPrime(n, d + 1);
    }

    public static void main(String[] args) {
        // System.out.println(calFactorial(8));
        // System.out.println(rCalFactorial(8));

        // System.out.println(calXpowN(2, 3));
        // System.out.println(rCalXpowN(2, 3));

        // System.out.println(countNumberOfDigits(10));
        // System.out.println(rCountNumberOfDigits(10));

        // System.out.println(calGDC(1701, 3768));
        // System.out.println(rCalGDC(1701, 3768));

        System.out.println(isPrime(1017));
        System.out.println(rIsPrime(1017, 2));

    }
}