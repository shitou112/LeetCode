package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Qian Shaofeng
 * created on 2018/3/8.
 */
class TreeNode{
    public int value;

    public TreeNode left;

    public TreeNode right;

    public TreeNode(int value){
        this.value = value;
    }

}

public class TreeHeight{
    public int getHeight(){
        Scanner scanner = new Scanner(System.in);
        int treeNums = scanner.nextInt();
        Map<Integer, TreeNode> maps = new HashMap<>();
        int t1, t2;
        TreeNode tmp1, tmp2;
        TreeNode head = null;
        while(maps.size() < treeNums){
            t1 = scanner.nextInt();
            t2 = scanner.nextInt();
            if(maps.get(t1) == null){
                tmp1 = new TreeNode(t1);
                maps.put(t1, tmp1);

                head = head==null? tmp1: head;
            }
            else{
                tmp1 = maps.get(t1);
            }

            if(maps.get(t2) == null){
                tmp2 = new TreeNode(t2);
                maps.put(t2, tmp2);
            }
            else{
                tmp2 = maps.get(t2);
            }

            if(tmp1.left == null){
                tmp1.left = tmp2;
            }
            else{
                tmp1.right = tmp2;
            }
        }

        return getHeight(head, 0);
    }

    public int getHeight(TreeNode head, int depth){
        if(head == null){
            return depth;
        }

        return Math.max(getHeight(head.left, depth+1), getHeight(head.right, depth+1));
    }

    public static void main(String[] args){
        TreeHeight treeHeight = new TreeHeight();
        int a = treeHeight.getHeight();
        System.out.println(a);

    }
}
