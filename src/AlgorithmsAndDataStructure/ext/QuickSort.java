package AlgorithmsAndDataStructure.ext;

/**
 * @author Qian Shaofeng
 * created on 2018/3/5.
 */
public class QuickSort {

    public void sort(int[] array){
        if (array==null || array.length==0)
            return;

        quickSort(array, 0, array.length-1);

    }

    public void quickSort(int[] array, int start, int end){
        if (start >= end)
            return;

        int pos = partition(array, start, end);
        quickSort(array, start, pos-1);
        quickSort(array, pos+1, end);
    }

    public int partition(int[] array, int start, int end){

        int value = array[end];
        int i=start-1;
        int j=start;
        for (;j < end; ++j){
            if (array[j] < value){
                ++i;
                exchange(array, i, j);
            }
        }

        ++i;
        exchange(array, i, end);
        return i;
    }

    public void exchange(int[] array, int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] array = {5, 3, 1, 2, 4};
        quickSort.sort(array);
        System.out.println(array);
    }
}
