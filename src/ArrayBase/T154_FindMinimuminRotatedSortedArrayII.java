package ArrayBase;

/**
 * @author Qian Shaofeng
 * created on 2017/12/17.
 */
public class T154_FindMinimuminRotatedSortedArrayII {
    public int findMin(int[] nums) {
        if(nums==null || nums.length==0)
            return -1;
        return nums[binSearch(nums, 0, nums.length-1)];
    }

    private int binSearch(int[] nums, int start, int end){
        if(start > end)
            return start;
        int mid = (start + end) >> 1;
        if(mid > 0 && nums[mid-1] > nums[mid])
            return mid;
        else if(nums[mid]==nums[start]){
            return linearSearch(nums, start, end);
        }
        else if(nums[mid] > nums[start] && nums[mid] > nums[end])
            return binSearch(nums, mid+1, end);
        else
            return binSearch(nums, start, mid-1);
    }

    private int linearSearch(int[] nums, int start, int end){
        for(int i=start+1; i <= end; ++i){
            if(nums[i]<nums[i-1])
                return i;
        }
        return start;
    }

    /**
     * leetcode solution
     * @param nums
     * @return
     */
    public int findMin2(int[] nums) {
        int l=0,r=nums.length-1;
        while(l<r){
            int mid=(l+r)>>>1;
            if(nums[mid]>nums[r]){
                l=mid+1;
            }else if(nums[mid]<nums[r]){
                r=mid;
            }else{
                r--;
            }
        }
        return nums[l];
    }
    public static void main(String[] args) {
        T154_FindMinimuminRotatedSortedArrayII fmrsa = new T154_FindMinimuminRotatedSortedArrayII();
        int[] nums = {1};
        System.out.println(fmrsa.findMin(nums));
    }
}
