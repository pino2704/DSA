import java.util.Arrays;
class Sorting {
    public static int[] bubbleSort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static int[] selectionSort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int index = i;
            for(int j = i; j < arr.length; j++) {
                if(arr[index] < arr[j]) {
                    index = j;
                }
            }
            if(index != i) {
                int tmp = arr[i];
                arr[i] = arr[index];
                arr[index] = tmp;
            }
        }
        return arr;
    }

    public static int[] insertionSort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while(j >= 0 && temp < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {89, 40, 46, 55, 54, 5, 50, 73, 23, 47};

        // System.out.println(Arrays.toString(bubbleSort(arr)));

        System.out.println(Arrays.toString(selectionSort(arr)));

        // System.out.println(Arrays.toString(insertionSort(arr)));

        // MyComarator mc = new MyComarator(arr);
        // System.out.println(mc.toString());
    }
}

class MyComarator {
    private int[] evenArr;
    private int[] oddArr;
    private int[] arrResult;

    public void setSize(int[] arr) {
        int countEven = 0, countOdd = 0;
        for(int e : arr) {
            if(e % 2 == 0)  countEven++;
            else countOdd++;
        }
        evenArr = new int[countEven + 1];
        oddArr = new int[countOdd + 1];
    }

    public void sortAsc(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public void sortDesc(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public MyComarator(int[] arr) {
        arrResult = new int[arr.length];
        int k = 0, p = 0;
        setSize(arr);
        for(int i = 0; i < arr.length; i++) {
            if(i%2 == 0) {
                evenArr[k++] = arr[i];
            } 
            if(i%2 != 0) {
                oddArr[p++] = arr[i];
            }

        }
        sortAsc(evenArr);
        sortDesc(oddArr);
        for(int i = 0; i < k; i++) {
            arrResult[i] = evenArr[i];
        }
        for(int i = k - 1; i < arr.length; i++) {
            arrResult[i] = oddArr[i - k + 1];
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(arrResult);
    }
}