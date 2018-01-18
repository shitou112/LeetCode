package AlgorithmsAndDataStructure.chapter4;

/**
 * @author Qian Shaofeng
 * created on 2018/1/17.
 */
public class DungeonFigher {
    public int minHp(int[][] map){
        if (map==null || map.length==0 || map[0].length==0)
            return 0;
        int m = map.length;
        int n = map[0].length;
        int[][] dp = new int[m][n];
        for (int j=0; j < n; ++j){
            dp[0][j] = map[0][j];
        }
        for (int i=1; i < m; ++i){
            dp[i][0] = dp[i-1][0] + map[i][0];
            for (int j=1; j < n; ++j){
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + map[i][j];
            }
        }

        return -dp[m-1][n-1];
    }

    public static void main(String[] args) {
        DungeonFigher df = new DungeonFigher();
        int[][] map = {
                {-2, -3, 3},
                {-5, -10, 1},
                {0, 30, -5}
        };
        System.out.println(df.minHp(map));
    }
}
