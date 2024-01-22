
public class Test {
    public static void main(String[] args) {
        IntLinkedList ill = new IntLinkedList();
        ill.addFirst(3);
        ill.addFirst(2);
        ill.addFirst(1);
        ill.addLast(9);
        ill.print();
        System.out.println(ill.checkSorted());
    
    }
}
