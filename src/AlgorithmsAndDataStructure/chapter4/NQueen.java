package AlgorithmsAndDataStructure.chapter4;

/**
 * @author Qian Shaofeng
 * created on 2018/1/18.
 */
public class NQueen {

    public int process(int n){
        if (n==0)
            return 0;

        int[] array = new int[n];
        return findCol(array, 0);
    }

    private int findCol(int[] array, int index){
        if (index==array.length)
            return 1;

        int res = 0;
        for (int i=0; i < array.length; ++i){
            if (isValid(array, index-1, index, i)){
                array[index] = i;
                res += findCol(array, index+1);
            }
        }

        return res;
    }

    private boolean isValid(int[] array, int len, int row, int col){
        for (int i=0; i <= len; ++i){
            if (col == array[i])
                return false;
            if (Math.abs(row-i) == Math.abs(col-array[i]))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        NQueen nQueen = new NQueen();
        long start = System.currentTimeMillis();
        System.out.println(nQueen.process(15));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
