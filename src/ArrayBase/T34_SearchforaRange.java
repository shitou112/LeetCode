package ArrayBase;

/**
 * @author Qian Shaofeng
 *         created on 2017/11/30.
 */
public class T34_SearchforaRange {
    int startIndex=-1, endIndex=-1;
    public int[] searchRange(int[] nums, int target) {
        if (nums.length != 0)
            binSearch(nums, 0, nums.length-1, target);
        int[] result = new int[2];
        result[0] = startIndex;
        result[1] = endIndex;
        return result;
    }

    private void binSearch(int[] nums, int start, int end, int target){
        if (start >= end){
            if (nums[start] == target)
                updateRange(start);
            return;
        }

        int mid = (start + end) / 2;
        if (nums[mid] < target){
            binSearch(nums, mid+1, end, target);
        }else if (nums[mid] > target){
            binSearch(nums, start, mid-1, target);
        }else {
            binSearch(nums, start, mid-1, target);
            binSearch(nums, mid+1, end, target);
            updateRange(mid);
        }
    }

    private void updateRange(int index){
        if (startIndex==-1 || startIndex > index ){
            startIndex = index;
        }

        if (endIndex==-1 || endIndex < index){
            endIndex = index;
        }
    }

    public static void main(String[] args) {
        T34_SearchforaRange sr = new T34_SearchforaRange();
        int[] nums = {};
        int[] result = sr.searchRange(nums, 8);
        System.out.println(result);
    }
}
