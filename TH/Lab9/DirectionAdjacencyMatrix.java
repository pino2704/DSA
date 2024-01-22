import java.util.LinkedList;
import java.util.Queue;
public class DirectionAdjacencyMatrix {
    private int[][] adj;
    private final int NUMBER_OF_VERTICES;

    public DirectionAdjacencyMatrix(int vertices) {
        NUMBER_OF_VERTICES = vertices;
        adj = new int[NUMBER_OF_VERTICES][NUMBER_OF_VERTICES];
    }

    public void setEgde(Integer vertexSource, Integer vertexDestination, Integer weight) {
        try {
            adj[vertexSource][vertexDestination] = weight;
            adj[vertexDestination][vertexSource] = 0;
        } catch (ArrayIndexOutOfBoundsException indexBounce) {
            System.out.println("The vertex is invalid");
        }
    }

    public Integer getEgde(Integer vertexSource, Integer vertexDestination) {
        try {
            return adj[vertexSource][vertexDestination];
        } catch (ArrayIndexOutOfBoundsException indexBounce) {
            System.out.println("The vertex is invalid");
        }
        return -1;
    }

    public void printGraph() {
        for(int i = 0; i < NUMBER_OF_VERTICES; i++) {
            for(int j = 0; j < NUMBER_OF_VERTICES; j++) {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void BFS(int s) {
        boolean visited[] = new boolean[NUMBER_OF_VERTICES];

        Queue<Integer> queue = new LinkedList<Integer>();

        visited[s] = true;
        queue.add(s);

        while(!queue.isEmpty()) {
            Integer x = queue.poll();
            System.out.print(x + " ");

            for(int i = 0; i < NUMBER_OF_VERTICES; i++) {
                if(adj[x][i] != 0 && visited[i] == false) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public void DFS(Integer vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for(int i = 0; i < NUMBER_OF_VERTICES; i++) {
            if(adj[vertex][i] != 0 && visited[i] == false) {
                DFS(i, visited);
            }
        }
    }

    public void DFS(Integer s) {
        boolean[] visited = new boolean[NUMBER_OF_VERTICES];
        DFS(s, visited);
    }

    public static void main(String[] args) {
        DirectionAdjacencyMatrix dam = new DirectionAdjacencyMatrix(6);

        dam.setEgde(0, 1, 2);
        dam.setEgde(0, 3, 5);
        dam.setEgde(0, 5, 4);
        dam.setEgde(1, 3, 5);
        dam.setEgde(1, 4, 2);
        dam.setEgde(2, 5, 6);
        dam.setEgde(3, 4, 3);
        dam.setEgde(3, 5, 4);
        dam.setEgde(4, 2, 1);
        dam.setEgde(5, 4, 1);

        // dam.printGraph();

        dam.DFS(0);
    }
}
