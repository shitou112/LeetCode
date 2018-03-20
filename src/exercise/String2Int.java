package exercise;

/**
 * @author Qian Shaofeng
 * created on 2018/3/20.
 */
public class String2Int {

    public static int string2Int(String str){
        if (str==null || str.length()==0)
            return 0;

        char[] chs = str.toCharArray();
        int res = 0;
        for (int i=0; i < str.length(); ++i){
            res = res*10 + chs[i] - '0';
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(String2Int.string2Int("123"));
    }
}
