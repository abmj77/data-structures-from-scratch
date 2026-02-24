package Lab7;

class TNode {

    TNode(){
        data = 0;
        left = null;
        right = null;
    }

    TNode(int bst_data) {
        data = bst_data;
        left = null;
        right = null;
    }

    public int getData() {
        return data;
    }

    public TNode getRight() {
        return right;
    }

    public TNode getLeft() {
        return left;
    }

    public void setRight(TNode bst_node) {
        right = bst_node;
    }

    public void setLeft(TNode bst_node) {
        left = bst_node;
    }
    private int data;
    private TNode right = null, left = null;
}