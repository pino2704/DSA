public class Test {
    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(8);
        bst.insert(4);
        bst.insert(3);
        
        System.out.println(bst.delMin().data);
        bst.NLR();
    }
}
