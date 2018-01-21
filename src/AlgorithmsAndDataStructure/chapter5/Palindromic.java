package AlgorithmsAndDataStructure.chapter5;

/**
 * @author Qian Shaofeng
 * created on 2018/1/21.
 */
public class Palindromic {

    public String minPalindromic(String str){
        if (str==null || str.length()==0)
            return null;

        char[] chs = str.toCharArray();
        int[][] dp = getDp(chs);

        System.out.println(str.length());
        System.out.println(dp[0][chs.length-1]);
        char[] res = new char[str.length() + dp[0][chs.length-1]];
        int i = 0, j = chs.length-1;
        int s = 0, e = res.length-1;
        while (i <= j){
            if (chs[i] == chs[j]){
                res[s++] = chs[i++];
                res[e--] = chs[j--];
            }
            else if (dp[i][j-1] < dp[i+1][j]){
                res[s++] = chs[j];
                res[e--] = chs[j--];
            }
            else {
                res[s++] = chs[i];
                res[e--] = chs[i++];
            }
        }

        return String.valueOf(res);
    }

    public int[][] getDp(char[] chs){
        int n = chs.length;
        int[][] dp = new int[n][n];

        for (int j=1; j < n; ++j){
            dp[j-1][j] = chs[j-1]==chs[j]? 0: 1;
            for (int i=j-2; i > -1; --i){
                if (chs[i] == chs[j])
                    dp[i][j] = dp[i+1][j-1];
                else
                    dp[i][j] = Math.min(dp[i+1][j], dp[i][j-1]) + 1;
            }
        }

        return dp;
    }



    public static void main(String[] args) {
        Palindromic p = new Palindromic();
        String str = "ABACB";
        System.out.println(p.minPalindromic(str));
//        System.out.println(p.getDp2(str.toCharArray()));
    }
}
