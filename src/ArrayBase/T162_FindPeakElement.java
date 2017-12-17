package ArrayBase;

/**
 * @author Qian Shaofeng
 * created on 2017/12/17.
 */
public class T162_FindPeakElement {
    public int findPeakElement(int[] nums) {
        if(nums==null || nums.length==0)
            return -1;
        int pre=Integer.MIN_VALUE;
        for(int i=1; i < nums.length-1; ++i){
            if(nums[i]>pre && nums[i]>nums[i+1])
                return i;
            pre = nums[i];
        }

        return nums.length-1;
    }
}
