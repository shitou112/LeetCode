package sword2offer.niuke.problem;

/**
 * @author Qian Shaofeng
 * created on 2018/1/29.
 */
public class T9 {

    public int JumpFloorII(int target) {
        if(target <= 0)
            return 0;

        return (int) Math.pow(2, target-1);
    }

    public static void main(String[] args) {
        T9 t9 = new T9();
        System.out.println(t9.JumpFloorII(2));
    }
}
