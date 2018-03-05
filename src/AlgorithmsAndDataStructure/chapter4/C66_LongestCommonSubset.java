package AlgorithmsAndDataStructure.chapter4;

/**
 * @author Qian Shaofeng
 * created on 2018/3/5.
 */
public class C66_LongestCommonSubset {

    public String longestCommonSubset(String str1, String str2){
        if (str1==null || str2==null || str1.length()==0 || str2.length()==0)
            return "";


        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int[][] dp = process1(chs1, chs2);

        int max = 0;
        int s1 =0;
        for (int i=0; i < chs1.length; ++i){
            for (int j=0; j < chs2.length; ++j){
                if (dp[i][j] > max){
                    s1 = i;
                    max = dp[i][j];
                }
            }
        }

        return str1.substring(s1-max+1, s1+1);
    }

    public int[][] process1(char[] chs1, char[] chs2){

        int[][] dp = new int[chs1.length][chs2.length];

        for (int i=0; i < chs1.length; ++i){
            if (chs1[i] == chs2[0])
                dp[i][0] = 1;
        }

        for (int j=0; j < chs2.length; ++j){
            if (chs2[j] == chs1[0])
                dp[0][j] = 1;
        }

        for (int i=1; i < chs1.length; ++i){
            for (int j=1; j < chs2.length; ++j){
                if (chs1[i] == chs2[j]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
            }
        }

        return dp;
    }

    public static void main(String[] args) {
        C66_LongestCommonSubset longestCommonSubset = new C66_LongestCommonSubset();

        System.out.println(longestCommonSubset.longestCommonSubset("1AB2345CD", "12345EF"));
    }
}
