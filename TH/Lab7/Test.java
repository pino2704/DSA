public class Test {
    public static void main(String[] args) {
        AVL bst = new AVL();
        bst.insert(20);
        bst.insert(13);
        bst.insert(15);
        bst.insert(18);
        bst.insert(10);
        bst.insert(7);
        bst.insert(5);
        bst.insert(6);
        bst.insert(16);
        bst.insert(9);
        // bst.deleteSuccessor(18);
        // bst.deleteSuccessor(15);

        bst.NLR();
        // System.out.println();

        // System.out.println(bst.deleteSuccessor(7));

        // System.out.println(bst.sumEvenKeysAtLeaves());

        // bst.bfs();

    }
}
