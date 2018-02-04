package AlgorithmsAndDataStructure.chapter1;

import java.util.Stack;

/**
 * @author Qian Shaofeng
 * created on 2018/2/4.
 */
public class C9_MaxMatrixSize {

    int max=0;

    public int maxMatrixSize(int[][] matrix){
        if (matrix==null || matrix.length==0 || matrix[0].length==0)
            return 0;

        int[] nums = new int[matrix[0].length];

        Stack<Integer> stack = new Stack<>();
        int right, left;
        for (int i=0; i < matrix.length; ++i){
            for (int j=0; j < matrix[0].length; ++j){

                if (matrix[i][j] == 0) {
                    nums[j] = 0;
                }
                else {
                    ++nums[j];
                }

                area(nums, j, stack);
            }

            System.out.println(stack);
            while (!stack.isEmpty()){
                right = stack.pop();
                left = -1;
                if (!stack.isEmpty()){
                    left = stack.peek();
                }
                int areas = (matrix[0].length - left - 1) * nums[right];
                if (areas > max)
                    max = areas;

            }
            stack.clear();
        }

        return max;
    }

    private void area(int[] array, int index, Stack<Integer> stack){
        int areas = 0;
        while (!stack.isEmpty() && array[stack.peek()] >= array[index]){
            int value = stack.pop();
            int left = -1;
            if (!stack.isEmpty()){
                left = stack.peek();
            }
            int right = index;
            areas = (right - left - 1) * array[value];

            if (areas > max)
                max = areas;
        }

        stack.add(index);
    }

    public static void main(String[] args) {
        C9_MaxMatrixSize c9 = new C9_MaxMatrixSize();
        int[][] array = {
                {1, 0, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 0}
        };

        System.out.println(c9.maxMatrixSize(array));
    }
}
