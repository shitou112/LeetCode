package ArrayBase;

/**
 * @author Qian Shaofeng
 * created on 2017/12/8.
 */
public class T59_SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        recursion(matrix, 0, n-1, 0, n-1, 1);
        return matrix;
    }

    private void recursion(int[][] matrix, int startRow, int endRow, int startCol, int endCol, int num){
        if (startRow > endRow)
            return;

        if (startRow == endRow){
            for (int i=startCol; i <= endCol; ++i)
                matrix[startRow][i] = num++;
            return;
        }

        for (int i=startCol; i <= endCol; ++i)
            matrix[startRow][i] = num++;

        for (int i=startRow+1; i <= endRow; ++i)
            matrix[i][endCol] = num++;

        for (int i=endCol-1; i >= startCol; --i)
            matrix[endRow][i] = num++;

        for (int i=endRow-1; i>startRow; --i)
            matrix[i][startCol] = num++;

        recursion(matrix, startRow+1, endRow-1, startCol+1, endCol-1, num);
    }

    public static void main(String[] args) {
        T59_SpiralMatrixII sm = new T59_SpiralMatrixII();
        int[][] matrix = sm.generateMatrix(0);
        System.out.println();
    }
}
