package ArrayBase;

/**
 * @author Qian Shaofeng
 * created on 2017/12/17.
 */
public class T153_FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        if(nums==null || nums.length==0)
            return -1;
        int result;
        int value = binSearch(nums, 0, nums.length-1);
        result = value==-1? nums[0]: nums[value];
        return result;

    }

    private int binSearch(int[] nums, int start, int end){
        if(start >= end){
            return -1;
        }

        int mid = (start + end) >> 1;
        if(mid+1<= end && nums[mid] > nums[mid+1])
            return mid+1;
        else if(nums[mid] > nums[start])
            return binSearch(nums, mid, end);
        else
            return binSearch(nums, start, mid);
    }

    /**
     * best solution
     * The minimum element must satisfy one of two conditions:
     * 1) If rotate, A[min] < A[min - 1];
     * 2) If not, A[0].
     * Therefore, we can use binary search: check the middle element,
     * if it is less than previous one, then it is minimum.
     * If not, there are 2 conditions as well:
     * If it is greater than both left and right element,
     * then minimum element should be on its right, otherwise on its left
     *
     * @param num
     */
    public int findMin2(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        if (num.length == 1) {
            return num[0];
        }
        int start = 0, end = num.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (mid > 0 && num[mid] < num[mid - 1]) {
                return num[mid];
            }
            if (num[start] <= num[mid] && num[mid] > num[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return num[start];
    }

    public static void main(String[] args) {
        T153_FindMinimuminRotatedSortedArray fmrsa = new T153_FindMinimuminRotatedSortedArray();
        int[] nums = {1,2,3,4,5,6,7,-1};
        System.out.println(fmrsa.findMin(nums));
    }
}
