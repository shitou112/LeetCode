package ArrayBase;

import java.util.Arrays;

/**
 * @author Qian Shaofeng
 *         created on 2017/12/5.
 */
public class UniquePaths_62_best {
    public int uniquePaths(int m, int n) {
        int[] row = new int[n];
        Arrays.fill(row,1);
        for ( int i = 1; i < m; i++){
            for ( int j = 1; j < n; j++){
                row[j]+=row[j-1];
            }
        }
        return row[n-1];
    }
}
