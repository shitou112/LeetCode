package ArrayBase;

import java.util.*;

/**
 * @author Qian Shaofeng
 *         created on 2017/11/29.
 */
public class T18_FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Map<String, Boolean> visited = new HashMap<>();
        StringBuilder sb;
        Arrays.sort(nums);

        for (int i=0; i < nums.length - 3; ++i){
            for (int j=i+1; j < nums.length-2; ++j){
                int left = j + 1, right = nums.length-1;
                while(left < right){
                    int value = nums[i] + nums[j] + nums[left] + nums[right];
                    if (value < target){
                        ++left;
                    }else if (value > target){
                        --right;
                    }else {
                        sb = new StringBuilder();
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        sb.append(nums[i]).append(nums[j]).append(nums[left]).append(nums[right]);
                        if (!visited.getOrDefault(sb.toString(), false)) {
                            visited.put(sb.toString(), true);
                            result.add(list);
                        }

                        --right;
                        ++left;
                    }
                }
            }
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        T18_FourSum fs = new T18_FourSum();
        int[] nums = {-3,-2,-1,0,0,1,2,3};
        List<List<Integer>> a = fs.fourSum(nums, 0);
    }
}
