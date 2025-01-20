
public class BinarySearchTree {

   static class Node{
        int key;
        Node left,right;

        Node(int item){
            this.key = item;
        }
    }
    Node root;

    BinarySearchTree(int key){
        root = new Node(key);
    }
    BinarySearchTree(){
        root = null;
    }

    void printPostorder(Node node) {
        if (node == null) return;

        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.key + " ");

    }
    void printInorder(Node node){
        if(node == null)  return;

        printInorder(node.left);
        System.out.print(node.key+ " ");
        printInorder(node.right);

    }
    void printPreorder(Node node){
        if(node == null)  return;

        System.out.print(node.key + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }
    public Node search(Node root , int key){

        if(root == null || root.key == key)  return root;
        if(root.key > key) return search(root.left , key);

        return search(root.right , key);
    }

    Node insertRec(Node root , int key){
        if(root == null){
            root = new Node(key);
            return root;
        }
        else{
            if(key < root.key) root.left = insertRec(root.left, key);

            else if (key > root.key) root.right = insertRec(root.right , key);
            }
        return root;
    }

    Node deleteRec(Node root , int key){

        if(root == null) return root;

        if(key < root.key) root.left = deleteRec(root.left , key);
        else if (key > root.key) root.right = deleteRec(root.right , key);

        else {
            if(root.left == null) return root.right;
            else if(root.right == null) return root.left;
            root.key = minValue(root.right);
            root.right = deleteRec(root.right , root.key);

        }
        return root;
    }
    int minValue(Node root){
        int minv = root.key;

        while(root.left != null){
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }
    void printTree(){
        System.out.println("Inorder Traversal:");
        printInorder(root);
        System.out.println();

        System.out.println("Preorder Traversal:");
        printPreorder(root);
        System.out.println();

        System.out.println("Postorder Traversal:");
        printPostorder(root);
        System.out.println();
    }
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        // Insert some values
        tree.root = tree.insertRec(tree.root, 50);
        tree.root = tree.insertRec(tree.root, 30);
        tree.root = tree.insertRec(tree.root, 20);
        tree.root = tree.insertRec(tree.root, 40);
        tree.root = tree.insertRec(tree.root, 70);
        tree.root = tree.insertRec(tree.root, 60);
        tree.root = tree.insertRec(tree.root, 80);

        // Print the tree
        tree.printTree();

        // Search for a key
        int searchKey = 40;
        Node result = tree.search(tree.root, searchKey);
        if (result != null) {
            System.out.println("Node " + searchKey + " found.");
        } else {
            System.out.println("Node " + searchKey + " not found.");
        }

        // Delete a key and print the tree again
        tree.root = tree.deleteRec(tree.root, 20);
        System.out.println("Tree after deleting 20:");
        tree.printTree();

        // Delete a key and print the tree again
        tree.root = tree.deleteRec(tree.root, 30);
        System.out.println("Tree after deleting 30:");
        tree.printTree();

        // Delete a key and print the tree again
        tree.root = tree.deleteRec(tree.root, 50);
        System.out.println("Tree after deleting 50:");
        tree.printTree();
    }
}
