public class Test {
    public static void main(String[] args) {
        FractionLinkedList flst = new FractionLinkedList();
        flst.addFrist(new Fraction(1, 3));
        NodeFraction tmp = flst.getHead();
        flst.addAfter(tmp, new Fraction(2, 6));
        flst.addLast(new Fraction(3, 8));
        flst.print();
        
        System.out.println(flst.getHead().getData().equals(flst.getHead().getNext().getData()));
    }
}
