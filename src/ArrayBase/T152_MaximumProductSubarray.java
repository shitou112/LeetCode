package ArrayBase;

/**
 * @author Qian Shaofeng
 * created on 2017/12/15.
 */
public class T152_MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;

        int max=nums[0], min=nums[0], result=nums[0];
        for(int i=1; i < nums.length; ++i){
            int temp = max;
            max = Math.max(Math.max(max*nums[i], min*nums[i]), nums[i]);
            min = Math.min(Math.min(min*nums[i], temp*nums[i]), nums[i]);
            if(result < max)
                result = max;
        }

        return result;
    }
}
