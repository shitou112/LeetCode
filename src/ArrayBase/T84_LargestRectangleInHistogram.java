package ArrayBase;

import java.util.Stack;

/**
 * @author Qian Shaofeng
 * created on 2017/12/9.
 */
public class T84_LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length==0)
            return 0;
        int n = heights.length;
        int[] leftIndex = new int[n];
        int[] rightIndex = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i < n; ++i){
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i])
                stack.push(i);
            else {
                while (!stack.isEmpty() && heights[stack.peek()]>heights[i]){
                    int index = stack.pop();
                    rightIndex[index] = i;
                }
                stack.push(i);
            }
        }

        while (!stack.isEmpty())
            rightIndex[stack.pop()] = n;

        //对于左端数组不需要就行最后的循环赋0，因为leftIndex默认初始化的值已经为0
        for (int i=n-1; i >= 0; --i){
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i])
                stack.push(i);
            else {
                while (!stack.isEmpty() && heights[stack.peek()]>heights[i]){
                    int index = stack.pop();
                    leftIndex[index] = i+1;
                }
                stack.push(i);
            }
        }


        int max = 0;
        for (int i=0; i < n; ++i){
            int value = (rightIndex[i] - leftIndex[i]) * heights[i];
            if (value > max) {
                max = value;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        T84_LargestRectangleInHistogram lrh = new T84_LargestRectangleInHistogram();
        int[] height = {2, 3,4,5,6,7,8,6,5,5,5};
        System.out.println(lrh.largestRectangleArea(height));
    }
}
