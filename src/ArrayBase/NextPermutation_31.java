package ArrayBase;

/**
 * @author Qian Shaofeng
 *         created on 2017/11/30.
 */
public class NextPermutation_31 {
    public void nextPermutation(int[] nums) {
        int i=nums.length-1;
        for (;i > 0; --i) {
            if (nums[i] > nums[i-1])
                break;
        }
        int target = i-1;
        if (target >= 0){
            for (int j=nums.length-1; j > target; --j){
                if (nums[j] > nums[target]){
                    int tmp = nums[j];
                    nums[j] = nums[target];
                    nums[target] = tmp;
                    break;
                }
            }
        }
        for (int right=nums.length-1, left=target+1; right > left; --right,++left){
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }


    }

    public static void main(String[] args) {
        NextPermutation_31 np = new NextPermutation_31();
        int[] nums = {1,3,2};
        np.nextPermutation(nums);
        System.out.println(nums);
    }
}
