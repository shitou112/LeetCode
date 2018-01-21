package AlgorithmsAndDataStructure.chapter5;

/**
 * @author Qian Shaofeng
 * created on 2018/1/19.
 */
public class CountString {

    public String countString(String str){
        if (str == null || str.length()==0)
            return null;

        char pre = str.charAt(0);
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i=1; i < str.length(); ++i){
            if (str.charAt(i) == pre)
                ++count;
            else {
                sb.append(pre+"_"+count+"_");
                count = 1;
                pre = str.charAt(i);
            }
        }

        if (count!=0){
            sb.append(pre+"_"+count);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        CountString cs = new CountString();
        System.out.println(cs.countString("aaaabbaddffcc"));
    }
}
