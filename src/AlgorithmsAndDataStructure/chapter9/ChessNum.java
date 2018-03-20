package AlgorithmsAndDataStructure.chapter9;

/**
 * @author Qian Shaofeng
 * created on 2018/3/20.
 */
public class ChessNum {

    public static int solution(int nLevel, int kChess){
        if (nLevel < 1 || kChess < 1)
            return 0;

        if (kChess == 1){
            return  nLevel;
        }

        int[][] dp = new int[nLevel+1][kChess+1];
        for (int i=1; i < dp.length; ++i){
            dp[i][1] = i;
        }

        for (int i=1; i < dp.length; ++i){
            for (int j=2; j < dp[0].length; ++j){
                int min = Integer.MAX_VALUE;
                for (int k=1; k != i+1; ++k){
                    min = Math.min(min, Math.max(dp[k-1][j-1], dp[i-k][j]));
                }

                dp[i][j] = min +1;
            }
        }

        return dp[nLevel][kChess];
    }

    public static void main(String[] args) {
        System.out.println(ChessNum.solution(105, 2));
    }
}
