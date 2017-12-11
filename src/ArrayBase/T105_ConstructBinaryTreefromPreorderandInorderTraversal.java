package ArrayBase;

/**
 * @author Qian Shaofeng
 * created on 2017/12/11.
 */
public class T105_ConstructBinaryTreefromPreorderandInorderTraversal {
    static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0|| inorder.length==0)
            return null;
        return dfs(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, new TreeNode(0));
    }

    private TreeNode dfs(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, TreeNode root){
        int value = preorder[preStart];
        root.val = value;

        int inRootIndex = inStart;
        for (int i=inStart; i <= inEnd; ++i){
            if (inorder[i] == value) {
                inRootIndex = i;
                break;
            }
        }
        System.out.println(inRootIndex+"  "+value);
        int leftLength = inRootIndex - inStart;
        int leftIndex = leftLength + preStart;
        if (leftLength > 0) {
            root.left = dfs(preorder, preStart + 1, leftIndex, inorder, inStart, inRootIndex - 1, new TreeNode(0));
        }
        if (preEnd - preStart > leftLength) {
            root.right = dfs(preorder, leftIndex + 1, preEnd, inorder, inRootIndex + 1, inEnd, new TreeNode(0));
        }return root;

    }

    public static void main(String[] args) {
        T105_ConstructBinaryTreefromPreorderandInorderTraversal cbtpit = new T105_ConstructBinaryTreefromPreorderandInorderTraversal();
        int[] preorder = {1, 2, 3, 4, 5};
        int[] inorder = {4, 2 , 1, 5, 3};
        TreeNode root = cbtpit.buildTree(preorder, inorder);
        System.out.println();
    }
}
