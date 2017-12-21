package ArrayBase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Qian Shaofeng
 * created on 2017/12/21.
 */
public class T228_SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> results = new ArrayList<>();
        if(nums==null || nums.length==0)
            return results;
        for(int i=0; i < nums.length; ++i){
            i = summaryRanges(nums, i, results);
        }

        return results;
    }

    private int summaryRanges(int[] nums, int start, List<String> results){
        int left = start, right=start;
        for(; right < nums.length-1; ++right){
            if(nums[right+1]-nums[right] != 1){
                break;
            }
        }
        if(left == right)
            results.add(new String(nums[left]+""));
        else{
            results.add(new String(nums[left]+"->"+nums[right]));
        }

        return right;
    }

    public static void main(String[] args) {
        T228_SummaryRanges sr = new T228_SummaryRanges();
        int[] nums = {0};
        System.out.println(sr.summaryRanges(nums));
    }
}
