package ArrayBase;

/**
 * @author Qian Shaofeng
 * created on 2017/12/19.
 */
public class T209_MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums==null || nums.length==0)
            return 0;

        int min = Integer.MAX_VALUE;
        for(int i=0; i < nums.length; ++i){
            int sum = 0;
            for(int j=i; j < nums.length; ++j){
                sum += nums[j];
                if(sum >= s){
                    if(min > (j-i+1)){
                        min = j - i + 1;
                    }
                    break;
                }
            }
        }
        min = min==Integer.MAX_VALUE? 0: min;
        return min;

    }

    public int minSubArrayLen2(int s, int[] nums) {
        if(nums==null || nums.length==0)
            return 0;

        int sum = 0, min=Integer.MAX_VALUE;
        int left=0,right=0;
        for (int i=0; i < nums.length; ++i){
            sum += nums[i];
            right = i;
            if (sum >= s){

                while (sum>=s) {
                    sum -= nums[left];
                    ++left;
                }
                if (min > right - left +2)
                    min = right - left + 2;
            }
        }

        min = min==Integer.MAX_VALUE? 0: min;
        return min;

    }

    public static void main(String[] args) {
        T209_MinimumSizeSubarraySum mss = new T209_MinimumSizeSubarraySum();
        int[] nums = {2,3,1,2,4,3};
        System.out.println(mss.minSubArrayLen2(6, nums));
    }
}
