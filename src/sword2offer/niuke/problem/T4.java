package sword2offer.niuke.problem;

import sword2offer.niuke.utils.TreeNode;

/**
 * @author Qian Shaofeng
 * created on 2018/1/27.
 */
public class T4 {
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if(pre==null || in==null)
            return null;

        return constructBinaryTree(pre, 0, pre.length-1, in, 0, in.length-1);
    }

    private TreeNode constructBinaryTree(int[] pre, int ps, int pe, int[] in, int is, int ie){
        if(ps > pe || is > ie) {
            return null;
        }

        int value = pre[ps];
        TreeNode root = new TreeNode(value);

        int inIndex = findIndex(in, is, ie, value);
        root.left = constructBinaryTree(pre,ps+1, ps+inIndex-is, in, is, inIndex-1);
        root.right = constructBinaryTree(pre, ps+inIndex-is+1, pe, in, inIndex+1, ie);
        return root;

    }

    private int findIndex(int[] array, int s, int e, int target){
        for (int i=s; i <= e; ++i){
            if (array[i] == target)
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        T4 t4 = new T4();
        int[] pre = {1, 2, 4, 5, 3, 6, 7};
        int[] in = {4, 2, 5, 1, 6, 3, 7};
//        int[] pre = {1};
//        int[] in = {1};
        TreeNode r = t4.reConstructBinaryTree(pre, in);
        System.out.println(r);
    }
}
