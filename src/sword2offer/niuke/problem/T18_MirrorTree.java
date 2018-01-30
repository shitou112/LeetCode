package sword2offer.niuke.problem;

import sword2offer.niuke.utils.TreeNode;

/**
 * @author Qian Shaofeng
 * created on 2018/1/30.
 */
public class T18_MirrorTree {

    public void Mirror(TreeNode root) {
        if (root == null)
            return;

        TreeNode tmp;
        tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        Mirror(root.left);
        Mirror(root.right);
    }
}
