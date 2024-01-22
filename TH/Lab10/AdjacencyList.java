import java.util.*;

public class AdjacencyList {
    private int V;
    private ArrayList<LinkedList<TripleInteger>> adj;

    public AdjacencyList(int v) {
        V = v;
        adj = new ArrayList<LinkedList<TripleInteger>>();
        for (int i = 0; i < v; ++i) 
            adj.add(new LinkedList<TripleInteger>());
    }

    public void addEdge(int u, TripleInteger v) {
        adj.get(u).add(v);
    }

    public void printGraph() {
        for(int i = 0; i < V; i++) {  
            System.out.print("Vertex " + i + ": ");
            System.out.print("head");
            for(TripleInteger v: adj.get(i)) {
                System.out.print("-> " + v);
            }
            System.out.println();
        }
    }

    public int countVertices() {
        return adj.size();
    }

    public int countEdges() {
        int count = 0;
        for(int i = 0; i < adj.size(); i++) {
            count += adj.get(i).size();
        }
        return count/2;
    }

    public LinkedList<TripleInteger> enumerateNeighbors(int u) {
        return adj.get(u);
    }

    public boolean isLinked(int u, TripleInteger v) {
        return adj.get(u).contains(v);
    }

}
