package AlgorithmsAndDataStructure.chapter4;

/**
 * @author Qian Shaofeng
 * created on 2018/1/18.
 */
public class Digit2CharacterCombination {

    public int num1(String str){
        if (str==null)
            return 0;

        char[] chs = str.toCharArray();

        return combination(chs, 0);
    }

    private int combination(char[] chs, int start){
        if (start >= chs.length){
            return 1;
        }
        if (chs[start] == '0')
            return 0;

        int res = combination(chs, start+1);

        if (start+1 < chs.length && (chs[start] - '0')*10+(chs[start+1] - '0') <= 26)
            res += combination(chs, start+2);

        return res;
    }


    public int num2(String str){
        return 0;
    }

    public static void main(String[] args) {
        Digit2CharacterCombination d = new Digit2CharacterCombination();
        System.out.println(d.num1("1111"));
    }
}
