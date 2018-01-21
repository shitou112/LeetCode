package AlgorithmsAndDataStructure.chapter3;


import AlgorithmsAndDataStructure.utils.TreeNode;

/**
 * @author Qian Shaofeng
 * created on 2018/1/2.
 */
public class PrintBorderNode {
    public void printEdge(TreeNode root){
        if (root==null)
            return;

        int height = getHeight(root);
        TreeNode[][] edges = new TreeNode[height][2];
        getEdges(root, 0, edges);

        for (int i = 0; i < height; ++i) {
            System.out.println(edges[i][0].value);
        }

        for (int i=height-1; i >= 0; --i){
            if (edges[i][1]!=edges[i][0])
                System.out.println(edges[i][1].value);
        }



        inOrder(root, 0, edges);
    }

    private int getHeight(TreeNode root){
        if (root==null)
            return 0;

        return Math.max(getHeight(root.left)+1, getHeight(root.right)+1);
    }

    private void getEdges(TreeNode root, int layer, TreeNode[][] edges){
        if (root==null)
            return;
        if (edges[layer][0]==null)
            edges[layer][0] = root;
        edges[layer][1] = root;
        getEdges(root.left, layer+1, edges);
        getEdges(root.right, layer+1, edges);
    }

    private void inOrder(TreeNode root, int layer, TreeNode[][] edges){
        if (root==null)
            return;


        if (root.left==null & root.right==null && root!=edges[layer][0] && root!=edges[layer][1])
            System.out.println(root.value);

        inOrder(root.left, layer+1, edges);
        inOrder(root.right, layer+1, edges);
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

        PrintBorderNode p = new PrintBorderNode();
        p.printEdge(r1);
    }
}
