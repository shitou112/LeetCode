package AlgorithmsAndDataStructure.chapter4;

/**
 * @author Qian Shaofeng
 * created on 2018/1/17.
 */
public class LongestCommonSubset {

    public String lcs1(String str1, String str2){
        if (str1==null || str2==null || str1.length()==0 || str2.length()==0)
            return null;

        int max = 0, index=0;
        int m=str1.length(), n=str2.length();
        int row=0, col=n-1;
        int len;
        while (row < m){
            len = 0;
            int i=row, j=col;
            while (i<m && j<n){
                if (str1.charAt(i)==str2.charAt(j)){
                    len += 1;
                    if (len > max) {
                        max = len;
                        index = i;
                    }

                }
                else {
                    len = 0;
                }
                ++i;
                ++j;
            }
            if (col >= 1)
                --col;
            else
                ++row;
        }

        return str1.substring(index-max+1, index+1);

    }

    public String lcs2(String str1, String str2){
        if (str1==null || str2==null || str1.length()==0 || str2.length()==0)
            return null;
        int[][] dp = getDp(str1, str2);
        int max=0, index=0;
        for (int i=0; i < str1.length(); ++i){
            for (int j=0; j < str2.length(); ++j){
                if (dp[i][j] > max){
                    max = dp[i][j];
                    index = i;
                }
            }
        }

        return str1.substring(index-max+1, index+1);

    }

    private int[][] getDp(String str1, String str2){
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m][n];
        for (int i=0; i < m; ++i){
            if (str1.charAt(i)==str2.charAt(0))
                dp[i][0] = 1;
        }

        for (int j=0; j < n; ++j){
            if (str1.charAt(0) == str2.charAt(j))
                dp[0][j] = 1;
        }

        for (int i=1; i < m; ++i){
            for (int j=1; j < n; ++j){
                if (str1.charAt(i) == str2.charAt(j))
                    dp[i][j] = dp[i-1][j-1] + 1;
            }
        }

        return dp;
    }

    public static void main(String[] args) {
        LongestCommonSubset l = new LongestCommonSubset();
        String str1 = "1AB2345CD";
        String str2 = "12345EF";
        System.out.println(l.lcs2(str1, str2));
    }

}
