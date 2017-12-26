package AlgorithmsAndDataStructure.chapter3;

import AlgorithmsAndDataStructure.utils.TreeNode;

import java.util.Stack;

/**
 * @author Qian Shaofeng
 * created on 2017/12/26.
 */
public class TreePreInPosOrder {

    public void posOrder(TreeNode root){
        if (root==null)
            return;

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.add(root);
        TreeNode node;
        while (!s1.isEmpty()){
            node = s1.pop();
            s2.add(node);
            if (node.left != null){
                s1.add(node.left);
            }
            if (node.right != null){
                s1.add(node.right);
            }
        }

        while (!s2.isEmpty()){
            System.out.println(s2.pop().value);
        }
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

        r3.left = r6;
        r3.right = r7;

        r7.left = r8;

        TreePreInPosOrder t = new TreePreInPosOrder();
        t.posOrder(r1);
    }
}
