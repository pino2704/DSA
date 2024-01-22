public class Test {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree(new Node(8));

        bst.insert(3);
        bst.insert(4);
        bst.insert(7);
        bst.insert(6);
        bst.insert(15);
        bst.insert(9);
        bst.insert(16);
        bst.insert(1);

        bst.LNR();
        System.out.println();

        // System.out.println(bst.deleteSuccessor(7));

        // System.out.println(bst.sumEvenKeysAtLeaves());

        bst.bfs();

    }
}
