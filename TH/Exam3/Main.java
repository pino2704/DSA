import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static EdgeList readGraph(String path, ArrayList<Visitor> visitors, ArrayList<Destination> destinations) {
        EdgeList edgeList = new EdgeList();
        try {
            File obj = new File(path);
            Scanner reader = new Scanner(obj);
            while (reader.hasNextLine()) {
                String[] data = reader.nextLine().split(" ");
                Visitor v = new Visitor(0, "", "");
                for (Visitor i : visitors) {
                    if (i.getId() == Integer.parseInt(data[0])) {
                        v = i;
                        break;
                    }
                }

                Destination d = new Destination(0, "");
                for (Destination i : destinations) {
                    if (i.getId() == Integer.parseInt(data[1])) {
                        d = i;
                        break;
                    }
                }

                edgeList.addEdge(new Edge(v, d, Integer.parseInt(data[2])));
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println(path + " is not found");
        }
        return edgeList;
    }

    public static ArrayList<Visitor> readVisitor(String path) {
        ArrayList<Visitor> visitors = new ArrayList<Visitor>();
        try {
            File obj = new File(path);
            Scanner reader = new Scanner(obj);
            while (reader.hasNextLine()) {
                String[] data = reader.nextLine().split(",");
                visitors.add(new Visitor(Integer.parseInt(data[0]), data[1], data[2]));
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println(path + " is not found");
        }
        return visitors;
    }

    public static ArrayList<Destination> readDestination(String path) {
        ArrayList<Destination> destinations = new ArrayList<Destination>();
        try {
            File obj = new File(path);
            Scanner reader = new Scanner(obj);
            while (reader.hasNextLine()) {
                String[] data = reader.nextLine().split(",");
                destinations.add(new Destination(Integer.parseInt(data[0]), data[1]));
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println(path + " is not found");
        }
        return destinations;
    }

    public static void main(String[] args) {
        String path = "./graph.txt";
        String visitorPath = "./visitors.txt";
        String destinationPath = "./destinations.txt";
        ArrayList<Visitor> visitors = readVisitor(visitorPath);
        ArrayList<Destination> destination = readDestination(destinationPath);
        EdgeList edgeList = readGraph(path, visitors, destination);
        // Cau 1
        System.out.println("Cau 1: ");
        int n = edgeList.findNumberVisitors();
        System.out.println(n);
        // // Cau 2
        System.out.println("Cau 2: ");
        ArrayList<String> data = edgeList.getDestinationsByVisitorRating(2, 3);
        String data1 = String.join(",", data);
        System.out.println(data1);
        // // Cau 3
        System.out.println("Cau 3: ");
        System.out.println(edgeList.getAverageRating("Nha Trang"));
        // // Cau 4
        System.out.println("Cau 4: ");
        String data2 = String.join(",", edgeList.findDestinationsHasFemaleRating());
        System.out.println(data2);
        // // Cau 5
        System.out.println("Cau 5: ");
        String data3 = String.join(",", edgeList.findEvenRatingVisitors(visitors));
        System.out.println(data3);
    }
}
