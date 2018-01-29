package sword2offer.niuke.problem;

/**
 * @author Qian Shaofeng
 * created on 2018/1/29.
 */
public class T10 {
    public int RectCover(int target) {
        if (target==0)
            return 0;
        else if (target==1)
            return 1;

        int prepre = 1;
        int pre = 1;
        int res = 0;
        for (int i=2; i <= target; ++i){
            res = prepre + pre;
            prepre = pre;
            pre = res;
        }

        return res;

    }

    public static void main(String[] args) {
        T10 t10 = new T10();
        System.out.println(t10.RectCover(3));
    }
}
