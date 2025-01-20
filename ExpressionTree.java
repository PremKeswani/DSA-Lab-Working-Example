
public class ExpressionTree {

   static class TreeNode {
        char value;
        TreeNode left , right;

        TreeNode(char value){
            this.value = value;
            this.left = this.right = null;
        }
    }
    public TreeNode Expression(){
        //Expression ((5+2)*(2-1))/(2+9)
        TreeNode nodePlus1 = new TreeNode('+');
        nodePlus1.left = new TreeNode('5');
        nodePlus1.right = new TreeNode('2');

        TreeNode nodeMinus = new TreeNode('-');
        nodeMinus.left = new TreeNode('2');
        nodeMinus.right = new TreeNode('1');

        TreeNode multiply = new TreeNode('*');
        multiply.left = nodePlus1;
        multiply.right = nodeMinus;

        TreeNode nodePlus2 = new TreeNode('+');
        nodePlus2.left = new TreeNode('2');
        nodePlus2.right = new TreeNode('9');

        TreeNode divide = new TreeNode('/');
        divide.left = multiply;
        divide.right = nodePlus2;

        return divide;
    }

    public void InorderTraversal(TreeNode node){
        if(node != null){
            InorderTraversal(node.left);
            System.out.print(node.value+ " ");
            InorderTraversal(node.right);
        }
    }
    public void preOrderTraversal(TreeNode node){
        if(node != null){
            System.out.print(node.value+ " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }
    public void postOrderTraversal(TreeNode node){
       if(node != null){
           postOrderTraversal(node.left);
           postOrderTraversal(node.right);
           System.out.print(node.value+ " ");
       }
    }
    public void printTraversal(String TraversalType , TreeNode node){
        System.out.println(TraversalType + "Traversal");

        switch (TraversalType){
            case "Inorder" :
                InorderTraversal(node);
                break;

            case "preOrder" :
                preOrderTraversal(node);
                break;

            case "postOrder" :
                postOrderTraversal(node);
                break;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ExpressionTree tree = new ExpressionTree();
        TreeNode root = tree.Expression();

        tree.printTraversal("Inorder" , root);
        tree.printTraversal("preOrder" , root);
        tree.printTraversal("postOrder" , root);

    }
}
