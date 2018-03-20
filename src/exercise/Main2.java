package exercise;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Qian Shaofeng
 * created on 2018/3/20.
 */
public class Main2 {

    public static int res = 0;

    public static void maxNum(int[] arr, int index, int counts, int target){
        if (target <= 0) {
            res = res>counts? res: counts;
            return;
        }

        if (index < 0)
            return;

        for (int i=index; i >= 0; --i){
            maxNum(arr, i-1, counts+1,target - arr[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int target = scanner.nextInt();

        int[] arr = new int[n];
        for (int i=0; i < n; ++i){
            arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr);
        Main2.maxNum(arr, arr.length-1, 0, target);
        System.out.println(Main2.res);
    }
}
