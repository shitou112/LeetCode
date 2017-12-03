package ArrayBase;

/**
 * @author Qian Shaofeng
 *         created on 2017/12/3.
 */
public class JumpGameII_45 {
    int depth = Integer.MAX_VALUE;

    /**
     * 1. backtracking, time limit exceeded
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        dfs(nums, 0, 0);
        return depth;
    }

    private void dfs(int[] nums, int start, int depths){
        if (start >= nums.length-1){
            if (this.depth > depths)
                this.depth = depths;
            return;
        }

        int maxStep = nums[start];
        for (int i=maxStep; i > 0; --i){
            dfs(nums, start + i, depths+1);
        }

        return;
    }

    /**
     * O(n)
     *
     * @param nums
     * @return
     */
    public int leetCodeProposeJump(int[] nums) {
        int times = 0;
        int reached = 0;
        int max = 0;
        for(int i=0;i< nums.length;i++){
            if(reached < i){
                times++;
                reached = max;
            }
            max = Math.max(max,i+nums[i]);
        }
        return times;
    }

    /**
     * less than O(n)
     *
     * @param nums
     * @return
     */
    public int jump2(int[] nums){
        int depths=0, stepIndex=0;
        while (stepIndex < nums.length-1){
            int max = 0, maxIndex=0;
            int maxStep = stepIndex + nums[stepIndex];
            for (int i=stepIndex+1;i <= maxStep; ++i){
                if (i >= nums.length-1)
                    return ++depths;
                int value = nums[i] + i;
                if (max < value) {
                    max = value;
                    maxIndex = i;
                }
            }
            ++depths;
            stepIndex = maxIndex;
        }
        return depths;
    }
    public static void main(String[] args) {
        JumpGameII_45 jg = new JumpGameII_45();
        int[] nums = {1,1};
        System.out.println(jg.jump2(nums));
    }
}
