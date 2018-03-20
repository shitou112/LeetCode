package exercise;

import java.util.*;

/**
 * @author Qian Shaofeng
 * created on 2018/3/20.
 */
public class Main3 {

    public static int res;

    public static Set<List<Integer>> hashSet = new HashSet<>();

    public static void getNums(int[][] arr, int index, int target, List<Integer> list){

        if (index >= arr.length) {
            if (target == 0) {
                ++res;
//                hashSet.add(new ArrayList<>(list));
            }
            return;
        }
        for(int j=arr[index][0]; j <= arr[index][1]; ++j){
            list.add(j);
            getNums(arr, index+1, target - j, list);
            list.remove(list.size()-1);
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] arr = new int[m][2];
        for (int i=0; i < m; ++i){
            for (int j=0; j < 2; ++j){
                arr[i][j] = scanner.nextInt();
            }
        }

        Main3.getNums(arr, 0, n, new ArrayList<>());
//        System.out.println(Main3.hashSet);
        System.out.println(Main3.res);

    }
}
