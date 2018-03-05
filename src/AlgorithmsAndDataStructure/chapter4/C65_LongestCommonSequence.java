package AlgorithmsAndDataStructure.chapter4;

/**
 * @author Qian Shaofeng
 * created on 2018/3/5.
 */
public class C65_LongestCommonSequence {

    public String longestCommonSequence(String str1, String str2){
        if (str1 == null || str2 == null || str1.length()==0 || str2.length()==0)
            return "";

        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();

        int[][] dp = process(chs1, chs2);
        int max = dp[chs1.length-1][chs2.length-1];
        char[] res = new char[max];
        int i = chs1.length-1;
        int j = chs2.length-1;
        while (i>=0 && j>=0){
            if (i > 0 && dp[i][j] == dp[i-1][j]){
                --i;
            }
            else if (j > 0&& dp[i][j] == dp[i][j-1]){
                --j;
            }
            else {
                res[--max] = chs1[i];
                --i;
                --j;
            }
        }

        return new String(res);
    }

    private int[][] process(char[] chs1, char[] chs2){
        int[][] dp = new int[chs1.length][chs2.length];

        dp[0][0] = chs1[0]==chs2[0]? 1: 0;
        for (int i=1; i < chs1.length; ++i){
            if (chs1[i] == chs2[0])
                dp[i][0] = 1;
            else
                dp[i][0] = dp[i-1][0];
        }

        for (int j=1; j < chs2.length; ++j){
            if (chs1[0] == chs2[j])
                dp[0][j] = 1;
            else
                dp[0][j] = dp[0][j-1];
        }

        for (int i=1; i < chs1.length; ++i){
            for (int j=1; j < chs2.length; ++j){
                if (chs1[i] == chs2[j]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }

                int value = Math.max(dp[i-1][j], dp[i][j-1]);
                dp[i][j] = Math.max(dp[i][j], value);
            }
        }

        return dp;
    }

    public static void main(String[] args) {
        C65_LongestCommonSequence longestCommonSequence = new C65_LongestCommonSequence();
        System.out.println(longestCommonSequence.longestCommonSequence("1A2C3D4B56", "B1D23CA45B6A"));
    }
}
