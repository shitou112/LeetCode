package AlgorithmsAndDataStructure.chapter5;

/**
 * @author Qian Shaofeng
 * created on 2018/3/6.
 */
public class C86_StringReverse {

    public String reverse(String str){
        if (str==null || str.length()==0)
            return str;

        char[] chs = str.toCharArray();
        reverse(chs, 0, chs.length-1);
        int left = -1, right = -1;
        for (int i=0; i < chs.length; ++i){
            if (chs[i] != ' '){
                left = left==-1? i: left;
                right = i;
            }
            else {
                reverse(chs, left, right);
                left = -1;
                right = -1;
            }
        }

        if (left != -1){
            reverse(chs, left, right);
        }

        return String.valueOf(chs);
    }

    public void reverse(char[] chs, int start, int end){
        while (start < end){
            exchange(chs, start++, end--);
        }
    }

    public void exchange(char[] chs, int i, int j){
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }

    public static void main(String[] args) {
        C86_StringReverse stringReverse = new C86_StringReverse();
        System.out.println(stringReverse.reverse("dog loves pig."));
    }
}
