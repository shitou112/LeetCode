package AlgorithmsAndDataStructure.chapter5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Qian Shaofeng
 * created on 2018/1/19.
 */
public class StringSum {

    public int numSum(String str){
        if (str == null || str.length()==0)
            return 0;

        Pattern p = Pattern.compile("([-]*[0-9]+)");
        Matcher m = p.matcher(str);
        int sum = 0;
        while (m.find()){
            String digitStr = m.group();
            int end = digitStr.lastIndexOf('-');
            int value = Integer.valueOf(digitStr.substring(end + 1, digitStr.length()));
            sum += end%2==1? value: -value;
            System.out.println(end % 2);
        }

        return sum;
    }

    public static void main(String[] args) {
        StringSum ss = new StringSum();
        System.out.println(ss.numSum("A1Bc--12-"));
    }
}
