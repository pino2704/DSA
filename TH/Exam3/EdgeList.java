import java.util.ArrayList;
import java.util.HashSet;

public class EdgeList {
    private ArrayList<Edge> edges;

    public EdgeList() {
        edges = new ArrayList<Edge>();
    }

    public void addEdge(Edge obj) {
        edges.add(obj);
    }

    //Cau 1
    public int findNumberVisitors() {
        HashSet<String> visitor = new HashSet<>();
        for(int i = 0; i < edges.size(); i++) {
            visitor.add(edges.get(i).getVisitor().getName());
        }
        return visitor.size();
    }

    //Cau 2
    public ArrayList<String> getDestinationsByVisitorRating(int v, int r) {
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < edges.size(); i++) {
            if(edges.get(i).getVisitor().getId() == v && edges.get(i).getRating() >= r) {
                set.add(edges.get(i).getDestination().getName());
            }
        }
        ArrayList<String> list = new ArrayList<>();
        list.addAll(set);
        return list;
    }

    //Cau 3
    public double getAverageRating(String name) {
        ArrayList<Double> listRating = new ArrayList<>();
        for(int i = 0; i < edges.size(); i++) {
            if(edges.get(i).getDestination().getName().equals(name)) {
                listRating.add(Double.valueOf(edges.get(i).getRating()));
            }
        }
        Double sumRating = 0.0;
        for(Double r : listRating) {
            sumRating += r;
        }
        if(listRating.isEmpty())    return sumRating;
        return sumRating / listRating.size();
    }

    //Cau 4
    public ArrayList<String> findDestinationsHasFemaleRating() {
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < edges.size(); i++) {
            if(edges.get(i).getVisitor().getGender().equals("F")) {
                set.add(edges.get(i).getDestination().getName());
            }
        }
        ArrayList<String> list = new ArrayList<>();
        list.addAll(set);
        return list;
    }

    //Cau 5
    public ArrayList<String> findEvenRatingVisitors(ArrayList<Visitor> visitors) {
        ArrayList<String> listName = new ArrayList<>();
        ArrayList<Integer> listTimeOfRating = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();
        for(Visitor vi : visitors) {
            if(!listName.contains(vi.getName())) {
                listName.add(vi.getName());
            }
        }

        for(String name : listName) {
            int count = 0;
            for(Edge e : edges) {
                if(e.getVisitor().getName().equals(name))   count++;
            }
            listTimeOfRating.add(count);
        }

        for(int i = 0; i < listTimeOfRating.size(); i++) {
            if(listTimeOfRating.get(i) % 2 == 0) {
                result.add(listName.get(i));
            } 
        }
        return result;
    }
}
