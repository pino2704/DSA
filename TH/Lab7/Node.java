public class Node {
    Integer key;
    Node right, left;
    int height;

    public Node(Integer key) {
        this.key = key;
        this.height = 0;
        this.right = this.left = null;
    }

    public String toString() {
        return key.toString();
    }
}