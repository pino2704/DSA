public class BinarySearchTree {
    Node root;
    int numNodes;

    public BinarySearchTree(Node x) {
        root = x;
        numNodes = 1;
    }

    private Node insert(Node x, Integer value) {
        if(x == null)   return new Node(value);

        int cmp = x.key.compareTo(value);
        if(cmp < 0)   x.right = insert(x.right, value);
        else if (cmp > 0) x.left = insert(x.left, value);
        else x.key = value;
        return x;
    }

    public void insert(Integer value) {
        insert(root, value);
        numNodes++;
    }

    private void NLR(Node x) {
        if(x != null) {
            System.out.print(x.key + " ");
            NLR(x.right);
            NLR(x.left);
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

    private void LRN(Node x) {
        if (x != null) {
            LRN(x.left);
            LRN(x.right);
            System.out.print(x.key + " ");
        }
    }

    public void LRN() {
        LRN(root);
    }

    private void RNL(Node x) {
        if(x != null) {
            RNL(x.right);
            System.out.print(x.key + " ");
            RNL(x.left);
        }
    }

    public void RNL() {
        RNL(root);
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

    public boolean deletePredecessor(Integer value) {
        if(contains(value)) {
            deletePredecessor(root, value);
            return true;
        }
        return false;
    }
    public BinarySearchTree createTree(String strKey) {
        String[] strArr = strKey.split(" ");
        BinarySearchTree bst = new BinarySearchTree(new Node(Integer.parseInt(strArr[0])));
        for(int i = 1; i < strArr.length; i++) {
            bst.insert(Integer.parseInt(strArr[i]));
        }
        return bst;
    }

    public boolean contains(Integer key) {
        if(search(key)) return true;
        return false;
    }
   
    private int height(Node x) {
        if(x == null)   return -1;
        int left = height(x.left);
        int right = height(x.right);
        return Math.max(left, right) + 1;
    }

    public int height() {
        return height(root);
    }

    private Integer sum(Node x) {
        if(x == null)   return 0;
        return sum(x.right) + sum(x.left) + x.key;
    }

    public Integer sum() {
        return sum(root);
    }

    private Integer sumEven(Node x) {
        if(x == null)   return 0;
        Integer value = x.key % 2 == 0 ? x.key : 0;
        return sumEven(x.right) + sumEven(x.left) + value; 
    }

    public Integer sumEven() {
        return sumEven(root);
    }

    private int countLeaves(Node x) {
        if(x == null)   return 0;
        if(x.right == null && x.left == null)   return 1;
        return countLeaves(x.right) + countLeaves(x.left);
    }

    public int countLeaves() {
        return countLeaves(root);
    }

    private int sumEvenKeysAtLeaves(Node x) {
        if(x == null)   return 0;
        if(x.right == null && x.left == null && x.key % 2 == 0) return x.key;
        return sumEvenKeysAtLeaves(x.right) + sumEvenKeysAtLeaves(x.left);
    }

    public int sumEvenKeysAtLeaves() {
        return sumEvenKeysAtLeaves(root);
    }

    private void bfs(Node x) {
        if(x.left != null)  System.out.println(x.left.key);
        if(x.right != null) System.out.println(x.right.key);
        if(x.right != null) bfs(x.right);
        if(x.left != null)  bfs(x.left);
    }

    public void bfs() {
        System.out.println(root.key);
        bfs(root);
    }
}
