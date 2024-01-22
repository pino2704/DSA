
import java.util.NoSuchElementException;

public class MinHeap {
    public static void main(String[] args) {
        MinHeap mh = new MinHeap(10);
        mh.insert(49);
        mh.insert(32);
        mh.insert(28);
        mh.insert(16);
        mh.insert(20);
        mh.insert(9);
        mh.insert(1);

        mh.extractMin();

        mh.print();
    }

    public int[] heapSort(int[] arr) {
        MinHeap tmp = new MinHeap(0);
        MinHeap mh = tmp.buildMinHeap(arr);
        int[] heapArr = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            heapArr[i] = mh.extractMin();
        }
        return heapArr;
    }


    //---------------------------------------------------------------\\
    int[] heap;
    int heapSize;
    int maxSize;

    public MinHeap(int capity) {
        heapSize = 0;
        this.maxSize = capity;
        heap = new int[maxSize + 1];
        heap[0] = -1;
    }

    private int parent(int i) {
        return i/2;
    }

    private int left(int i) {
        return i*2;
    }

    private int right(int i) {
        return i*2 + 1;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void shiftUp(int i) {
        while(i > 1 && heap[parent(i)] > heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }
    
    public void insert(int key) {
        if(heapSize == maxSize) {
            throw new NoSuchElementException("Overflow Exception");
        } 
        heapSize++;
        heap[heapSize] = key;
        shiftUp(heapSize);
    }

    private void shiftDown(int i) {
        int indexMin, mim;
        while(i <= heapSize) {
            indexMin = i;
            mim = heap[i];
            if(left(i) <= heapSize && heap[left(i)] < mim) {
                mim = heap[left(i)];
                indexMin = left(i);
            }
            if(right(i) <= heapSize && heap[right(i)] < mim) {
                mim = heap[right(i)];
                indexMin = right(i);
            }
            if(indexMin != i) {
                swap(indexMin, i);
                i = indexMin;
            } else {
                break;
            }
        }
    }

    public int extractMin() {
        int min = heap[1];
        heap[1] = heap[heapSize];
        heapSize--;
        shiftDown(1);
        return min;
    }

    public MinHeap buildMinHeap(int[] arr) {
        MinHeap mh = new MinHeap(arr.length + 1);
        for(int num : arr) {
            mh.insert(num);
        }
        return mh;
    }

    public void print() {
        for(int i = 1; i <= heapSize; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}