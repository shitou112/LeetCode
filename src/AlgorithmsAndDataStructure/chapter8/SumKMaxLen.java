package AlgorithmsAndDataStructure.chapter8;

import java.util.Arrays;

/**
 * @author Qian Shaofeng
 * created on 2018/1/25.
 */
public class SumKMaxLen {

    int maxResult;

    public int maxLen(int[] array, int target){
        if (array==null)
            return 0;

        Arrays.sort(array);
        maxLen(array, 0, target, 0);
        return maxResult;
    }

    private void maxLen(int[] array, int index, int target, int depth){
        if (target==0){
            maxResult = maxResult<depth? depth: maxResult;
            return;
        }
        else if (target<0){
            return;
        }

        for (int i=index; i<array.length; ++i){
            maxLen(array, i+1, target-array[i], depth+1);
        }
    }

    public static void main(String[] args) {
        SumKMaxLen s = new SumKMaxLen();
        int[] array = {1,2,1,1,1};
        System.out.println(s.maxLen(array, 5));
    }
}
