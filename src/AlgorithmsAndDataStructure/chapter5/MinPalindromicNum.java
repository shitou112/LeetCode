package AlgorithmsAndDataStructure.chapter5;

/**
 * @author Qian Shaofeng
 * created on 2018/1/23.
 */
public class MinPalindromicNum {

    public int minNum(String str){
        if (str==null || str.length()==0)
            return 0;

        char[] chs = str.toCharArray();
        int[] dp = new int[chs.length+1];
        boolean[][] p = new boolean[chs.length][chs.length];
        for (int i=chs.length-1; i>=0; --i){
            dp[i] = Integer.MAX_VALUE;
            for (int j=i; j < chs.length; ++j){
                if (chs[i]==chs[j] && (j-i<2 || p[i+1][j-1])){
                    p[i][j] = true;
                    dp[i] = Math.min(dp[i], dp[j+1]+1);
                }
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {
        MinPalindromicNum mpn = new MinPalindromicNum();
        System.out.println(mpn.minNum("ACDCDCDAD"));
    }
}
