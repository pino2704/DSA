
public class TestMyLinkedList {
    public static void main(String[] args) {
        MyLinkedList<Integer> mlst = new MyLinkedList<>();
        mlst.addFrist(92);
        mlst.addFrist(81);
        mlst.addFrist(54);
        Node<Integer> currentNode = mlst.getHead();
        mlst.addAfter(currentNode, 62);
        mlst.addLast(67);
        mlst.print();

        // System.out.println();

        // mlst.removeFrist();
        // mlst.print();

        // mlst.removeLast();
        // mlst.print();

        // currentNode = mlst.getHead();
        // mlst.removeAfter(currentNode);
        // mlst.print();

        // mlst.removeAfter(null);
        // mlst.print();

        // System.out.println(mlst.isEmpty());
        // mlst.print();
        // System.out.println();
        // System.out.println(mlst.size());

        // System.out.println(mlst.contains(62));

        // System.out.println(mlst.getFrist());

        System.out.println();
        mlst.removeCurr(mlst.getHead());
        mlst.print();
    }
}
