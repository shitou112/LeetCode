package ArrayBase;

import java.util.Stack;

/**
 * @author Qian Shaofeng
 *         created on 2017/12/3.
 */
public class T42_TrappingRainWater {
    /**
     * 1. stack 弹栈计算雨水存储量
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (int i=0; i < height.length; ++i){
            if (stack.isEmpty() || height[stack.peek()] > height[i]){
                stack.push(i);
            }
            else {
                while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                    int pre = stack.pop();
                    if (!stack.isEmpty()) {
                        sum += (i - 1 - stack.peek()) * (Math.min(height[stack.peek()], height[i]) - height[pre]);
                        System.out.println(pre+ " "+i+" "+sum);
                    }
                }
                stack.push(i);
            }
        }

        return sum;
    }

    /**
     * 2. two point
     *
     * @param height
     * @return
     */
    public int trap2(int[] height){
        int left=0, right=height.length-1;
        int sum = 0;
        while (left < right && height[left] < height[left+1]) ++left;
        while (left < right && height[right-1] > height[right]) --right;
        while (left < right){
            int leftMax = height[left];
            int rightMax = height[right];
            if (leftMax < rightMax) {
                while (left < right && height[++left] < leftMax) {
                    sum += leftMax - height[left];
                }
            }
            else {
                while (left < right && height[--right] < rightMax){
                    sum += rightMax - height[right];
                }
            }

        }
        return sum;
    }

    public static void main(String[] args) {
        T42_TrappingRainWater trw = new T42_TrappingRainWater();
        int[] height = {1,2,3,4,2,1,3,4};
        System.out.println(trw.trap2(height));
    }
}
