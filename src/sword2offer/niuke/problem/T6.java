package sword2offer.niuke.problem;

/**
 * @author Qian Shaofeng
 * created on 2018/1/27.
 */
public class T6 {
    public int minNumberInRotateArray(int [] array) {
        if (array==null || array.length==0)
            return 0;

        int pre = array[0];
        for (int i=1; i < array.length; ++i){
            if (pre > array[i])
                return array[i];

            pre= array[i];
        }

        return array[0];
    }
}
