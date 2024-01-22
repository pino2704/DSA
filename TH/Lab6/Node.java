public class Node {
    Integer key;
    Node right, left;

    public Node(Integer key) {
        this.key = key;
        right = left = null;
    }

    public String toString() {
        return key.toString();
    }
}