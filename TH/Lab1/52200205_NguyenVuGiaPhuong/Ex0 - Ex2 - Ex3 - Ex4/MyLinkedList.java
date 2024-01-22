
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements ListInterface<E> {
    protected Node<E> head;
    protected int numNodes;

    public MyLinkedList() {
        head = null;
        numNodes = 0;
    }

    public MyLinkedList(Node<E> head) {
        this.head = head;
        numNodes = 1;
    }

    public int size() {
        return numNodes;
    }

    public void print() {
        System.out.print(head.getData());
        Node<E> tmp = new Node<E>(head.getData(), head.getNext());
        while (tmp.getNext() != null) {
            tmp = tmp.getNext();
            System.out.print(" -> " + tmp.getData());
        }
    }

    public boolean isEmpty() {
        return numNodes == 0;
    }

    public Node<E> getHead() {
        if(head == null) {
            throw new NoSuchElementException("Can't get from an empty list!");
        }
        return head;
    }

    protected void setHead(Node<E> head) {
        this.head = head;
    }

    public E getFrist() {
        if(head == null) {
            throw new NoSuchElementException("Can't get from an empty list!");
        }
        return head.getData();
    }

    public boolean contains(E item) {
        Node<E> tmp = head;
        while(tmp.getNext() != null) {
            if(tmp.getData().equals(item))  return true;
        }
        return false;
    }

    public void addFrist(E item) {
        head = new Node<E>(item, head);
        numNodes++;
    }

    public void addAfter(Node<E> curr, E item) {
        if (curr != null && contains(curr.getData())) {
            if(head == null) {
                head = new Node<E>(item);
                numNodes++;
            } else {
                Node<E> tmp = new Node<E>(item, curr.getNext());
                curr.setNext(tmp);
                numNodes++;
            }
        }
    }

    public void addLast(E item) {
        if(head == null) {
            head = new Node<E>(item);
            numNodes++;
        } else if (head.getNext() == null) {
            head.setNext(new Node<E>(item));
            numNodes++;
        } else {
            Node<E> tmp = head;
            while(true) {
                tmp = tmp.getNext();
                if (tmp.getNext() == null) {
                    tmp.setNext(new Node<E>(item));
                    numNodes++;
                    break;
                }
            }
        }
    }

    public E removeFrist() throws NoSuchElementException{
        if(head == null) {
            throw new NoSuchElementException("Head is null!");
        } else {
            Node<E> tmp = head;
            head = head.getNext();
            numNodes--;
            return tmp.getData();
        }
    }

    public E removeAfter(Node<E> curr) {
        if (curr != null && contains(curr.getData())) {
            if(head == null) {
                throw new NoSuchElementException("Head is null!");
            } else {
                Node<E> tmp = curr.getNext();
                if (tmp != null) {
                    curr.setNext(tmp.getNext());
                    numNodes--;
                    return tmp.getData();
                }
                throw new NoSuchElementException("There is only 1 element in LinkedList!");
            }
        }
        throw new NoSuchElementException("Curr is null or LinkedList doesn't contain current");
    }

    public E removeLast() {
        if (head == null) {
            throw new NoSuchElementException("Head is null!");
        } else {
            Node<E> tmp = new Node<E>(head.getData(), head.getNext());
            Node<E> delNode = tmp.getNext();
            while(delNode.getNext() != null) {
                tmp = tmp.getNext();
                delNode = delNode.getNext();
            }
            tmp.setNext(null);
            numNodes--;
            return delNode.getData();
        }
    }

    public E removeCurr(Node<E> curr) throws NoSuchElementException {
        if (head == null) {
            throw new NoSuchElementException("Head is null!");
        }
        Node<E> temp = head;
        if(head.equals(curr)) {
            head = head.getNext();
            return curr.getData();
        } else {
            while(temp.getNext() != null) {
                if(temp.getNext().equals(curr)) {
                    temp.setNext(curr.getNext());
                    numNodes--;
                    return curr.getData();
                }
                temp = temp.getNext();
            }
        }
        
        throw new NoSuchElementException(curr.getData() + " is not exist");
        
    }
}