package AlgorithmsAndDataStructure.chapter5;

/**
 * @author Qian Shaofeng
 * created on 2018/1/19.
 */
public class ReplaceConsecutiveString {

    public String replace(String str, String from, String to){
        if (str==null || from==null)
            return str;

        char[] chs = str.toCharArray();
        char[] chf = from.toCharArray();

        int match = 0;
        for (int i=0; i < chs.length; ++i){
            if (chs[i] == chf[match++]){
                if (match == chf.length){
                    clear(chs, i, chf.length);
                    match = 0;
                }
            }
            else {
                if (chs[i] == chf[0]) {
                    --i;
                }
                match = 0;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i < chs.length; ++i){
            if (chs[i]!=0)
                sb.append(chs[i]);
            else if (i==0 || chs[i-1]!=0)
                sb.append(to);
        }
        return sb.toString();
    }

    private void clear(char[] chs, int index, int len){
        for (int i=index; i > index-len; --i){
            chs[i] = 0;
        }

    }

    public static void main(String[] args) {
        ReplaceConsecutiveString rcs = new ReplaceConsecutiveString();
        String str = "12abcabc4aba";
        String from = "abc";
        String to = "xxx";
        System.out.println(rcs.replace(str, from, to));
    }

}
