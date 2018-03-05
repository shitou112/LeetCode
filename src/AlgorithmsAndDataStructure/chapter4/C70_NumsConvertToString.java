package AlgorithmsAndDataStructure.chapter4;

/**
 * @author Qian Shaofeng
 * created on 2018/3/5.
 */
public class C70_NumsConvertToString {

    public int num(String str){
        if (str == null || str == ""){
            return 0;
        }

        char[] chs = str.toCharArray();
        int cur = chs[chs.length-1] == '0'? 0: 1;
        int next = 1, tmp;
        for (int i=chs.length - 2; i >= 0; --i){
            if (chs[i] == '0'){
                next = cur;
                cur = 0;
            }
            else {
                tmp = cur;
                if ((chs[i] - '0') * 10 + chs[i + 1] - '0' < 27) {
                    cur += next;
                }
                next = cur;
            }

        }

        return cur;
    }
}
