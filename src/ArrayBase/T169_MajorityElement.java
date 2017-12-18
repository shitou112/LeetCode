package ArrayBase;

import java.util.HashMap;

/**
 * @author Qian Shaofeng
 * created on 2017/12/18.
 */
public class T169_MajorityElement {
    public int majorityElement(int[] nums) {
        if(nums==null || nums.length==0)
            return -1;

        HashMap<Integer, Integer> hashMap = new HashMap();
        int target = (nums.length >> 1) + 1;
        int value;
        for(int ele: nums){
            value = hashMap.getOrDefault(ele, 0)+1;
            if(value >= target)
                return ele;
            hashMap.put(ele, value);
        }

        return -1;
    }

    /**
     * leetcode solution
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        int count=0,candidate=0;

        for(int i=0;i<nums.length;i++){
            if(count==0){
                candidate = nums[i];
                count=1;
                continue;
            }else{
                if(candidate == nums[i]){
                    count++;
                }else{
                    count--;
                }
            }
        }

        if(count==0) return 0;

        count=0;
        for(int i=0;i<nums.length;i++){
            if(candidate==nums[i]){
                count++;
            }
        }

        return count>nums.length/2? candidate : 0;




    }

    public static void main(String[] args) {
        int[] nums = {6};
        T169_MajorityElement me = new T169_MajorityElement();
        System.out.println(me.majorityElement(nums));
    }
}
