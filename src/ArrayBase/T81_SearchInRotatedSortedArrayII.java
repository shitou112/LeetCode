package ArrayBase;

/**
 * @author Qian Shaofeng
 * created on 2017/12/9.
 */
public class T81_SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length==0)
            return false;
        return binSearch(nums, 0, nums.length-1, target);
    }

    private boolean binSearch(int[] nums, int start, int end, int target){
        if (start > end)
            return false;

        int mid = (start + end) / 2;
        if (nums[mid] == target)
            return true;
        else if (nums[mid] < nums[start]) {
            if (target > nums[mid] && target <= nums[end])
                return binSearch(nums, mid + 1, end, target);
            else
                return binSearch(nums, start, mid-1, target);
        }
        else if (nums[start] == nums[mid]){
            return linearSearch(nums, start, end, target);
        }
        else {
            if (target < nums[mid] && target >= nums[start])
                return binSearch(nums, start, mid-1, target);
            else
                return binSearch(nums, mid+1, end, target);
        }
    }

    private boolean linearSearch(int[] nums, int start, int end, int target){
        for (int i=start; i <= end; ++i){
            if (nums[i] == target)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        T81_SearchInRotatedSortedArrayII srsa = new T81_SearchInRotatedSortedArrayII();
        int[] nums = {3, 4, 0, 1, 1, 1, 1, 1, 1, 1, 2};
        System.out.println(srsa.search(nums, 5));
    }
}
