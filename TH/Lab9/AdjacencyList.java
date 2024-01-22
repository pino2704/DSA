import java.util.*;
import java.io.File;
public class AdjacencyList {
    private int V;
    private ArrayList<LinkedList<Integer>> adj;

    public AdjacencyList(int v) {
        V = v;
        adj = new ArrayList<LinkedList<Integer>>();
        for (int i = 0; i < v; ++i) 
            adj.add(new LinkedList<Integer>());
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    public void printGraph() {
        for(int i = 0; i < V; i++) {  
            System.out.print("Vertex " + i + ": ");
            System.out.print("head");
            for(Integer v: adj.get(i)) {
                System.out.print("-> " + v);
            }
            System.out.println();
        }
    }

    public AdjacencyList readGraph(String path) {
        AdjacencyList al = null;
        try {
            Scanner reader = new Scanner(new File(path));
            al = new AdjacencyList(Integer.parseInt(reader.nextLine()));

            while(reader.hasNextLine()) {
                String[] str = reader.nextLine().split(" ");

                for(int i = 1; i < str.length; i++) {
                    al.addEdge(Integer.parseInt(str[0]), Integer.parseInt(str[i]));
                }
            }

        } catch (Exception e) {
        }
        return al;
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

    public LinkedList<Integer> enumerateNeighbors(int u) {
        return adj.get(u);
    }

    public boolean isLinked(int u, int v) {
        return adj.get(u).contains(v);
    }

    public static void main(String[] args) {
        AdjacencyList temp = new AdjacencyList(0);
        AdjacencyList al = temp.readGraph("list.txt");

        //Ex 2a
        al.printGraph();

        //Ex 2b
        System.out.println(al.countVertices());

        //Ex 2c
        System.out.println(al.countEdges());

        //Ex 2d
        System.out.println(al.enumerateNeighbors(0));
        //Ex 2e
        System.out.println(al.isLinked(0, 3)); 
    }
}
