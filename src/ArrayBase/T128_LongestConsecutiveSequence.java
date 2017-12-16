package ArrayBase;

import java.util.HashSet;

/**
 * @author Qian Shaofeng
 * created on 2017/12/15.
 */
public class T128_LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;

        int res=0;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i=0; i < nums.length; ++i){
            hashSet.add(nums[i]);
        }
        for (int ele: nums){
            hashSet.remove(ele);
            int pre = ele, next = ele;
            while (hashSet.remove(pre-1)) --pre;
            while (hashSet.remove(next+1)) ++next;
            res = Math.max(res, next-pre+1);
        }
        return res;
    }

    public static void main(String[] args) {
        T128_LongestConsecutiveSequence lss = new T128_LongestConsecutiveSequence();
        int[] nums = {100,4,200,1,3,2};
        System.out.println(lss.longestConsecutive(nums));
    }
}
