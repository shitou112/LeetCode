package AlgorithmsAndDataStructure.chapter2;

import AlgorithmsAndDataStructure.utils.TreeNode;

/**
 * @author Qian Shaofeng
 * created on 2018/1/24.
 */
public class Tree2BiLinkedList {

    TreeNode preNode;

    public TreeNode generateBiLinkedList2(TreeNode root){

        inOrder(root);

        TreeNode tmp = preNode;
        while (tmp.left!=null)
            tmp = tmp.left;
        return tmp;
    }

    private void inOrder(TreeNode head){
        if (head==null)
            return;

        inOrder(head.left);
        head.left = preNode;
        if (preNode!=null){
            preNode.right = head;
        }
        preNode = head;

        inOrder(head.right);
    }

    public TreeNode generateBiLinkedList(TreeNode root){
        if (root==null)
            return null;

        TreeNode last = getLastNode(root);
        TreeNode head = last.right;
        last.right = null;
        return head;
    }

    private TreeNode getLastNode(TreeNode head){
        if (head==null)
            return null;

        TreeNode left = getLastNode(head.left);
        TreeNode right = getLastNode(head.right);

        TreeNode leftS = left==null? null: left.right;
        TreeNode rightS = right==null? null: right.right;

        if (leftS!=null && rightS!=null){
            left.right = head;
            head.left = left;
            head.right = rightS;
            rightS.left = head;
            right.right = leftS;

            return right;
        }
        else if (leftS!=null){
            left.right = head;
            head.left = left;
            head.right = leftS;

            return head;
        }
        else if (rightS!=null){
            head.right = rightS;
            rightS.left= head;
            right.right = head;

            return right;
        }
        else {
            head.right = head;

            return head;
        }
    }

    public static void main(String[] args) {
        Tree2BiLinkedList tree2BiLinkedList = new Tree2BiLinkedList();
        TreeNode r1 = new TreeNode(5);
        TreeNode r2 = new TreeNode(3);
        TreeNode r3 = new TreeNode(7);
        TreeNode r4 = new TreeNode(2);
        TreeNode r5 = new TreeNode(4);
        TreeNode r6 = new TreeNode(6);
        TreeNode r7 = new TreeNode(8);

        r1.left = r2;
        r1.right = r3;

        r2.left = r4;
        r2.right = r5;

        r3.left = r6;
        r3.right = r7;

        TreeNode head = tree2BiLinkedList.generateBiLinkedList2(r1);
        System.out.println(head);


    }
}
