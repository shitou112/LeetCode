package AlgorithmsAndDataStructure.chapter5;

import java.util.regex.Matcher;

/**
 * @author Qian Shaofeng
 * created on 2018/1/21.
 */
public class FindMinDistance {

    public int minDistance(String[] strs, String str1, String str2){
        if (strs==null || str1==null || str2==null)
            return -1;

        int pre1=-1, pre2=-1;
        int min = Integer.MAX_VALUE;
        for (int i=0; i < strs.length; ++i){
            if (strs[i].equals(str1)){
                pre1 = i;
                if (pre2 != -1){
                    min = Math.min(min, pre1 - pre2);
                }
            }

            if (strs[i].equals(str2)){
                pre2 = i;
                if (pre1 != -1){
                    min = Math.min(min, pre2 - pre1);
                }
            }
        }
        return min==Integer.MAX_VALUE? -1: min;
    }

    public static void main(String[] args) {
        FindMinDistance fms = new FindMinDistance();
        String[] strs = {"1", "3", "3", "3", "2", "3", "1"};
        System.out.println(fms.minDistance(strs, "3", "3"));
    }
}
