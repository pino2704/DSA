import java.io.File;
import java.util.Scanner;

public class Main {
    public static EdgeList readGraph(String path) {
        EdgeList el = new EdgeList();
        
        try {
            Scanner reader = new Scanner(new File(path));
            
            while(reader.hasNextLine()) {
                String[] str = reader.nextLine().split(" ");
                el.addEdge(new TripleInteger(1, Integer.parseInt(str[0]), Integer.parseInt(str[1])));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return el;
    }

    public static void main(String[] args) {
        EdgeList el = readGraph("facebook_combined.txt");
        
    }
}
