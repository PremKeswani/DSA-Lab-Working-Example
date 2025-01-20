class Node {
    int data;
    Node left , right;

    public Node(int data){
        this.data = data;
        left = right = null;
    }
}
public class BinaryTree {
    Node root;

    public int levelOfTree(Node node){     //for calculating the level of the Binary tree
        if(node == null){
            return 0;
        }
        int leftHeight = levelOfTree(node.left);
        int rightHeight = levelOfTree(node.right);
        return 1 + Math.max(leftHeight,rightHeight);
    }

    public boolean isCompleteTree(Node node){
        if(node == null)
            return true;

        int totalNodes = countNodes(node);
        return Helper(node,0,totalNodes);
    }
    private int countNodes(Node node){       //for counting the number of Nodes
        if (node == null)
            return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }
    private boolean Helper(Node node, int index, int totalNodes) {
        if (node == null) return true;

        if (index >= totalNodes) return false;

        return Helper(node.left, 2 * index + 1, totalNodes) &&
                Helper(node.right, 2 * index + 2, totalNodes);
    }


    public boolean isFullTree(Node node) {    // Check if the tree is a full tree
        if (node == null) return true;

        if ((node.left == null && node.right != null) || (node.left != null && node.right == null)) {
            return false;
        }

        return isFullTree(node.left) && isFullTree(node.right);
    }

    // Check if the tree is both complete and full
    public boolean isCompleteAndFull(Node node) {
        return isCompleteTree(node) && isFullTree(node);
    }

    public boolean ChildrenSumProperty(Node node) {   // 3. Check the children sum property in binary tree
        if (node == null || (node.left == null && node.right == null)) {
            return true;
        }

        int leftData = (node.left != null) ? node.left.data : 0;
        int rightData = (node.right != null) ? node.right.data : 0;

        return (node.data == leftData + rightData) &&
                ChildrenSumProperty(node.left) &&
                ChildrenSumProperty(node.right);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(1);
        tree.root.right.right = new Node(1);

        System.out.println("Height of the tree: " + tree.levelOfTree(tree.root));
        System.out.println("tree complete? " + tree.isCompleteTree(tree.root));
        System.out.println("Is the tree full? " + tree.isFullTree(tree.root));
        System.out.println("Is the tree complete and full? " + tree.isCompleteAndFull(tree.root));
        System.out.println("Children sum property? " + tree.ChildrenSumProperty(tree.root));
    }
}
