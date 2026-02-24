package Lab7;

public class TestBST_2 {

    public static void main(String[] args) {
        int counter;
        int bst_array[] = {85, 65, 40, 100, 95, 121, 45, 25, 130, 10};
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