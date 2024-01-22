public class BST {
    Node root;
    int numNodes;

    public BST() {
        root = null;
        numNodes = 0;
    }

    private Node insert(Node x, Integer data) {
        if(x == null)   return new Node(data);

        int cmp = data.compareTo(x.data);
        if(cmp > 0) {
            x.right = insert(x.right, data);
        } else if(cmp < 0) {
            x.left = insert(x.left, data);
        } else {
            x.data = data;
        }
        return x;
    }

    public void insert(Integer data) {
        root = insert(root, data);
        numNodes++;
    }

    //pre-order
    private void NLR(Node x) {
        if(x != null) {
            System.out.print(x.data + " ");
            NLR(x.left);
            NLR(x.right);
        }
    }
    public void NLR() {
        NLR(root);
    }

    //in-order
    private void LNR(Node x) {
        if (x != null) {
            LNR(x.left);
            System.out.print(x.data + " ");
            LNR(x.right);
        }
    }
    public void LNR() {
        LNR(root);
    }

    //post-order
    private void LRN(Node x) {
        if (x != null) {
            LRN(x.left);
            LRN(x.right);
            System.out.print(x.data + " ");
        }

    }
    public void LRN() {
        LRN(root);
    }

    private Node search(Node x, Integer key) {
        if(x == null)   return null;

        int cmp = key.compareTo(x.data);
        if(cmp > 0) x = search(x.right, key);
        else if(cmp < 0) x = search(x.left, key);
        return x;
    }
    public boolean search(Integer key) {
        return search(root, key) != null;
    }

    private Node min(Node x) {
        if(x.left == null)  return x;
        return min(x.left);
    }
    public Integer min() {
        return min(root).data;
    }

    private Node max(Node x) {
        if(x.right == null) return x;
        return max(x.right);
    }
    public Integer max() {
        return max(root).data;
    }

    private Node delMin(Node x) {
        if(x.left == null)  return x.right;
        x.left = delMin(x.left);
        return x;
    }
    public Node delMin() {
        return delMin(root);
    }

    private Node delMax(Node x) {
        if(x.right == null)     return x.left;

        x.right = delMax(x.right);
        return x;
    }
    public Node delMax() {
        return delMax(root);
    }

    private Node deleteSuccessor(Node x, Integer data) {
        if(x == null)   return null;
        int cmp = data.compareTo(x.data);
        if(cmp > 0) x = deleteSuccessor(x.right, data);
        else if(cmp < 0) x = deleteSuccessor(x.left, data);
        else {
            if(x.right == null) return x.left;
            if (x.left == null) return x.right;

            x.data = min(x.right).data;
            x.right = delMin(x.right);
            
        }
        return x;
    }
    private Node deletePredecessor(Node x, Integer data) {
        if(x == null)   return null;
        int cmp = data.compareTo(x.data);
        if(cmp > 0) return x = deletePredecessor(x.right, data);
        if(cmp < 0) return x = deletePredecessor(x.left, data);
        else {
            if(x.left == null)  return x.right;
            if(x.right == null) return x.left;
            
            x.data = max(x.left).data;
            x.left = delMax(x.left);
        }
        return x;
    }


}
