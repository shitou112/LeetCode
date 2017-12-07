package ArrayBase;

/**
 * @author Qian Shaofeng
 * created on 2017/12/7.
 */
public class T26_RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length==0)
            return 0;

        int counts = 1, pre=nums[0];
        for (int i=1; i < nums.length; ++i){
            if (nums[i] != pre){
                pre = nums[counts++] = nums[i];
            }
        }

        return counts;
    }

    public static void main(String[] args) {
        T26_RemoveDuplicatesfromSortedArray rds = new T26_RemoveDuplicatesfromSortedArray();
        int[] nums = {1,1,2,3,3,5};
        System.out.println(rds.removeDuplicates(nums));
    }
}
