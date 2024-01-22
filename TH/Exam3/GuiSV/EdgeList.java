import java.util.ArrayList;
import java.util.HashSet;

public class EdgeList {

    private ArrayList<Edge> edges;

    public EdgeList() {
        this.edges = new ArrayList<Edge>();
    }

    public void addEdge(Edge obj) {
        edges.add(obj);
    }

    // Cau 1
    public int findNumberVisitors() {
        HashSet<Integer> visitorIds = new HashSet<>();
        for (Edge edge : edges) {
            visitorIds.add(edge.getVisitor().getId());
        }
        return visitorIds.size();
    }
    // Cau 2
    public ArrayList<String> getDestinationsByVisitorRating(int v, int k) {
        ArrayList<String> result = new ArrayList<>();
        for (Edge edge : edges) {
            if (edge.getVisitor().getId() == v && edge.getRating() >= k) {
                result.add(edge.getDestination().getName());
            }
        }
        return result;
    }

   // Cau 3
   public double getAverageRating(String name) {
        double sum = 0;
        int count = 0;
        for (Edge edge : edges) {
            if (edge.getDestination().getName().equals(name)) {
                sum += edge.getRating();
                count++;
            }
        }
        return count > 0 ? sum / count : 0;
    }

    // Cau 4
    public ArrayList<String> findDestinationsHasFemaleRating() {
        HashSet<String> result = new HashSet<>();
        for (Edge edge : edges) {
            if (edge.getVisitor().getGender().equals("F")) {
                result.add(edge.getDestination().getName());
            }
        }
        return new ArrayList<>(result);
    }

    // Cau 5
    public ArrayList<String> findEvenRatingVisitors(ArrayList<Visitor> visitors) {
        ArrayList<String> result = new ArrayList<>();
        for (Visitor visitor : visitors) {
            boolean hasEvenRating = false;
            for (Edge edge : edges) {
                if (edge.getVisitor().equals(visitor) && edge.getRating() % 2 == 0) {
                    hasEvenRating = true;
                    break;
                }
            }
            if (hasEvenRating) {
                result.add(visitor.getName());
            }
        }
        return result;
    
    }
}