import java.util.Vector;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class EdgeList {
    private Vector<TripleInteger> edges;

    public EdgeList() {
        edges = new Vector<TripleInteger>();
    }

    public void addEdge(TripleInteger num) {
        edges.add(num);
    }

    public int noVertices() {
        HashSet<Integer> set = new HashSet<>();
        for(TripleInteger ti : edges) {
            set.add(ti.getSource());
            set.add(ti.getDest());
        }
        return set.size();
    }

    public int noEdges() {
        return edges.size();
    }

    public AdjacencyList converToAL() {
        AdjacencyList al = new AdjacencyList(noVertices());
        for(TripleInteger ti : edges) {
            al.addEdge(ti.getSource(), ti);;
        }
        return al;
    }

    
}
