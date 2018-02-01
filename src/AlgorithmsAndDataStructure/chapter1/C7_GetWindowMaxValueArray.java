package AlgorithmsAndDataStructure.chapter1;

import java.util.LinkedList;

/**
 * @author Qian Shaofeng
 * created on 2018/2/1.
 */
public class C7_GetWindowMaxValueArray {

    public int[] getWindowArray(int[] array, int w){
        if (array==null || array.length < w)
            return null;

        int n = array.length - w + 1;
        int[] res = new int[n];

        LinkedList<Integer> queue = new LinkedList<>();
        int index = 0;
        for (int i=0; i < array.length; ++i){
            while (!queue.isEmpty() && array[queue.peekLast()] <= array[i]){
                queue.pollLast();
            }
            queue.add(i);

            if ((i-queue.peekFirst()) == w){
                queue.pollFirst();
            }

            if (i >= w - 1){
                res[index++] = array[queue.peekFirst()];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        C7_GetWindowMaxValueArray c7 = new C7_GetWindowMaxValueArray();
        int[] array = {5, 4, 3, 4, 4, 5, 6, 7};
        int[] res = c7.getWindowArray(array, 3);
        System.out.println(res);
    }

}
