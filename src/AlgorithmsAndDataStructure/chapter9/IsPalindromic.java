package AlgorithmsAndDataStructure.chapter9;

/**
 * @author Qian Shaofeng
 * created on 2018/1/28.
 */
public class IsPalindromic {

    public boolean isPalindromic(String str){
        if (str==null || str.length()==0)
            return false;

        char[] chs = str.toCharArray();
        boolean negFlag = chs[0]=='-';

        int left = negFlag? 1: 0;
        int right = chs.length-1;
        while (left < right){
            if (chs[left++] != chs[right--])
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        IsPalindromic p = new IsPalindromic();
        System.out.println(p.isPalindromic("12321"));
    }
}
