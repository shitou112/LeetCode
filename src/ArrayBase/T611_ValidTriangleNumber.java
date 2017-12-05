package ArrayBase;

import java.util.Arrays;

/**
 * @author Qian Shaofeng
 *         created on 2017/11/29.
 */
public class T611_ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        int counts = 0;
        Arrays.sort(nums);
        for (int i=0; i < nums.length-2; ++i){
            for (int j=i+1; j < nums.length-1; ++j){
                for (int k=j+1; k < nums.length; ++k){
                    if (isTriang(nums[i], nums[j], nums[k]))
                        ++counts;
                    else break;
                }
            }
        }
        return counts;
    }

    private boolean isTriang(int a, int b, int c){
        return a + b > c;
    }

    public static void main(String[] args) {
        T611_ValidTriangleNumber vtn = new T611_ValidTriangleNumber();
        int[] nums = {2, 2, 3, 4, 1, 7, 8};
        System.out.println(vtn.triangleNumber(nums));
    }
}
