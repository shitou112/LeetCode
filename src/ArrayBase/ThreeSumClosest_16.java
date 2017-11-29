package ArrayBase;

import java.util.Arrays;

/**
 * @author Qian Shaofeng
 *         created on 2017/11/29.
 */
public class ThreeSumClosest_16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int bestNum = Integer.MAX_VALUE;
        int closestValue = Integer.MAX_VALUE;
        for (int i=2; i < nums.length; ++i){
            int left=0, right = i-1;
            while (left < right){
                int value = nums[left] + nums[right] + nums[i] - target;
                if (Math.abs(value) < bestNum) {
                    bestNum = Math.abs(value);
                    closestValue = nums[left] + nums[right] + nums[i];
                    System.out.println(nums[left]+" "+nums[right]+" "+nums[i]);
                }

                if (value > 0){
                    --right;
                }
                else {
                    ++left;
                }
            }
        }
        return closestValue;
    }

    public static void main(String[] args) {
        ThreeSumClosest_16 tsc = new ThreeSumClosest_16();
        int[] nums = {1,2,4,8,16,32,64,128};
        int target = 82;
        System.out.println(tsc.threeSumClosest(nums, target));
    }
}
