package AlgorithmsAndDataStructure.chapter9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Qian Shaofeng
 * created on 2018/3/6.
 */
public class ParenthesesMatchNums {

    private Set<String> parenthesesMatch(int n){
        Set<String> res = new HashSet<>();
        if (n==0) {
            res.add("");
        }

        if (n==1){
            res.add("()");
        }

        for (int i=1; i<=n; ++i){
            Set<String> left = parenthesesMatch(i-1);
            Set<String> right = parenthesesMatch(n-i);
            for (String l: left){
                for (String r: right){
                    res.add("("+l+")"+r);
                }
            }
        }

        return res;

    }

    public static void main(String[] args) {
        ParenthesesMatchNums pm = new ParenthesesMatchNums();
        Set<String> res = pm.parenthesesMatch(12);
//        Set<String> r = new HashSet<>(res);
        System.out.println(res.size());
    }
}
