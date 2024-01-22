public class SortedLinkedList {
    private Node<Integer> head;
    private int num_Nodes;

    public SortedLinkedList() {
        head = null;
        num_Nodes = 0;
    }

    public SortedLinkedList(Node<Integer> head) {
        this.head = head;
        num_Nodes = 1;
    }

    public void print() {
        if (head == null) {
            return;
        }
        System.out.print(head.getData());
        Node<Integer> tmp = new Node<Integer>(head.getData(), head.getNext());
        while (tmp.getNext() != null) {
            tmp = tmp.getNext();
            System.out.print(" -> " + tmp.getData());
        }
    }

    public void add(int data) {
        if(head == null) {
            head = new Node<>(data, head);
            num_Nodes++;
        } else if (head.getNext() == null) {
            if (head.getData() > data) {
                head = new Node<>(data, head);
                num_Nodes++;
            } 
            else {
                head.setNext(new Node<>(data));
                num_Nodes++;
            }  
        } else {
            Node<Integer> pre, curr = head, next;
            for (int i = 0; i < num_Nodes; i++) {
                if (head.getData() > data) {
                    head = new Node<>(data, head);
                    num_Nodes++;
                    break;
                }
                pre = curr;
                curr = curr.getNext();
                next = curr.getNext();
                if (next != null) {
                    if (pre.getData() < data && curr.getData() > data) {
                        Node<Integer> tmp = new Node<>(data, curr);
                        pre.setNext(tmp);
                        num_Nodes++;
                        break;
                    }
                }
                if (next == null) {
                    if (curr.getData() > data && pre.getData() < data) {
                        Node<Integer> tmp = new Node<>(data, curr);
                        pre.setNext(tmp);
                        num_Nodes++;
                        break;
                    }
                    if (curr.getData() < data) {
                        curr.setNext(new Node<>(data));
                        num_Nodes++;
                        break;
                    }
                }
            }
        }
    }

    public boolean remove(int data) {
        if(head == null) {
            return false;
        } 
        if (head.getData() == data) {
            head = head.getNext();
        }
        Node<Integer> curr = head, pre;
        while(curr.getNext() != null) {
            pre = curr;
            curr = curr.getNext();
            if(curr.getData() == data) {
                pre.setNext(curr.getNext());
                return true;
            }
        }
        return false;
    }
}
