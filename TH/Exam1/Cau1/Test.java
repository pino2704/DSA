package Cau1;
public class Test {
    public static void main(String[] args) {
        CharLinkedList cll = new CharLinkedList();
        cll.addFrist('a');
        cll.addFrist('b');
        cll.addFrist('c');
        // System.out.println(cll.addFrist('b'));
        // cll.print();
        System.out.println(cll.removeFristVowel());
        cll.print();
    }
}
