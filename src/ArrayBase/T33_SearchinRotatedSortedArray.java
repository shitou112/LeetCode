package ArrayBase;

/**
 * @author Qian Shaofeng
 *         created on 2017/11/30.
 */
public class T33_SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums.length==0)
            return -1;
        return recursion(nums, 0, nums.length-1, target);
    }

    public int recursion(int[] nums, int start, int end, int target){
        if (start >= end){
            if (nums[start] == target)
                return start;
            else
                return -1;
        }
        int mid = (start+end) / 2;
        if (target == nums[mid])
            return mid;

        if (nums[mid] >= nums[start]) {
            if (target < nums[mid] && target >= nums[start])
                return recursion(nums, start, mid-1, target);
            else
                return recursion(nums, mid+1, end, target);
        }
        if (nums[mid] <= nums[end]){
            if (target > nums[mid] && target <= nums[end])
                return recursion(nums, mid+1, end, target);
            else
                return recursion(nums, start, mid-1, target);
        }
        return -1;
    }

    public int test(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return mid;

            if (nums[start] <= nums[mid]){
                if (target < nums[mid] && target >= nums[start])
                    end = mid - 1;
                else
                    start = mid + 1;
            }

            if (nums[mid] <= nums[end]){
                if (target > nums[mid] && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        T33_SearchinRotatedSortedArray sr = new T33_SearchinRotatedSortedArray();
        int[] nums = {3,1};
        int target = 1;
        System.out.println(sr.search(nums, target));
    }
}
