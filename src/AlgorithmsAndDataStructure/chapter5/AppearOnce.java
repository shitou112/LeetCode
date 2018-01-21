package AlgorithmsAndDataStructure.chapter5;

/**
 * @author Qian Shaofeng
 * created on 2018/1/21.
 */
public class AppearOnce {

    public char[] heapSort(char[] chs){
        for (int i=0; i < chs.length; ++i)
            constructHeapTree(chs, i);

        for (int i=chs.length-1; i >= 0; --i){
            swap(chs, 0, i);
            sink(chs, 0, i);
        }

        return chs;
    }

    public void constructHeapTree(char[] chs, int i){
        int parent = i / 2;
        while (chs[i] > chs[parent]){
            swap(chs, i, parent);
            i = parent;
            parent = i / 2;
        }
    }

    public void sink(char[] chs, int i, int index){
        int left = i*2 + 1;
        int right = i*2 + 2;
        int large = left;
        while (left < index){

            if (right < index && chs[left] < chs[right])
                large = right;

            if (chs[i] < chs[large]){
                swap(chs, i, large);
            }
            else
                break;

            i = large;
            left = 2*i + 1;
            right = 2*i + 2;
            large = left;

        }
    }

    public void swap(char[] chs, int i, int j){
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }

    public static void main(String[] args) {
        AppearOnce ao = new AppearOnce();
        char[] chs = {'7', '3', '2', '5', '4', '1', '6'};
        System.out.println(ao.heapSort(chs));
    }
}
