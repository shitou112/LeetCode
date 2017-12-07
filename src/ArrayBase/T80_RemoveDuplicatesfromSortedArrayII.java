package ArrayBase;

/**
 * @author Qian Shaofeng
 * created on 2017/12/7.
 */
public class T80_RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums==null || nums.length==0)
            return 0;
        int counts=1, pre=nums[0], numberCount=1;
        for (int i=1; i < nums.length; ++i, ++numberCount){
            if (nums[i] != pre){
                pre = nums[counts++] = nums[i];
                numberCount=0;
            }
            else if (numberCount < 2) {
                nums[counts++] = nums[i];
            }
        }

        return counts;
    }

    public static void main(String[] args) {
        T80_RemoveDuplicatesfromSortedArrayII rds = new T80_RemoveDuplicatesfromSortedArrayII();
        int[] nums = {1,1,1,1,2,2,3,4};
        System.out.println(rds.removeDuplicates(nums));
        System.out.println();
    }
}
