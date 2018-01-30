package sword2offer.niuke.problem;

import sword2offer.niuke.utils.TreeNode;

/**
 * @author Qian Shaofeng
 * created on 2018/1/30.
 */
public class T17_IsTreeSubstructure {

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {

        if (root1 == null || root2 == null)
            return false;

        return isEqual(root1, root2);

    }

    private boolean isEqual(TreeNode root1, TreeNode root2){
        if (root2 == null)
            return true;

        if (root1 == null)
            return false;


        if (root1.val == root2.val && isEqual(root1.left, root2.left) && isEqual(root1.right, root2.right)){
            return true;
        }
        else {
            return isEqual(root1.left, root2) || isEqual(root1.right, root2);
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(8);
        TreeNode t2 = new TreeNode(8);
        TreeNode t3 = new TreeNode(7);
        TreeNode t4 = new TreeNode(9);
        TreeNode t5 = new TreeNode(2);
        TreeNode t6 = new TreeNode(4);
        TreeNode t7 = new TreeNode(7);

        t1.left = t2;
        t1.right = t3;

        t2.left = t4;
        t2.right = t5;

        t5.left = t6;
        t5.right = t7;

        TreeNode r1 = new TreeNode(8);
        TreeNode r2 = new TreeNode(9);
        TreeNode r3 = new TreeNode(3);

        r1.left = r2;
        r1.right = r3;


        T17_IsTreeSubstructure t17 = new T17_IsTreeSubstructure();
        System.out.println(t17.HasSubtree(t1, r1));
    }
}
