package ArrayBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Qian Shaofeng
 * created on 2017/12/11.
 */
public class T90_SubsetsII {
    List<List<Integer>> resultList = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length==0) {
            resultList.add(new ArrayList<>());
            return resultList;
        }
        Arrays.sort(nums);
        recursion(nums, 0, new ArrayList<>());
        return resultList;
    }

    private void recursion(int[] nums, int index, List<Integer> list){
        resultList.add(new ArrayList<>(list));
        if (index >= nums.length)
            return;
        list.add(nums[index]);
        recursion(nums, index+1, list);
        list.remove(list.size()-1);

        for (int i=index+1; i < nums.length; ++i){
            if (nums[i] != nums[i-1]) {
                list.add(nums[i]);
                recursion(nums, i + 1, list);
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        T90_SubsetsII subsetsII = new T90_SubsetsII();
        int[] nums = {};
        System.out.println(subsetsII.subsetsWithDup(nums));
    }
}
