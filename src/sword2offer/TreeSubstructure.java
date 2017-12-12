package sword2offer;

/**
 * @author Qian Shaofeng
 * created on 2017/12/12.
 */
public class TreeSubstructure {
    static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
        public TreeNode(int value) {
            this.value = value;
        }
    }
    public boolean isSubstructure(TreeNode A, TreeNode B){
        boolean result = false;
        if (A != null && B != null) {
            if (A.value == B.value) {
                result = isAHasB(A.left, B.left) && isAHasB(A.right, B.right);
            }
            if (!result)
                result = isSubstructure(A.left, B) || isSubstructure(A.right, B);
        }

        return result;
    }

    private boolean isAHasB(TreeNode A, TreeNode B){
        if (B == null)
            return true;
        if (A == null)
            return false;
        if (A.value != B.value)
            return false;

        return isAHasB(A.left, B.left) && isAHasB(A.right, B.right);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(8);
        TreeNode t2 = new TreeNode(8);
        TreeNode t3 = new TreeNode(7);
        TreeNode t4 = new TreeNode(9);
        TreeNode t5 = new TreeNode(2);
        TreeNode t6 = new TreeNode(4);
        TreeNode t7 = new TreeNode(7);

        TreeNode tB1 = new TreeNode(8);
        TreeNode tB2 = new TreeNode(9);
        TreeNode tB3 = new TreeNode(2);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t5.left = t6;
        t5.right = t7;

        tB1.left = tB2;
        tB1.right = tB3;

        TreeSubstructure ts = new TreeSubstructure();
        System.out.println(ts.isSubstructure(t1, tB1));

    }
}
