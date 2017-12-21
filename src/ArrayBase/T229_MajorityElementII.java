package ArrayBase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Qian Shaofeng
 * created on 2017/12/21.
 */
public class T229_MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> results = new ArrayList<>();
        if(nums==null || nums.length==0)
            return results;
        int fNum = nums[0], sNum = nums[0];
        int fCount = 1, sCount = 1;
        for(int i=1; i < nums.length; ++i){
            if(nums[i] == fNum)
                ++fCount;
            else if(nums[i] == sNum)
                ++sCount;
            else if(fCount==0){
                fNum = nums[i];
                fCount = 1;
            }
            else if(sCount==0){
                sNum = nums[i];
                sCount = 1;
            }
            else{
                --fCount;
                --sCount;
            }
        }

        fCount = sCount = 0;
        for(int i=0; i < nums.length; ++i){
            if(nums[i] == fNum)
                ++fCount;
            else if(nums[i] == sNum)
                ++sCount;
        }
        if(fCount > nums.length / 3)
            results.add(fNum);
        if(sCount > nums.length / 3)
            results.add(sNum);

        return results;
    }
}
