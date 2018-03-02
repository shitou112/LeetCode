package AlgorithmsAndDataStructure.chapter2;

import AlgorithmsAndDataStructure.utils.TreeNode;

/**
 * @author Qian Shaofeng
 * created on 2018/3/2.
 */
public class C26_ConvertTreeToLinkedList {

    public TreeNode convert(TreeNode root){
        TreeNode tmp =  recursive(root);
        TreeNode head = tmp.right;
        tmp.right = null;

        return head;
    }

    public TreeNode recursive(TreeNode root){
        if (root == null)
            return null;

        TreeNode left = recursive(root.left);
        TreeNode right = recursive(root.right);

        TreeNode leftS = left != null? left.right: null;
        TreeNode rightS = right != null? right.right: null;

        if (left != null && right != null){
            left.right = root;
            root.left = left;
            root.right = rightS;
            rightS.left = root;
            right.right = leftS;

            return right;
        }
        else if (left != null && right == null){
            left.right = root;
            root.left = left;
            root.right = leftS;

            return root;
        }
        else if (left == null && right != null){
            root.right = rightS;
            rightS.left = root;
            right.right = root;

            return right;
        }
        else {
            root.right = root;
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);

        t6.left = t4;
        t6.right = t7;

        t4.left = t2;
        t4.right = t5;

        t7.right = t9;

        t2.left = t1;
        t2.right = t3;

        t9.left = t8;

        C26_ConvertTreeToLinkedList ctl = new C26_ConvertTreeToLinkedList();
        TreeNode head = ctl.convert(t6);
        System.out.println(head);
    }
}
