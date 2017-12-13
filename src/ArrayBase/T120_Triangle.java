package ArrayBase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Qian Shaofeng
 * created on 2017/12/13.
 */
public class T120_Triangle {

    /**
     *  此种递归求解：Time Limit Exceeded, 递归求解需要考虑所有的情况，
     *  其实在很多时候，下一层节点只会在上一层节点中选择最优的，不会两种情况都考虑
     */
    private int result = Integer.MAX_VALUE;

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle==null || triangle.size()==0)
            return 0;

        List<Integer> list = triangle.get(0);
        for (int i=0; i < list.size(); ++i) {
            findMinimumPath(triangle, 1, i, list.get(i));
            findMinimumPath(triangle, 1, i+1, list.get(i));
        }
        return result;
    }

    private void findMinimumPath(List<List<Integer>> triangle, int depth, int loc, int sum){
        if (depth == triangle.size()){
            if (sum < result)
                result = sum;
            return;
        }

        List<Integer> list = triangle.get(depth);

        findMinimumPath(triangle, depth+1, loc, sum+list.get(loc));
        findMinimumPath(triangle, depth+1, loc+1, sum+list.get(loc));
    }

    /**
     * 动态规划算法
     *
     * 从下至上，不断的选择最优
     *
     * @param triangle
     * @return
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        if (triangle==null || triangle.size()==0)
            return 0;

        int[] dp = new int[triangle.get(triangle.size()-1).size()+1];
        for (int i=triangle.size()-1; i>=0; --i){
            for (int j=0; j < triangle.get(i).size(); ++j){
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {
        T120_Triangle triangle = new T120_Triangle();
    }
}
