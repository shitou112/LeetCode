package AlgorithmsAndDataStructure.chapter1;

import java.util.LinkedList;

/**
 * @author Qian Shaofeng
 * created on 2018/2/4.
 */
public class C10_MaxSubMinNumbers {

    public int getNum(int[] array, int num){
        LinkedList<Integer> qmin = new LinkedList<>();
        LinkedList<Integer> qmax = new LinkedList<>();

        int i=0, j=0;
        int res = 0;
        while (i < array.length){
            while (j < array.length){


                while (!qmax.isEmpty() && array[qmax.peekLast()] <= array[j]){
                    qmax.pollLast();
                }
                qmax.addLast(j);

                while (!qmin.isEmpty() && array[qmin.peekLast()] >= array[j]){
                    qmin.pollLast();
                }
                qmin.addLast(j);

                if (!qmax.isEmpty() && !qmin.isEmpty() && (array[qmax.peekFirst()] - array[qmin.peekFirst()]) > num){
                    break;
                }

                ++j;
            }

            if (qmax.peekFirst() == i)
                qmax.pollFirst();
            if (qmin.peekFirst() == i)
                qmin.pollFirst();

            res += j - i;


            ++i;
        }

        return res;
    }

    public static void main(String[] args) {
        C10_MaxSubMinNumbers c10 = new C10_MaxSubMinNumbers();
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(c10.getNum(array, 1));
    }

}
