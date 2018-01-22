package AlgorithmsAndDataStructure.chapter5;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Qian Shaofeng
 * created on 2018/1/22.
 */
public class FormalStringComputing {

    public int computeValue(String str){
        if (str==null || str.length()==0)
            return 0;

        char[] chs = str.toCharArray();
        return value(chs, 0)[0];
    }

    private int[] value(char[] chs, int index){
        int pre = 0;
        Deque<String> deque = new LinkedList<>();
        while (index < chs.length && chs[index]!=')'){
            if (chs[index] >= '0' && chs[index] <= '9'){
                pre = pre*10 + chs[index++] - '0';
            }
            else if (chs[index] != '('){
                computeMultiOrDiv(deque, pre);
                deque.addLast(String.valueOf(chs[index++]));
                pre = 0;
            }
            else {
                int[] tmp = value(chs, index+1);
                index = tmp[1] + 1;
                pre = tmp[0];
            }

        }

        computeMultiOrDiv(deque, pre);
        int value = computeAddOrSub(deque);
        return new int[]{value, index};
    }

    private void computeMultiOrDiv(Deque<String> deque, int num){
        if (deque.isEmpty()) {
            deque.addLast(String.valueOf(num));
            return;
        }

        String top = deque.pollLast();
        if (top.equals("+") || top.equals("-")){
            deque.addLast(top);
        }
        else if (top.equals("*") || top.equals("/")){
            int value = Integer.valueOf(deque.pollLast());
            num = top.equals("*")?value*num: value/num;
        }

        deque.addLast(String.valueOf(num));

    }

    private int computeAddOrSub(Deque<String> deque){
        if (deque.isEmpty())
            return 0;

        int cur = Integer.valueOf(deque.pollFirst());
        boolean addFlag = false;
        while (!deque.isEmpty()){
            String top = deque.pollFirst();
            if (top.equals("+")){
                addFlag = true;
            }
            else if (top.equals("-")){
                addFlag = false;
            }
            else {
                int value = Integer.valueOf(top);
                cur = addFlag? cur+value: cur-value;
            }
        }

        return cur;
    }

    public static void main(String[] args) {
        FormalStringComputing fsc = new FormalStringComputing();
        System.out.println(fsc.computeValue("48*((70-65)-43)+8*1"));
    }
}
