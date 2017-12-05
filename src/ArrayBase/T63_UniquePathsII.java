package ArrayBase;

/**
 * @author Qian Shaofeng
 *         created on 2017/12/5.
 */
public class T63_UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (m==0 || n==0)
            return 1;
        boolean flag=false;
        int[] rowSum = new int[n];
        for (int i=0; i < n; ++i) {
            if (obstacleGrid[0][i]==0 && !flag)
                rowSum[i] = 1;
            else {
                flag = true;
            }
        }
        for (int i=1; i < m; ++i){
            for (int j=0; j < n; ++j){
                if (obstacleGrid[i][j] == 0){
                    if (j>0)
                        rowSum[j] += rowSum[j-1];
                }else{
                    rowSum[j] = 0;
                }
            }
        }
        return rowSum[n-1];

    }

    public static void main(String[] args) {
        T63_UniquePathsII np = new T63_UniquePathsII();
        int[][] obstacleGrid = {{0, 1, 0}};
        System.out.println(np.uniquePathsWithObstacles(obstacleGrid));
    }
}
