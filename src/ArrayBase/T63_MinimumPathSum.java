package ArrayBase;

import java.util.Arrays;

/**
 * @author Qian Shaofeng
 *         created on 2017/12/5.
 */
public class T63_MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for (int i=1; i < n; ++i){
            dp[i] = dp[i-1] + grid[0][i];
        }
        for (int i=1; i < m; ++i){
            for (int j=0; j < n; ++j){
                if (j > 0)
                    dp[j] =grid[i][j] + Math.min(dp[j-1], dp[j]);
                else
                    dp[j] += grid[i][j];
            }
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        T63_MinimumPathSum mps = new T63_MinimumPathSum();
        int[][] paths = {{1,3,1}, {1, 5, 1}, {4,2,1}};
        System.out.println(mps.minPathSum(paths));
    }
}
