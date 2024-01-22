public class CharLinkedList implements ListInterface {
    private Node head;

    public CharLinkedList() {
        head = null;
    }

    public Node getHead() {
        return head;
    }

    public void addFirst(char data) {
        head = new Node(data, head);
    }

    public boolean addAfterFirstKey(char data, char key) {
        if(head == null)    return false;
        if(head.getData() == key) {
            head.setNext(new Node(data, head.getNext()));
            return true;
        }
        Node tmp = head;
        while(tmp.getNext() != null) {
            tmp = tmp.getNext();
            if(tmp.getData() == key) {
                tmp.setNext(new Node(data, tmp.getNext()));
                return true;
            }
        }
        return false;
    }

    public int largestCharPostition() {
        if(head == null)    return -1;
        int count = 0, idx = 0;
        int max = (int) head.getData();
        Node tmp = head;
        while (tmp.getNext() != null) {
            count++;
            tmp = tmp.getNext();
            if(max < (int)tmp.getData()) {
                max = (int)tmp.getData();
                idx = count;
            }   
        }
        return count;
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
