import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class AdjacencyMatrix {
    private int[][] adj;
    private final int NUMBER_OF_VERTICES;

    public AdjacencyMatrix(int vertices) {
        NUMBER_OF_VERTICES = vertices;
        adj = new int[NUMBER_OF_VERTICES][NUMBER_OF_VERTICES];
    }

    public void setEgde(int vertexSource, int vertexDestination, int weight) {
        try {
            adj[vertexSource][vertexDestination] = weight;
            adj[vertexDestination][vertexSource] = weight;
        } catch (ArrayIndexOutOfBoundsException indexBounce) {
            System.out.println("The vertex is invalid");
        }
    }

    public int getEgde(int vertexSource, int vertexDestination) {
        try {
            return adj[vertexSource][vertexDestination];
        } catch (ArrayIndexOutOfBoundsException indexBounce) {
            System.out.println("The vertex is invalid");
        }
        return -1;
    }

    public int[][] getAdjacencyMatrix() {
        return adj;
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
        System.out.println(queue);
    }

    public void DFS_recursion(Integer vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for(int i = 0; i < NUMBER_OF_VERTICES; i++) {
            if(adj[vertex][i] != 0 && visited[i] == false) {
                DFS_recursion(i, visited);
            }
        }
    }

    public void DFS_recursion(Integer s) {
        boolean[] visited = new boolean[NUMBER_OF_VERTICES];
        DFS_recursion(s, visited);
    }

    public void DFS(int v) {
        boolean[] visited = new boolean[NUMBER_OF_VERTICES];
        Stack<Integer> stack = new Stack<>();

        stack.push(v);  
        visited[v] = true;

        while(!stack.isEmpty()) {
            int currentVertex = stack.pop();
            System.out.print(currentVertex + " ");
            for(int i = 0; i < NUMBER_OF_VERTICES; i++) {
                if(adj[currentVertex][i] != 0 && visited[i] == false) {
                    stack.push(i);
                    visited[i] = true;
                }
            }
        }
    }

    public AdjacencyMatrix readGraph(String path) {
        AdjacencyMatrix am = null;
        try {
            Scanner reader = new Scanner(new File(path));
            int k = 0;
            am = new AdjacencyMatrix(Integer.parseInt(reader.nextLine()));
            while(reader.hasNextLine()) {
                String[] str = reader.nextLine().split(" ");

                for(int i = 0; i < str.length; i++) {
                    if(Integer.parseInt(str[i]) != 0) {
                        am.setEgde(k, i, Integer.parseInt(str[i]));
                    }
                }
                k++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return am;
    }

    public void enumerateNeighbors(int u, Integer vertexLowest) {
        System.out.print("Neighbors of vertex " + u + ": ");
        for(int i = vertexLowest; i < NUMBER_OF_VERTICES - vertexLowest + 1; i++) {
            if(adj[u][i] != 0)    System.out.print(i + " ");
        }
    } 

    public boolean isLinked(int u, int v, Integer vertexLowest) {
        return adj[u - vertexLowest][v - vertexLowest] == 1;
    }

    //Ex 5c
    public void DFS_stack(int v) {
        boolean[] visited = new boolean[NUMBER_OF_VERTICES];
        Stack <Integer > stack = new Stack<>();
        visited[v] = true;
        stack.push(v);
        while(!stack.isEmpty()) {
            int x = stack.pop();
            System.out.print(x + " ");
        
            for(int i = 0; i < NUMBER_OF_VERTICES; i++){
                if(adj[x][i] != 0 && visited[i] == false){
                    stack.push(i);
                    visited[i] = true;
                }
            }
        }
    }

    //Ex 5d
    public boolean isReachable(int u, int v) {
        boolean[] visited = new boolean[NUMBER_OF_VERTICES];
        return isReachable(u, v, visited);
    }

    private boolean isReachable(int current, int target, boolean[] visited) {
        visited[current] = true;

        if (current == target) {
            return true;
        }

        for (int neighbor = 0; neighbor < NUMBER_OF_VERTICES; neighbor++) {
            if (adj[current][neighbor] != 0 && !visited[neighbor] && isReachable(neighbor, target, visited)) {
                    return true;
            }
        }
        return false;
    }
}