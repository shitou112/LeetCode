package AlgorithmsAndDataStructure.chapter5;

import java.util.Stack;

/**
 * @author Qian Shaofeng
 * created on 2018/1/21.
 */
public class Parenthesis {

    public boolean isValid(String str){
        if (str==null || str.length()==0)
            return false;

        char[] chs = str.toCharArray();
        int leftParentheis = 0;
        for (int i=0; i < chs.length; ++i){
            if (chs[i] == '('){
                ++leftParentheis;
            }
            else if (chs[i] == ')'){
                --leftParentheis;
                if (leftParentheis < 0)
                    return false;
            }
            else {
                return false;
            }
        }

        return leftParentheis==0;
    }


    public int maxLength(String str){
        if (str==null || str.length()==0)
            return 0;

        char[] chs = str.toCharArray();
        int[] dp = new int[chs.length];
        for (int i=1; i < chs.length; ++i){
            if (chs[i] == ')'){
                int preIndex = i - dp[i-1] -1;
                if (chs[preIndex]=='(') {
                    dp[i] = dp[i - 1] + 2 + (preIndex >= 1 ? dp[preIndex - 1] : 0);
                    System.out.println(dp[i]);
                }
            }
            dp[i] = Math.max(dp[i-1], dp[i]);

        }
        return dp[chs.length-1];

    }
    public static void main(String[] args) {
        Parenthesis p = new Parenthesis();
//        System.out.println(p.isValid(""));
        System.out.println(p.maxLength("(())()"));
    }
}
