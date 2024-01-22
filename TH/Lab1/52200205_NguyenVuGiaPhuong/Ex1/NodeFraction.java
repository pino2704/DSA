public class NodeFraction {
    private Fraction data;
    private NodeFraction next;

    public NodeFraction() {
        this(null, null);
    }

    public NodeFraction(Fraction data) {
        this.data = data;
        next = null;
    }

    public NodeFraction(Fraction data, NodeFraction next) {
        this.data = data;
        this.next = next;
    }
    
    public Fraction getData() {
        return data;
    }

    public NodeFraction getNext() {
        return next;
    }

    public void setNext(NodeFraction curr) {
        next = curr;
    }
}
