package AlgorithmsAndDataStructure.ext;

import AlgorithmsAndDataStructure.utils.TreeNode;

/**
 * @author Qian Shaofeng
 * created on 2018/3/5.
 */
public class HeapSort {

    private void sink(int[] array, int pos, int end){
        int left = 2 * pos;
        int right = left + 1;
        int large = pos;
        if (left < end && array[left] > array[pos]){
            large = left;
        }
        if (right < end && array[right] > array[large]){
            large = right;
        }

        if (large != pos){
            exchange(array, pos, large);
            sink(array, large, end);
        }
    }

    private void exchange(int[] array, int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private void generateHeap(int[] array){
        for (int i=array.length/2; i >= 0; --i){
            sink(array, i, array.length);
        }
    }

    public void sort(int[] array){
        if (array == null && array.length == 0)
            return;

        generateHeap(array);
        for (int i=array.length-1; i >= 0; --i){
            System.out.println(array[0]);
            exchange(array, i, 0);
            sink(array, 0, i);
        }
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] array = {3, 4, 1, 2, 5};
        heapSort.sort(array);
        System.out.println(array);
    }
}
