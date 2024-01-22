import java.util.Arrays;
public class Ex1 {
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[index] > arr[j]) {
                    index = j;
                }
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
    }

    public static void bubbleSort(int[] arr) {
        boolean flan = true;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flan = false;
                }
            }
            if(flan)    return;
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j, temp = arr[i];
            for (j = i - 1; j >= 0 && arr[j] > temp; j--) {
                if (temp < arr[j]) {
                    arr[j+1] = arr[j];
                }
                arr[j] = temp;
            }
        }
    }

    public static void merge(int[] arr, int i, int mid, int j) {
        int[] temp = new int[j - i + 1];
        int left = i, right = mid + 1, index = 0;
        while (left <= mid && right <= j) {
            if(arr[left] <= arr[right]) {
                temp[index++] = arr[left++];
            } else {
                temp[index++] = arr[right++];
            }
        }
        while (left <= mid) {
            temp[index++] = arr[left++];
        }
        while (right <= j) {
            temp[index++] = arr[right++];
        }

        for (int k = 0; k < temp.length; k++) {
            arr[i + k] = temp[k];
        }
    }

    public static void mergeSort(int[] arr, int i, int j) {
        if (i < j) {
            int mid = (i + j) / 2;
            mergeSort(arr, i, mid);
            mergeSort(arr, mid + 1, j);
            merge(arr, i, mid, j);
        }
    }
    public static void swap(int[] arr, int base, int key) {
        int temp = arr[base];
        arr[base] = arr[key];
        arr[key] = temp;
    }

    public static int partition(int[] arr, int i, int j) {
        int pv = arr[i], m = i;
        for (int k = i + 1; k <= j; k++) {
            if (arr[k] < pv) {
                m++;
                swap(arr, k, m);
            }
        }
        swap(arr, i, m);
        return m;
    }

    public static void quickSort(int[] arr, int i, int j) {
        if (i < j) {
            int pvIdx = partition(arr, i, j);
            quickSort(arr, 0, pvIdx - 1);
            quickSort(arr, pvIdx + 1, j);
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {5, 8, 9, 1, 6, 9, 0};
        // selectionSort(arr);
        // bubbleSort(arr);
        // insertionSort(arr);
        // mergeSort(arr, 0, arr.length - 1);
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}