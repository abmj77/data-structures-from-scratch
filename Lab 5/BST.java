package Lab7;

class BST {

    public BST() {
        root = null;
    }

    public boolean empty() {
        return (root == null);
    }

    public int getRoot() {
        return root.getData();
    }

    public void insert(int data) {
        TNode Node = new TNode(data);
        if (empty()) {
            root = Node;
            return;
        }
        TNode temp = root, parent = root;
        int direction = 0;
        while (temp != null) {
            parent = temp;
            if (data > temp.getData()) {
                temp = temp.getRight();
                direction = 1;
            } else {
                temp = temp.getLeft();
                direction = 0;
            }
        }
        if (direction == 0) {
            parent.setLeft(Node);
        } else {
            parent.setRight(Node);
        }
    }

    void visit(TNode bst_node) {
        System.out.print(" " + bst_node.getData() + " ");
    }

    void inorder(TNode bst_root)
    {
        if (bst_root != null) {
            inorder(bst_root.getLeft());
            visit(bst_root); // V
            inorder(bst_root.getRight());
        }
    }

    void preorder(TNode bst_root) {
        if (bst_root != null) {
            visit(bst_root);
            preorder(bst_root.getLeft());
            preorder(bst_root.getRight());
        }
    }

    void postorder(TNode bst_root) {
        if (bst_root != null) {
            postorder(bst_root.getLeft());
            postorder(bst_root.getRight());
            visit(bst_root);
        }
    }
    public TNode root = null;
}