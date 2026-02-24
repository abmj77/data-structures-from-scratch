package Lab7;

class TestBST {

    public static void main(String[] args) {
        int counter;
        int bst_array[] = {60, 30, 20, 80, 15, 70, 90, 10, 25, 33};
        BST bst_test = new BST();
        for (counter = 0; counter < 10; counter++) {
            System.out.print(" Insert " + bst_array[counter] + " to binary search tree \n");   
            bst_test.insert(bst_array[counter]);
        }
        System.out.println("\nTransition  To Preorder:");
        bst_test.preorder(bst_test.root);
        System.out.println("\nTransition  To Inorder:");
        bst_test.inorder(bst_test.root);
        System.out.println("\nTransition To Postorder:");
        bst_test.postorder(bst_test.root);
    }
}