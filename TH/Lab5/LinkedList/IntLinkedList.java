public class IntLinkedList implements ListInterface {
    private Node head;

    public IntLinkedList() {
        head = null;
    }

    public IntLinkedList(IntLinkedList ill) {
        if(ill.head != null) {
            Node tmp = ill.head;
            addLast(tmp.getData());
            while(tmp.getNext() != null) {
                tmp = tmp.getNext();
                addLast(tmp.getData());
            }
        }
    }

    public void addFirst(int data) {
        head = new Node(data, head);
    }

    public boolean addLast(int data) {
        if (head == null) {
            head = new Node(data, head);
            return true;
        }

        Node tmp = head;
        while(tmp.getNext() != null) {
            tmp = tmp.getNext();
            if(tmp.getData() == data)   return false;
        }
        tmp.setNext(new Node(data, null));
        return true;
    }

    public boolean removeAt(int position) {
        if (head == null)    return false;
        if (position == 1) {
            head = head.getNext();
            return true;
        }
        int pos = 1;
        Node tmp = head, pre;

        while(tmp.getNext() != null) {
            pre = tmp;
            tmp = tmp.getNext();
            pos++;
            if(pos == position) {
                pre.setNext(tmp.getNext());
                return true;
            }
        }
        return false;
    }

    public int countOdd() {
        int count = 0;
        if (head == null)   return count;
        if (head.getData()%2 == 0)  count++;

        Node tmp = head;
        while(tmp.getNext() != null) {
            tmp = tmp.getNext();
            if(tmp.getData()%2 == 0)    count++;
        }
        return count;
    }

    public int searchKey(int key) {
        int count = 0;
        if (head == null)   return -1;
        if (head.getData() == key)  return count;

        Node tmp = head;
        while(tmp.getNext() != null) {
            tmp = tmp.getNext();
            count++;
            if(tmp.getData() == key)    return count;    
        }
        return -1;
    }

    public int size() {
        int count = 0;
        if (head == null)   return count;
        else    count++;
        Node temp = head;
        while(temp.getNext() != null) {
            temp = temp.getNext();
            count++;
        }
        return count;
    }

    private void merge(int[] arr, int i, int mid, int j) {
        int[] temp = new int[j - i + 1];
        int left = i, right = mid + 1, idx = 0;

        while(left <= mid && right <= j) {
            if(arr[left] < arr[right]) {
                temp[idx++] = arr[left++];
            } else {
                temp[idx++] = arr[right++];
            }
        }
        while(left <= mid) {
            temp[idx++] = arr[left++];
        }
        while(right <= j) {
            temp[idx++] = arr[right++];
        }
        
        for (int k = 0; k < temp.length; k++) {
            arr[i + k] = temp[k];
        }
    }

    private int[] toIntArray() {
        if (head != null) {
            int[] arr = new int[size()];
            Node temp = head;
            arr[0] = head.getData();
            int i = 1;
            while(temp.getNext()!= null) {
                temp = temp.getNext();
                arr[i++] = temp.getData();
            }
            return arr;
        }
        return null;
    }

    private void mergeSort(int[] arr, int i, int j) {
        if(i < j) {
            int mid = (i + j) / 2;
            mergeSort(arr, i, mid);
            mergeSort(arr, mid + 1, j);
            merge(arr, i, mid, j);
        }
    }

    public boolean checkSorted() {
        if (head == null)    return false;
        int[] arr = toIntArray();
        mergeSort(arr, 0, arr.length - 1);
        Node tmp = head;
        if (tmp.getData() != arr[0])    return false;
        for(int i = 1; i < arr.length && tmp.getNext() != null; i++) {
            tmp = tmp.getNext();
            if (arr[i] != tmp.getData())    return false;
        }
        return true;
    }

    public void print() {
        if (head != null) {
            System.out.print(head.getData());
            Node tmp = head;
            while(tmp.getNext() != null) {
                tmp = tmp.getNext();
                System.out.print(" -> " + tmp.getData());
            }
            System.out.println();
        }
    }
}
