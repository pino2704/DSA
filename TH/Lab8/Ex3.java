import java.util.Arrays;
public class Ex3 {
    public static void main(String[] args) {
        int[] arr = {15, 23, 18, 63, 21, 35, 36, 21, 66, 12, 42, 35, 75, 23, 64, 78, 39};
        MaxHeap maxH = new MaxHeap(0);
        MinHeap minH = new MinHeap(0);
        int[] ascendingArr = maxH.heapSort(arr);
        int[] descendingArr = minH.heapSort(arr);
        System.out.println(Arrays.toString(ascendingArr));
        System.out.println(Arrays.toString(descendingArr));
    }
}
