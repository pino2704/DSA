public class MyStack<E> implements StackInterface<E> {
    private Node<E> top;
    private int numNodes;
    
    public MyStack() {
        top = null;
        numNodes = 0;
    }

    public void push(E item) {
        top = new Node<E>(item, top);
        numNodes++;
    }

    public E pop() {
        if (top == null) {
            return null;
        }
        E temp = top.getData();
        top = top.getNext();
        numNodes--;
        return temp;
    }

    public int size() {
        return numNodes;
    }

    public boolean contains(E item) {
        Node<E> tmp = top;
        if (tmp == null) {
            return false;
        }
        if (tmp.getData().equals(item))     return true;

        while (tmp.getNext() != null) {
            tmp = tmp.getNext();
            if(tmp.getData().equals(item))  return true;
        }

        return false;
    }
    public boolean isEmpty() {
        if (top == null) {
            return true;
        }
        return false;
    }

    public E getPeek() {
        if (top == null) {
            return null;
        }
        return top.getData();
    }

    public void print() {
        Node<E> tmp = top;
        if (tmp == null) {
            System.out.println("Nothing to print");
            return;
        }
        System.out.print(tmp.getData());
        while (tmp.getNext() != null) {
            tmp = tmp.getNext();
            System.out.print(" -> " + tmp.getData());
        }
        System.out.println();
    }

    
}