package AlgorithmsAndDataStructure.chapter4;

/**
 * @author Qian Shaofeng
 * created on 2018/1/17.
 */
public class LongestCommonSubsequence {

    public String lcs(String str1, String str2){
        if (str1==null || str2==null || str1.length()==0 || str2.length()==0)
            return null;

        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();

        int[][] dp = getDp(chs1, chs2);
        char[] res = new char[dp[chs1.length-1][chs2.length-1]];
        int index = res.length - 1;
        int i=chs1.length-1, j=chs2.length-1;
        while (index>=0){
//            if (j > 0 && dp[i][j] == dp[i][j-1]){
//                --j;
//            }
//            else if (i > 0 && dp[i][j] == dp[i-1][j])
//                --i;
//            else {
//                res[index--] = chs2[j];
//                --i;
//                --j;
//            }

//          错误解法
            if ( i > 0 && j>0 &&  dp[i][j]==(dp[i-1][j-1]+1)){
                res[index--] = chs1[i];
                --i;
                --j;
            }
            else if (j > 0 && dp[i][j] == dp[i][j-1]){
                --j;
            }
            else
                --i;
        }

        return String.valueOf(res);

    }

    private int[][] getDp(char[] chs1, char[] chs2){
        int[][] dp = new int[chs1.length][chs2.length];

        dp[0][0] = chs1[0]==chs2[0]? 1: 0;
        for (int i=1; i < chs1.length; ++i){
            dp[i][0] = Math.max(dp[i-1][0], chs1[i]==chs2[0]? 1: 0);
        }

        for (int j=1; j < chs2.length; ++j){
            dp[0][j] = Math.max(dp[0][j-1], chs1[0]==chs2[j]? 1: 0);
        }

        for (int i=1; i < chs1.length; ++i){
            for (int j=1; j < chs2.length; ++j){
                dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                if (chs1[i] == chs2[j])
                    dp[i][j] = Math.max(dp[i-1][j-1]+1, dp[i][j]);
            }
        }

        return dp;
    }

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String str1 = "1a2c3d4b56";
        String str2 = "b1d23ca45b6a";
        System.out.println(lcs.lcs(str1, str2));
    }
}
