public class Ex6_7 {
    public static int findMin(int[] arr, int n) {
        int min = arr[0];
        for(int i = 1; i < n; i++) {
            if(arr[i] < min)    min = arr[i];
        }
        return min;
    } 

    public static int sum(int[] arr, int n) {
        int sum = 0;
        for(int i = 0; i < n; i++) 
            sum += arr[i];
        return sum;
    }

    public static int countEven(int[] arr, int n) {
        int count = 0;
        for(int i = 0; i < n; i++) 
            if(arr[i] % 2 == 0) count++;
        return count;
    }

    public static int rFindMin(int[] arr, int len) {
        if(len == 0)    return arr[len];
        return arr[len] < rFindMin(arr, len - 1) ? arr[len] : rFindMin(arr, len - 1);
    }

    public static int rSum(int[] arr, int n) {
        if(n == 0)  return arr[n];
        return arr[n] + rSum(arr, n - 1);
    }

    public static int rCountEven(int[] arr, int len, int count) {
        if(len == -1)    return count;
        return arr[len] % 2 == 0 ? rCountEven(arr, len - 1, count + 1) : rCountEven(arr, len - 1, count);
    }

    public static void main(String[] args) {
        int[] arr = {4, 7, 1, 2, -1};
        System.out.println(countEven(arr, arr.length));
        System.out.println(rCountEven(arr, arr.length - 1, 0));
    }
}
