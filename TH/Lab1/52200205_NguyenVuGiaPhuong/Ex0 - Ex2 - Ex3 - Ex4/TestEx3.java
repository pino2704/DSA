public class TestEx3 {
    public static void main(String[] args) {
        IntegerLinkedList mlst = new IntegerLinkedList(new Node<Integer>(50));
        mlst.addFrist(1);
        mlst.addFrist(74);
        Node<Integer> currentNode = mlst.getHead();
        mlst.addAfter(currentNode, 62);
        mlst.addLast(67);
        mlst.print();

        System.out.println();
        // mlst.reserve();
        // mlst.print();
        // System.out.println();

        mlst.sortAscending();
        mlst.print();
    }
}
