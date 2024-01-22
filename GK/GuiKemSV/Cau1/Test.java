public class Test {
    public static void main(String[] args) {
        CharLinkedList cll = new CharLinkedList();
        cll.addFirst('c');
        cll.addFirst('b');
        cll.addFirst('A');
        cll.print();

        // cll.addAfterFirstKey('E', 'b');
        // cll.print();
        System.out.println(cll.largestCharPostition());
    }
}
