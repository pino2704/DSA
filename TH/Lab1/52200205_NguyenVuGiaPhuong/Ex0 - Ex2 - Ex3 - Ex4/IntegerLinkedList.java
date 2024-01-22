import java.util.NoSuchElementException;

public class IntegerLinkedList extends MyLinkedList<Integer> {
    public IntegerLinkedList(Node<Integer> head) {
        super.head = head;
        numNodes = 1;
    } 
    
    public int countEven() throws NoSuchElementException{
        int count = 0;
        Node<Integer> temp = getHead();
        if (temp == null) {
            throw new NoSuchElementException("Linked list is null");
        }
        while(temp.getNext() != null) {
            if (temp.getData() % 2 == 0) {
                count++;
            }
            temp = temp.getNext();
        }
        return count;
    }

    public int countPrime() throws NoSuchElementException {
        int count = 0;
        Node<Integer> temp = getHead();
        if (temp == null) {
            throw new NoSuchElementException("Linked list is null");
        }
        while(temp.getNext() != null) {
            boolean check = true;
            if (temp.getData() == 2) {
                count++;
            } else {
                for (int i = 2; i < Math.sqrt(temp.getData()); i++) {
                    if (temp.getData()/i == 0)  check = false;
                }
                if (check)  count++;
            }
            temp = temp.getNext();
        }
        return count;
    }

    public void addBeforeFristEven(Integer item) throws NoSuchElementException {
        Node<Integer> temp = getHead();
        if (temp == null) {
            throw new NoSuchElementException("Linked list is null");
        }
        if (temp.getData() % 2 ==0) {
            addFrist(item);
            numNodes++;
        } else {
            while(temp.getNext() != null) {
                if(temp.getNext().getData() % 2 == 0) {
                    addAfter(temp, item);
                    numNodes++;
                    break;
                }
            }
        }
    }

    public Integer findMax() throws NoSuchElementException {
        Node<Integer> temp = getHead();
        if (temp == null) {
            throw new NoSuchElementException("Linked list is null");
        }
        Integer max = temp.getData();
        while(temp.getNext() != null) {
            temp = temp.getNext();
            if(max < temp.getData()) {
                max = temp.getData();
            }
        }
        return max;
    }

    public void reserve() throws NoSuchElementException {
        Node<Integer> curr = getHead();
        if (curr == null) {
            throw new NoSuchElementException("Linked list is null");
        }
        Node<Integer> pre = null, next = null;
        while(curr != null) {
            next = curr.getNext();
            curr.setNext(pre);
            pre = curr;
            curr = next;
        }
        setHead(pre);
    }

    

    public void sortAscending() {
        Node<Integer> curr = getHead();
        if (curr == null) {
            throw new NoSuchElementException("Linked list is null");
        }

        Node<Integer> next = head.getNext();
        for(int i = 1; i < numNodes; i++) {
            for(int j = i; j < numNodes; j++) {
                if (curr.getData() > next.getData()) {
                    swap(curr, next);
                }
                next = next.getNext();
            }
            curr = curr.getNext();
            next = curr.getNext();
        }
    }

    private void swap(Node<Integer> n1, Node<Integer> n2) {
        if(n1 == null || n2 == null) {
            return;
        }
        Integer temp = n2.getData();
        n2.setData(n1.getData());
        n1.setData(temp);
    }

}