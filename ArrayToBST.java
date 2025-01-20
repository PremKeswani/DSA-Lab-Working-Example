class TreeNode {
    int value;
    TreeNode left, right;

    public TreeNode(int value){
        this.value = value;
        this.left = this.right = null;
    }
}
public class ArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums){
        return convertToBST(nums,0 , nums.length-1);
    }

    private TreeNode convertToBST(int[] nums , int start , int end){
        if(start > end){
            return null;
        }
        int mid = start + (end - start)/2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = convertToBST(nums , start , mid -1 );
        root.right = convertToBST(nums , mid +1 , end);

        return root;
    }
    public void InorderTraversal(TreeNode node){
        if(node != null){
            InorderTraversal(node.left);
            System.out.print(node.value + " ");
            InorderTraversal(node.right);
        }
    }

    public static void main(String[] args) {
        ArrayToBST tree = new ArrayToBST();
        int[] sortedArray = {-5,-1, 2, 4, 7, 10};

        TreeNode root = tree.sortedArrayToBST(sortedArray);

        tree.InorderTraversal(root);
    }
}
