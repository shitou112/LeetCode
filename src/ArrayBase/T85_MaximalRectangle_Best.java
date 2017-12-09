package ArrayBase;

/**
 * @author Qian Shaofeng
 * created on 2017/12/9.
 */
public class T85_MaximalRectangle_Best {
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return 0;
        int m = matrix.length, n = matrix[0].length;

        //最后一位永为0，保障退栈
        int[] heights = new int[n+1];
        int res = 0;
        for(int row=0; row<m; row++) {
            updateHeights(matrix, row, heights);
            res = Math.max(res, maxArea(heights));
        }
        return res;
    }

    private void updateHeights(char[][] matrix, int row, int[] heights) {
        for(int col=0; col<matrix[0].length; col++) {
            if(matrix[row][col]=='1') {
                heights[col]++;
            } else {
                heights[col] = 0;
            }
        }
    }
    private int maxArea(int[] heights) {
        int n = heights.length;
        int[] stack = new int[n+1];
        int top = 0;
        stack[top] = -1;
        int res = 0;
        for(int i=0; i<n; i++) {
            while(top>0 && heights[i]<heights[stack[top]]) {
                int h = heights[stack[top--]];
                res = Math.max(res, h*(i-stack[top]-1));
            }
            stack[++top] = i;
        }
        return res;
    }

    public static void main(String[] args) {
        T85_MaximalRectangle_Best mr = new T85_MaximalRectangle_Best();
        char[][] matrix = {
                {'0', '1', '1', '1'},
                {'1', '1', '0', '1'},
                {'0', '0', '0', '1'},
                {'0', '0', '0', '1'}

        };

        int[] height = {1,5,6,4, 0};
        System.out.println(mr.maxArea(height));
//        System.out.println(mr.maximalRectangle(matrix));
    }
}
