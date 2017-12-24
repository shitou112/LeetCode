package ArrayBase;

import java.util.Arrays;

/**
 * @author Qian Shaofeng
 * created on 2017/12/24.
 */
public class T287_FindtheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        if(nums==null || nums.length==0)
            return -1;
        Arrays.sort(nums);
        for(int i=0; i < nums.length-1; ++i){
            if(nums[i]==nums[i+1])
                return nums[i];
        }
        return -1;
    }
}
