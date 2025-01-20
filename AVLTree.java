// Java program to perform deletion in an AVL tree

class TreeNode {
    int value;
    TreeNode left, right;
    int height;

    TreeNode(int value) {
        this.value = value;
        this.left = this.right = null;
        this.height = 1;
    }
}

public class AVLTree {

    // Get the height of the node
    int height(TreeNode node) {
        if (node == null) return 0;
        return node.height;
    }

    // Get the balance factor of the node
    int getBalance(TreeNode node) {
        if (node == null) return 0;
        return height(node.left) - height(node.right);
    }

    // Right rotate
    TreeNode rightRotate(TreeNode y) {
        TreeNode x = y.left;
        TreeNode T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    // Left rotate
    TreeNode leftRotate(TreeNode x) {
        TreeNode y = x.right;
        TreeNode T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // Insert a node
    TreeNode insert(TreeNode node, int value) {
        if (node == null) return new TreeNode(value);

        if (value < node.value)
            node.left = insert(node.left, value);
        else if (value > node.value)
            node.right = insert(node.right, value);
        else
            return node; // Duplicates are not allowed

        // Update height of this node
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Get the balance factor
        int balance = getBalance(node);

        // Left Left Case
        if (balance > 1 && value < node.left.value)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && value > node.right.value)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && value > node.left.value) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && value < node.right.value) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // Find the node with minimum value
    TreeNode minValueNode(TreeNode node) {
        TreeNode current = node;
        while (current.left != null)
            current = current.left;
        return current;
    }

    // Delete a node
    TreeNode deleteNode(TreeNode root, int value) {
        if (root == null) return root;

        if (value < root.value)
            root.left = deleteNode(root.left, value);
        else if (value > root.value)
            root.right = deleteNode(root.right, value);
        else {
            if ((root.left == null) || (root.right == null)) {
                TreeNode temp = (root.left != null) ? root.left : root.right;

                if (temp == null) {
                    root = null;
                } else {
                    root = temp;
                }
            } else {
                TreeNode temp = minValueNode(root.right);
                root.value = temp.value;
                root.right = deleteNode(root.right, temp.value);
            }
        }

        if (root == null) return root;

        root.height = Math.max(height(root.left), height(root.right)) + 1;

        int balance = getBalance(root);

        // Left Left Case
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);

        // Left Right Case
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Right Case
        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        // Right Left Case
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    // In-order traversal
    void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.value + " ");
            inOrder(root.right);
        }
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        TreeNode root = null;

        root = tree.insert(root, 10);
        root = tree.insert(root, 20);
        root = tree.insert(root, 30);
        root = tree.insert(root, 40);
        root = tree.insert(root, 50);
        root = tree.insert(root, 25);

        System.out.println("In-order traversal of the AVL tree:");
        tree.inOrder(root);

        root = tree.deleteNode(root, 40);

        System.out.println("\nIn-order traversal after deletion:");
        tree.inOrder(root);
    }
}
