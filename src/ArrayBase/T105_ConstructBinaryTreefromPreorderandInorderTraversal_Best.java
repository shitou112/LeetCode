package ArrayBase;

/**
 * @author Qian Shaofeng
 * created on 2017/12/12.
 */
public class T105_ConstructBinaryTreefromPreorderandInorderTraversal_Best {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int[] preIndex = new int[] {0};
        int[] inIndex = new int[] {0};
        return buildTree(preorder, inorder, preIndex, inIndex, Integer.MAX_VALUE);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int[] preIndex, int[] inIndex, int target) {
        //pre: [root][left][right];
        //in: [left][root][right];
        //target is the root
        if (inIndex[0] >= inorder.length || inorder[inIndex[0]] == target) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex[0]]);
        //preorder, advance the index by 1 sice we already finish the root;
        preIndex[0]++;
        root.left = buildTree(preorder, inorder, preIndex, inIndex, root.val);
        //after finishing left subtree, we can advance the index by 1
        inIndex[0]++;
        root.right = buildTree(preorder, inorder, preIndex, inIndex, target);
        return root;
    }

    public static void main(String[] args) {
        T105_ConstructBinaryTreefromPreorderandInorderTraversal_Best cbtpitb = new T105_ConstructBinaryTreefromPreorderandInorderTraversal_Best();
        int[] preorder = {1, 2, 3, 4, 5, 6, 7};
        int[] inorder = {3, 2, 4, 1, 6, 5, 7};
//        int[] preorder = {1, 2, 3};
//        int[] inorder = {1, 2 ,3};
        TreeNode root = cbtpitb.buildTree(preorder, inorder);
        System.out.println();
    }
}
