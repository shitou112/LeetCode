package ArrayBase;

/**
 * @author Qian Shaofeng
 * created on 2017/12/18.
 */
public class T167_TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        if(numbers == null||numbers.length==0)
            return result;

        int left = 0, right = numbers.length-1;
        while(left < right){
            int value = numbers[left] + numbers[right];
            if (value == target){
                result[0] = left+1;
                result[1] = right+1;
                return result;
            }
            else if(value < target){
                ++left;
            }
            else{
                --right;
            }
        }
        return result;
    }
}
