package AlgorithmsAndDataStructure.chapter3;

import AlgorithmsAndDataStructure.utils.TreeNode;

/**
 * @author Qian Shaofeng
 * created on 2018/1/12.
 */
public class TreeMaxDistance {
    public int maxDistance(TreeNode root){
        if (root==null)
            return 0;

        int[] children = new int[2];
        posOrder(root, children);
        return children[0] + 1 + children[1];
    }

    private int posOrder(TreeNode head, int[] children){
        if (head==null)
            return 0;

        int left = posOrder(head.left, children);
        int rihgt = posOrder(head.right, children);

        children[0] = left;
        children[1] = rihgt;

        return Math.max(left, rihgt) + 1;
    }

    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(5);
        TreeNode r6 = new TreeNode(6);
        TreeNode r7 = new TreeNode(7);
        TreeNode r8 = new TreeNode(8);

        r1.left = r2;
        r1.right = r3;

        r2.left = r4;
        r4.left = r5;
//
//        r3.left = r6;
//        r3.right = r7;
//
//        r7.left = r8;

        TreeMaxDistance tmd = new TreeMaxDistance();
        System.out.println(tmd.maxDistance(r1));
    }
}
