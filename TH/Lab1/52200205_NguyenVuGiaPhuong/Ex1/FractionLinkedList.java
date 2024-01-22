import java.util.NoSuchElementException;

public class FractionLinkedList implements ListInterface {
    private NodeFraction head;
    private int num_Nodes;

    public FractionLinkedList() {
        head = null;
    }

    public FractionLinkedList(NodeFraction head) {
        this.head = head;
    }

    public boolean contains(Fraction item) {
        if (head != null) {
            NodeFraction tmp = head;
            while(tmp.getNext() == null) {
                if(tmp.getData().equals(item)) {
                    return true;
                }
                tmp = tmp.getNext();
            }
        }
        return false;
    }

    public void addFrist(Fraction item) {
        head = new NodeFraction(item, head);
        num_Nodes++;
    }

    public void addAfter(NodeFraction curr, Fraction item) {
        if (head == null) {
            System.out.println("Linked List is null!");
            return;
        }
        if (curr != null) {
            if (contains(item)) {
                curr.setNext(new NodeFraction(item, curr.getNext()));
                num_Nodes++;
            } else {
                System.out.println(curr + " doesn't exist in linked list");
            }
        } else {
            System.out.println("Can't not find null element");
        }
    }

    public void addLast(Fraction item) {
        if (head == null) {
            head = new NodeFraction(item, head);
        } else {
            NodeFraction temp = head;
            while(temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(new NodeFraction(item));
            num_Nodes++;
        }
    }

    public Fraction removeFrist() throws NoSuchElementException {
        if (head == null) {
            throw new NoSuchElementException("Linked list doesn't have any element");
        }
        Fraction temp = head.getData();
        head.setNext(head.getNext());
        num_Nodes--;
        return temp;
    }

    public Fraction removeAfter(NodeFraction curr) throws NoSuchElementException {
        NodeFraction tmp;
        if (head == null) {
            throw new NoSuchElementException("Linked list doesn't have any element");
        } 
        if(head.getNext() == null) {
            throw new NoSuchElementException("There is only 1 element in LinkedList");
        }
        if (curr != null) {
            if (contains(curr.getData())) {
                tmp = curr.getNext();
                curr.setNext(tmp.getNext());
                num_Nodes--;
                return tmp.getData();
            } else {
                System.out.println(curr + " doesn't exist in linked list");
            }
        }
        return null;
    }
    public Fraction removeLast() throws NoSuchElementException {
        if (head == null) {
            throw new NoSuchElementException("Linked list doesn't have any element");
        } 
        NodeFraction curr = head;
        NodeFraction pre = null;
        while(curr.getNext() != null) {
            pre = curr;
            curr = curr.getNext();
        }
        pre.setNext(curr.getNext());
        return curr.getData();
    }

    public int size() {
        return num_Nodes;
    }

    public void print() {
        System.out.print(head.getData());
        NodeFraction tmp = head;
        while(tmp.getNext() != null) {
            System.out.print(" -> " + tmp.getNext().getData());
            tmp = tmp.getNext();
        }
        System.out.println();
    }

    public boolean isEmpty() {
        if(head == null) {
            return true;
        }
        return false;
    }

    public NodeFraction getHead() {
        return head;
    }

    public Fraction getFrist() {
        return head.getData();
    }
}    