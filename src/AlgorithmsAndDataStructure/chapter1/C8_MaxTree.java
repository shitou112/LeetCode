package AlgorithmsAndDataStructure.chapter1;


import AlgorithmsAndDataStructure.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Qian Shaofeng
 * created on 2018/2/1.
 */
public class C8_MaxTree {

    public TreeNode getMaxTreeNode(int[] array){
        if (array==null)
            return null;

        TreeNode[] treeNodes = new TreeNode[array.length];
        for (int i=0; i < array.length; ++i){
            treeNodes[i] = new TreeNode(array[i]);
        }

        Map<Integer, TreeNode> lmaps = new HashMap<>();
        Map<Integer, TreeNode> rmaps = new HashMap<>();

        Stack<Integer> stack = new Stack<>();
        for (int i=0; i < array.length; ++i){
            while (!stack.isEmpty() && array[stack.peek()] < array[i]){
                int index = stack.pop();
                rmaps.put(index, treeNodes[i]);
            }

            if (stack.isEmpty()){
                lmaps.put(i, null);
            }
            else {
                lmaps.put(i, treeNodes[stack.peek()]);
            }
            stack.add(i);
        }

        while (!stack.isEmpty()){
            int index = stack.pop();
            if (!stack.isEmpty()) {
                lmaps.put(index, treeNodes[stack.peek()]);
            }
        }

        TreeNode head = null;
        TreeNode parent;
        for (int i=0; i < array.length; ++i){
            TreeNode left = lmaps.get(i);
            TreeNode right = rmaps.get(i);

            if (left!=null && right!=null){
                parent = left.value < right.value? left: right;
                if (parent.left==null)
                    parent.left = treeNodes[i];
                else
                    parent.right = treeNodes[i];
            }
            else if (left==null && right!=null){
                if (right.left == null)
                    right.left = treeNodes[i];
                else
                    right.right = treeNodes[i];
            }
            else if (left!=null && right==null){
                if (left.left == null)
                    left.left = treeNodes[i];
                else
                    left.right = treeNodes[i];
            }
            else {
                head = treeNodes[i];
            }

        }

        return head;
    }

    public static void main(String[] args) {
        C8_MaxTree c8 = new C8_MaxTree();
        int[] array = {3, 4, 5, 1 ,2};
        TreeNode treeNode = c8.getMaxTreeNode(array);
        System.out.println(treeNode);
    }
}
