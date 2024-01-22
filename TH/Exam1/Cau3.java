

public class Cau3 {
    public static int countSquareNumber(int[] a, int k) {
        if (k == a.length)  return 0;
        return (Math.sqrt(a[k])%1 == 0) ? 1 + countSquareNumber(a, k + 1) : countSquareNumber(a, k + 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 9, 10};
        System.out.println(countSquareNumber(arr, 0));
    }
}
