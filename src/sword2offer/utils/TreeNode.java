package sword2offer.utils;

/**
 * @author Qian Shaofeng
 * created on 2018/1/27.
 */
public class TreeNode {

    public int val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode(int x) { val = x; }

    public TreeNode generateBinTree(){
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(1);
        TreeNode r3 = new TreeNode(1);
        TreeNode r4 = new TreeNode(1);
        TreeNode r5 = new TreeNode(1);
        TreeNode r6 = new TreeNode(1);
        TreeNode r7 = new TreeNode(1);

        r1.left = r2;
        r1.right = r3;

        r2.left = r4;
        r2.right = r5;

        r3.left = r6;
        r4.right = r7;

        return r1;
    }

}
