package AlgorithmsAndDataStructure.chapter9;

/**
 * @author Qian Shaofeng
 * created on 2018/1/28.
 */
public class DistributeSuger {

    int res = 0;

    public int distributeSuger(int[] array){
        if (array==null || array.length==0)
            return 0;

        int i=0;
        int[] val;
        int pre = 1;

        while (i < array.length){
            val  = upSlope(array, i, pre);
            int up = val[0];
            int index = val[1];

            val = downSlope(array, index, pre);

            int down = val[0];
            index = val[1];
            res -= Math.min(up, down);


            System.out.println("up down: "+up+" "+down);

            i = index;
            if (index < array.length && array[index]>array[index-1]){
                pre = 2;
            }
            else pre = 1;
        }

        return res;
    }

    private int[] upSlope(int[] array, int index, int pre){
        int i=index;
        res += pre;
        for (; i < array.length-1; ++i){
            if (array[i] < array[i+1]) {
                ++pre;
                res += pre;
            }else {
                break;
            }
        }

        return new int[]{pre, i};
    }

    public int[] downSlope(int[] array, int index, int pre){
        int i = index;

        res += pre;
        for (; i < array.length-1; ++i){
            if (array[i] > array[i+1]){
                ++pre;
                res += pre;
            }
            else {
                break;
            }
        }

        return new int[]{pre, i+1};
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 5, 4, 3};
        System.out.println(new DistributeSuger().distributeSuger(array));
    }
}
