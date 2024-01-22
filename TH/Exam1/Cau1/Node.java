package Cau1;
public class Node {
    private char value;
    private Node next;

    public Node(char data, Node next) {
        this.value = data;
        this.next = next;
    }

    public char getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
