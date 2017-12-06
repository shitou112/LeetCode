package ArrayBase;

/**
 * @author Qian Shaofeng
 *         created on 2017/12/6.
 */
public class T75_SortColors {
    public void sortColors(int[] nums) {
        if (nums.length == 0)
            return;
        quickSort(nums, 0, nums.length-1);
    }

    private void quickSort(int[] nums, int start, int end){
        if (start > end)
            return;
        int p = partition(nums, start, end);
        quickSort(nums, start, p-1);
        quickSort(nums, p+1, end);
    }

    private int partition(int[] nums, int start, int end){
        int value = nums[start], tmp;
        int i=0, j=1;
        for (;j <= end; ++j){
            if (nums[j] <= value) {
                ++i;
                tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
            }
        }
        tmp = value;
        nums[start] = nums[i];
        nums[i] = tmp;
        return i;
    }

    public static void main(String[] args) {
        T75_SortColors sc = new T75_SortColors();
        int[] nums = {2, 0, 1};
        sc.sortColors(nums);
        System.out.println();
    }
}
