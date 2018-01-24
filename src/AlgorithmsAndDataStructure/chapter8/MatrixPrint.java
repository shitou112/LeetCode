package AlgorithmsAndDataStructure.chapter8;

/**
 * @author Qian Shaofeng
 * created on 2018/1/24.
 */
public class MatrixPrint {

    public void print(int[][] matrix){
        if (matrix==null || matrix[0]==null)
            return;

        int tr = 0;
        int tc = 0;
        int dr = 0;
        int dc = 0;
        boolean l2r = true;
        int endr = matrix.length - 1;
        int endc = matrix[0].length -1;
        while (tr<=endr){
            print(matrix, tr, tc, dr, dc, l2r);
            tr = tc == endc? tr+1: tr;
            tc = tc == endc? tc: tc+1;
            dc = dr == endr? dc+1: dc;
            dr = dr == endr? dr: dr+1;
            l2r = !l2r;
        }
    }

    private void print(int[][] matrix, int tr, int tc, int dr, int dc, boolean l2r){
        if (l2r){
            while (dc <= tc){
                System.out.print(matrix[dr--][dc++]+" ");
            }
        }
        else {
            while (tr <= dr){
                System.out.print(matrix[tr++][tc--]+" ");
            }
        }
    }

    public static void main(String[] args) {
        MatrixPrint mp = new MatrixPrint();
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10 ,11, 12}
        };
        mp.print(matrix);
    }
}
