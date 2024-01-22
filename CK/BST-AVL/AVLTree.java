class NodeAVL {

    private int data;
    private NodeAVL left;
    private NodeAVL right;
    private int height;

    public NodeAVL(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.height = 1;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public NodeAVL getLeft() {
        return left;
    }

    public void setLeft(NodeAVL left) {
        this.left = left;
    }

    public NodeAVL getRight() {
        return right;
    }

    public void setRight(NodeAVL right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}

public class AVLTree {

    private NodeAVL root;

    public AVLTree() {
        this.root = null;
    }

    public void insert(int data) {
        this.root = insert(this.root, data);
    }

    private NodeAVL insert(NodeAVL node, int data) {
        if (node == null) {
            return new NodeAVL(data);
        }

        if (data < node.getData()) {
            node.setLeft(insert(node.getLeft(), data));
        } else if (data > node.getData()) {
            node.setRight(insert(node.getRight(), data));
        }

        node.setHeight(Math.max(height(node.getLeft()), height(node.getRight())) + 1);

        // Cập nhật cân bằng cho cây
        int balance = getBalance(node);

        if (balance > 1 && data < node.getLeft().getData()) {
            return rightRotate(node);
        }

        if (balance < -1 && data > node.getRight().getData()) {
            return leftRotate(node);
        }

        if (balance > 1 && data > node.getLeft().getData()) {
            node.setLeft(leftRotate(node.getLeft()));
            return rightRotate(node);
        }

        if (balance < -1 && data < node.getRight().getData()) {
            node.setRight(rightRotate(node.getRight()));
            return leftRotate(node);
        }

        return node;
    }

    public void remove(int data) {
        this.root = remove(this.root, data);
    }

    private NodeAVL remove(NodeAVL node, int data) {
        if (node == null) {
            return null;
        }

        if (data < node.getData()) {
            node.setLeft(remove(node.getLeft(), data));
        } else if (data > node.getData()) {
            node.setRight(remove(node.getRight(), data));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }

            NodeAVL minNode = findMin(node.getRight());
            node.setData(minNode.getData());
            node.setRight(remove(node.getRight(), minNode.getData()));
        }

        node.setHeight(Math.max(height(node.getLeft()), height(node.getRight())) + 1);

        // Cập nhật cân bằng cho cây
        int balance = getBalance(node);

        if (balance > 1 && getBalance(node.getLeft()) >= 0) {
            return rightRotate(node);
        }

        if (balance < -1 && getBalance(node.getRight()) <= 0) {
            return leftRotate(node);
