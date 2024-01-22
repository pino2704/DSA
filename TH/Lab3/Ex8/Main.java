public class Main {
    public static void main(String[] args) {
        SortedLinkedList sll = new SortedLinkedList();
        sll.add(4);
        sll.add(1);
        sll.add(7);
        sll.add(5);
        sll.add(2);
        sll.print();

        System.out.println();

        sll.remove(2);
        sll.print();
    }
}
