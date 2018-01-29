package sword2offer.niuke.problem;

/**
 * @author Qian Shaofeng
 * created on 2018/1/29.
 */
public class T11 {

    public int NumberOf1(int n) {

        String str = Integer.toBinaryString(n);
        int res = 0;
        for (int i=0; i < str.length(); ++i){
            if (str.charAt(i)=='1')
                ++res;
        }

        return res;
    }

    public int bestSolution(int n){
        int res = 0;
        while (n!=0){
            ++res;
            n = n&(n-1);
        }

        return res;
    }

    public static void main(String[] args) {
        T11 t11 = new T11();
        System.out.println(t11.bestSolution(-1));
    }
}
