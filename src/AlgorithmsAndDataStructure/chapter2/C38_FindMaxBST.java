package AlgorithmsAndDataStructure.chapter2;

import AlgorithmsAndDataStructure.utils.TreeNode;

/**
 * @author Qian Shaofeng
 * created on 2018/3/3.
 */
public class C38_FindMaxBST {

    public TreeNode findMaxBST(TreeNode head){
        if (head == null)
            return null;
        int[] records = new int[3];
        return posOrder(head, records);
    }

    public TreeNode posOrder(TreeNode head, int[] records){
        if (head == null){
            records[0] = 0;
            records[1] = Integer.MAX_VALUE;
            records[2] = Integer.MIN_VALUE;
            return null;
        }

        TreeNode left = head.left;
        TreeNode right = head.right;

        TreeNode lBST = posOrder(left, records);
        int lNodesNum = records[0];
        int lmin = records[1];
        int lmax = records[2];

        TreeNode rBST = posOrder(right, records);
        int rNodesNum = records[0];
        int rmin = records[1];
        int rmax = records[2];

        records[1] = Math.min(lmin, head.value);
        records[2] = Math.max(rmax, head.value);
        if (left == lBST && right == rBST && lmax < head.value && head.value < rmin){
            records[0] = lNodesNum + rNodesNum + 1;

            return head;
        }

        records[0] = lNodesNum > rNodesNum? lNodesNum: rNodesNum;
        return lNodesNum > rNodesNum? lBST: rBST;
    }
}
