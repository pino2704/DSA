public class Ex1 {
    public static double prod_recur(int a, int b) {
        if(a == 0)  return b;
        return a * prod_recur(0, b);
    }

    public static int bin2dec(int n, int exp) {
        if (n == 0) return 0;
        return (n%10 == 1) ? bin2dec(n/10, exp + 1) + (int)Math.pow(2, exp) : bin2dec(n/10, exp + 1);
    }

    public static int maxDigit(int n) {
        if (n < 10) return n;
        return maxDigit(n/10) > n%10 ? maxDigit(n/10) : n%10;
    }

    public static int maxElement(int a[], int n) {
        if (n == 0) return a[0];
        return maxElement(a, n - 1) > a[n] ? maxElement(a, n - 1) : a[n];
    }

    public static int search(int a[], int n, int key) {
        if(n == -1) return n;
        return (a[n] == key) ? n : search(a, n - 1, key);
    }

    public static int findLastEvenPosition(int a[], int n) {
        if(n == -1) return n;
        return (a[n]%2 == 0) ? n : findLastEvenPosition(a, n - 1);
    }

    public static void main(String[] args) {
        // System.out.println(prod_recur(3, 2));

        // System.out.println(bin2dec(1000, 0));
    
        // System.out.println(maxDigit(71395));

        int[] a = {7, 1, 8, 3, 9, 5};
        // System.out.println(maxElement(a, a.length - 1));

        // System.out.println(search(a, a.length - 1, 9));

        System.out.println(findLastEvenPosition(a, a.length - 1));
    }
}
