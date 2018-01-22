package AlgorithmsAndDataStructure.chapter5;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Qian Shaofeng
 * created on 2018/1/22.
 */
public class FindNoRepetitionMaxString {

    public int maxString(String str){
        if (str==null || str.length()==0)
            return 0;

        Set<Character> set = new HashSet<>();
        char[] chs = str.toCharArray();
        int max = 0, cur=0;
        for (int i=0; i < chs.length; ++i){
            if (set.contains(chs[i])){
                set.clear();
                cur = 1;
                set.add(chs[i]);
            }
            else {
                set.add(chs[i]);
                ++cur;
                if (cur > max)
                    max = cur;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        FindNoRepetitionMaxString f = new FindNoRepetitionMaxString();
        System.out.println(f.maxString("abbefcde"));
    }
}
