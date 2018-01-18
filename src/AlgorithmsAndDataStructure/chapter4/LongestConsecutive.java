package AlgorithmsAndDataStructure.chapter4;

import java.util.HashMap;

/**
 * @author Qian Shaofeng
 * created on 2018/1/18.
 */
public class LongestConsecutive {

    public int lc(int[] array){
        if (array==null || array.length==0)
            return 0;

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int max = 1;
        for (int i=0; i < array.length; ++i){
            if (!hashMap.containsKey(array[i])){
                hashMap.put(array[i], 1);
                if (hashMap.containsKey(array[i]-1)){
                    max = Math.max(max, mergeMapValue(hashMap, array[i]-1, array[i]));
                }

                if (hashMap.containsKey(array[i]+1)){
                    max = Math.max(max, mergeMapValue(hashMap, array[i], array[i]+1));
                }

            }
        }

        return max;
    }

    private int mergeMapValue(HashMap<Integer, Integer> hashMap, int less, int more){
        int left = less - hashMap.get(less) + 1;
        int right = more + hashMap.get(more) - 1;
        int value = right - left + 1;
        hashMap.put(left, value);
        hashMap.put(right, value);
        return value;
    }

    public static void main(String[] args) {
        LongestConsecutive lc = new LongestConsecutive();
        int[] array = {100, 3, 2, 4, 1};
        System.out.println(lc.lc(array));
    }
}
