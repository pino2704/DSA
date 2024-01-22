public class Edge {
    private Visitor visitor;
    private Destination destination;
    private int rating;

    public Edge(Visitor visitor, Destination destination, int rating) {
        this.visitor = visitor;
        this.destination = destination;
        this.rating = rating;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

}
