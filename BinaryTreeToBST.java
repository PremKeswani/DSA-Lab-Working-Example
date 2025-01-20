import java.util.ArrayList;
import java.util.Collections;

public class BinaryTreeToBST {
   static class TreeNode {
        int value;
        TreeNode left, right;

        TreeNode(int value) {
            this.value = value;
            this.left = this.right = null;
        }
    }

    // Method to convert a binary tree to a binary search tree
    public void convertToBST(TreeNode root) {
        // Step 1: Store in-order traversal of the binary tree in a list
        ArrayList<Integer> values = new ArrayList<>();
        storeInOrder(root, values);

        // Step 2: Sort the list
        Collections.sort(values);

        // Step 3: Rebuild the tree with sorted values
        index = 0;  // Reset index for in-order replacement
        buildBST(root, values);
    }

    // Helper method to perform in-order traversal and store values
    private void storeInOrder(TreeNode node, ArrayList<Integer> values) {
        if (node == null) return;
        storeInOrder(node.left, values);
        values.add(node.value);
        storeInOrder(node.right, values);
    }

    // Helper method to rebuild the tree with sorted values
    private void buildBST(TreeNode node, ArrayList<Integer> values) {
        if (node == null) return;
        buildBST(node.left, values);
        node.value = values.get(index++);
        buildBST(node.right, values);
    }

    // Static index variable for rebuilding the tree
    private int index;

    // In-order traversal to print the tree
    public void inOrderTraversal(TreeNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.value + " ");
            inOrderTraversal(node.right);
        }
    }

    public static void main(String[] args) {
        // Sample binary tree
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(4);

        BinaryTreeToBST tree = new BinaryTreeToBST();
        System.out.println("In-order traversal of original binary tree:");
        tree.inOrderTraversal(root);

        tree.convertToBST(root);

        System.out.println("\nIn-order traversal of converted BST:");
        tree.inOrderTraversal(root);
    }
}
