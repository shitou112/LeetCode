package ArrayBase;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Qian Shaofeng
 * created on 2017/12/12.
 */
public class T106_ConstructBinaryTreefromInorderandPostorderTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || inorder==null || postorder.length==0 || inorder.length==0)
            return null;
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i=0; i < inorder.length; ++i){
            indexMap.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, indexMap);

    }

    private TreeNode buildTree(int[] inorder, int startInOrder, int endInOder,
                               int[] postorder, int startPostOrder, int endPostOrder,
                               Map<Integer, Integer> indexMap){
        int inRootIndex = indexMap.get(postorder[endPostOrder]);
        TreeNode root = new TreeNode(postorder[endPostOrder]);
        int rightLen = endInOder - inRootIndex;
        int rightIndex = endPostOrder - rightLen;
        if (rightLen > 0)
            root.right = buildTree(inorder, inRootIndex+1, endInOder, postorder, rightIndex, endPostOrder-1, indexMap);
        if (endInOder - startInOrder > rightLen)
            root.left = buildTree(inorder, startInOrder, inRootIndex-1, postorder, startPostOrder, rightIndex-1, indexMap);

        return root;
    }

    public static void main(String[] args) {
        T106_ConstructBinaryTreefromInorderandPostorderTraversal cbtipt = new T106_ConstructBinaryTreefromInorderandPostorderTraversal();
//        int[] inorder = {3, 4, 2, 1, 6, 5, 8, 7};
//        int[] postorder = {4, 3, 2, 6, 8, 7, 5, 1};
        int[] inorder = {3};
        int[] postorder = {3};

        TreeNode root = cbtipt.buildTree(inorder, postorder);
        System.out.println();
    }

}
