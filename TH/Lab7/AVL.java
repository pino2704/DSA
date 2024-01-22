import org.w3c.dom.Node;

public class AVL {
    Node root;
    int numNodes;

    public AVL() {
        root = null;
        numNodes = 0;
    }

    public int maxOfLevel(Node x, int level) {
        
    }

    public int sumOneChildNodes(Node x) {
        if(x == null)   return 0;
        if((x.left == null && x.right != null) || (x.left != null && x.right == null) )  return x.key;
        return sumOneChildNodes(x.left) + sumOfChildNodes(x.right);
    }

    public int height(Node x) {
        if(x == null)   return -1;
        return x.height;
    }

    private void updateHeight(Node x) {
        x.height = Math.max(height(x.left), height(x.right)) + 1;
    }

    private int balanceFactor(Node x) {
        if(x == null)    return 0;
        return height(x.left) - height(x.right);
    }

    private boolean checkBalenceFactor(Node x) {
        return Math.abs(balanceFactor(x)) <= 1;
    }

    private Node rightRotation(Node x) {
        Node y = x.left;
        Node z = y.right;
        
        y.right = x;
        x.left = z;

        updateHeight(x);
        updateHeight(y);
        return y;
    }

    private Node leftRotation(Node x) {
        Node y = x.right;
        Node z = y.left;

        y.left = x;
        x.right = z;
        
        updateHeight(x);
        updateHeight(y);
        return y;
    }

    private Node balance(Node x) {
        if(balanceFactor(x) == 2) {
            if(balanceFactor(x.left) == -1) 
                x.left = leftRotation(x.left);
            x = rightRotation(x);
        } else if(balanceFactor(x) == -2) {
            if(balanceFactor(x.right) == 1) 
                x.right = rightRotation(x.right);
            x = leftRotation(x);
        }
        return x;
    }

    private Node insert(Node x, Integer value) {
        if(x == null) {
            return new Node(value);
        } 

        int cmp = value.compareTo(x.key);
        if (cmp > 0) {
            x.right = insert(x.right, value);
        } else if(cmp < 0) {
            x.left = insert(x.left, value);
        } else {
            x.key = value;
        }
        updateHeight(x);
        if(!checkBalenceFactor(x)) {
            x = balance(x);
        }
        return x;
    }

    public void insert(Integer value) {
        if(root == null) {
            root = new Node(value);
            updateHeight(root);
            numNodes++;
        }

        root = insert(root, value);
        numNodes++;
    }

    private Node search(Node x, Integer value) {
        if(x == null)   return null;
        int cmp = x.key.compareTo(value);

        if(cmp > 0) {
            return search(x.left, value);
        } else if(cmp < 0) {
            return search(x.right, value);
        } else {
            return x;
        }
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        x = min(x.left);
        return x;
    }

    public Node min() {
        return min(root);
    }

    private Node max(Node x) {
        if (x.right == null)    return x;
        x = max(x.right);
        return x;
    }

    public Node max() {
        return max(root);
    }

    public boolean search(Integer value) {
        return search(root, value) != null;
    }

    private Node deleteMin(Node x) {
        if(x.left == null)  return x.right;
        x.left = deleteMin(x.left);
        return x;        
    }

    public Node deleteMin() {
        return deleteMin(root);
    }

    private Node deleteSuccessor(Node x, Integer value) {
        int cmp = x.key.compareTo(value);
        if(cmp < 0) {
            x.right = deleteSuccessor(x.right, value);
        } else if (cmp > 0) {
            x.left = deleteSuccessor(x.left, value);
        } else {
            if(x.left == null) {
                return x.right;
            } 
            if(x.right == null) {
                return x.left;
            }
            x.key = min(x.right).key;
            x.right = deleteMin(x.right);  
        }
        return x;
    }

    public boolean deleteSuccessor(Integer value) {
        if (search(value) && root != null) {
            numNodes--;
            deleteSuccessor(root, value);
            return true;
        }
        return false;
    }

 
    private Node deleteMax(Node x) {
        if(x.right == null) return x;
        x = deleteMax(x.right);
        return x;
    }

    public void deleteMax() {
        deleteMax(root);
    }

    private Node deletePredecessor(Node x, Integer value) {
        int cmp = value.compareTo(x.key);
        if(cmp > 0) {
            deletePredecessor(x.right, value);
        } else if (cmp < 0) {
            deletePredecessor(x.left, value);
        } else {
            if (x.left == null) return x.right;
            if (x.right == null)    return x.left;
            x.key = max(x.left).key;
            x.left = deleteMax(x.left);
        }
        return x;
    }

    public boolean contains(Integer key) {
        if(search(key)) return true;
        return false;
    }

    public boolean deletePredecessor(Integer value) {
        if(contains(value)) {
            deletePredecessor(root, value);
            return true;
        }
        return false;
    }
    private void NLR(Node x) {
        if(x != null) {
            System.out.print(x.key + " ");
            NLR(x.left);
            NLR(x.right);
        }
    }

    public void NLR() {
        NLR(root);
    }

    private void LNR(Node x) {
        if(x != null) {
            LNR(x.left);
            System.out.print(x.key + " ");
            LNR(x.right);
        }
    }

    public void LNR() {
        LNR(root);
    }

}