
public class BST {
    Node root;
    
    public BST() {
        root = null;
    }

    public int countLeaves(Node x) {
        if(x == null)   return 0;
        if(x.right == null & x.left == null)    return 1;
        return countLeaves(x.left) + countLeaves(x.right);
    }

    public void countLeaves() {
        countLeaves(root);
    }

    public int sizeOf(Node x) {
        if(x == null)   return 0;
        return sizeOf(x.left) + 1 + sizeOf(x.right);
    }

    public int sumOfRange(Node x, int a, int b) {
        if(x == null)   return 0;
        if(x.key < a)   return sumOfRange(x.right, a, b);
        if(x.key > b)   return sumOfRange(x.left, a, b);
        return x.key + sumOfRange(x.left, a, b) + sumOfRange(x.right, a, b);
    }  

    public int count1ChildNodes(Node x) {
        if(x == null)   return 0;
        if((x.left == null && x.right != null) || (x.left != null && x.right == null))   return 1;
        return count1ChildNodes(x.left) + count1ChildNodes(x.right);
    }
}   
