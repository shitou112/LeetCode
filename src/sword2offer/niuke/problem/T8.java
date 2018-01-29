package sword2offer.niuke.problem;

/**
 * @author Qian Shaofeng
 * created on 2018/1/27.
 */
public class T8 {
    public int JumpFloor(int target) {
        if (target==0)
            return 1;
        if (target==1)
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
}
