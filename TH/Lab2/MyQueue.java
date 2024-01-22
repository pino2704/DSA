public class MyQueue<E> implements QueueInterface<E> {
   private Node<E> front;
   private Node<E> rear;
   private int numNodes;

   public MyQueue() {
    front = null;
    rear = null;
    numNodes = 0;
   }

   public void enQueue(E item) {
    if (front == null) {
        front = new Node<E>(item);
        rear = front;
        numNodes++;
    } else {
        Node<E> tmp = new Node<E>(item);
        rear.setNext(tmp);
        rear = tmp;
        numNodes++;
    }
    
   }

   public E deQueue() {
    if(front == null) {
        return null;
    }
    E tmp = front.getData();
    front = front.getNext();
    numNodes--;
    return tmp;
   }

   public int size() {
    return numNodes;
   }

   public boolean contains(E item) {
        Node<E> tmp = front;
        if (front == null) {
            return false;
        }
        if (tmp.getData().equals(item))     return true;

        while (tmp.getNext() != null) {
            tmp = tmp.getNext();
            if(tmp.getData().equals(item))  return true;
        }

        return false;
   }

    public void print() {
        Node<E> tmp = front;
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

    public boolean isEmpty() {
        return front == null;
    }

    public E getFront() {
        if(front == null) {
            return null;
        }
        return front.getData();
    }
}