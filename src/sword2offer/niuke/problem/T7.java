package sword2offer.niuke.problem;

/**
 * @author Qian Shaofeng
 * created on 2018/1/27.
 */
public class T7 {
    public int Fibonacci(int n) {
        if (n==0)
            return 0;
        if (n==1 || n==2)
            return 1;

        int prepre = 1;
        int pre = 1;
        int res = 0;
        for (int i=3; i <= n; ++i){
            res = prepre + pre;
            prepre = pre;
            pre = res;
        }

        return res;
    }

    public static void main(String[] args) {
        T7 t7 = new T7();
        System.out.println(t7.Fibonacci(9));
    }
}
