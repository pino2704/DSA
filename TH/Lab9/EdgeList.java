import java.util.Vector;
import java.util.Scanner;
import java.io.File;

public class EdgeList {
    private Vector<IntegerTriple> edges;

    public EdgeList() {
        edges = new Vector<IntegerTriple>();
    }

    public void addEdge(int w, int u, int v) {
        edges.add(new IntegerTriple(w, u, v));
    }

    public void printGraph() {
        for(int i = 0; i < edges.size(); i++) {
            System.out.println(edges.get(i));
        }
    }

    public EdgeList readGraph(String path) {
        EdgeList el = new EdgeList();
        try {
            Scanner reader = new Scanner(new File(path));
            while(reader.hasNextLine()) {
                String[] str = reader.nextLine().split(" ");
                el.addEdge(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]));
            }    
        } catch (Exception e) {
        }
        return el;
    }

    public int countVertices() {
        Vector<Integer> vertices = new Vector<>();
        for(int i = 0; i < edges.size(); i++) {
            if(!vertices.contains(edges.get(i).getSource())) {
                vertices.add(edges.get(i).getSource());
            }
            if(!vertices.contains(edges.get(i).getDest())) {
                vertices.add(edges.get(i).getDest());
            }
        }
        return vertices.size();
    }

    public int countEdges() {
        return edges.size();
    }

    public Vector<Integer> enumerateNeighbors(int u) {
        Vector<Integer> listNeighbors = new Vector<>();
        
        for(int i = 0; i < edges.size(); i++) {
            if(edges.get(i).getSource() == u && !listNeighbors.contains(edges.get(i).getDest())) {
                listNeighbors.add(edges.get(i).getDest());
            }
        }
        return listNeighbors;
    }

    public boolean isLinked(int u, int v) {
        for(int i = 0; i < edges.size(); i++) {
            if((edges.get(i).getSource() == u && edges.get(i).getDest() == v) || (edges.get(i).getSource() == v && edges.get(i).getDest() == u)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        EdgeList tmp = new EdgeList();
        EdgeList el = tmp.readGraph("edge.txt");

        //Ex 3a
        el.printGraph();

        //Ex 3b
        System.out.println(el.countVertices());

        //Ex 3c
        System.out.println(el.countEdges());

        //Ex 3d
        System.out.println(el.enumerateNeighbors(0));

        //Ex 3e
        System.out.println(el.isLinked(2, 4));
    }
}
