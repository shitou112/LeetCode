package exercise;

import java.util.Scanner;

/**
 * @author Qian Shaofeng
 * created on 2018/3/9.
 */
public class Shuffle {
    public void shuffle(){
        Scanner scanner = new Scanner(System.in);
        int groups = scanner.nextInt();
        boolean isFirstNum = true;
        while(--groups >= 0){
            int eleNums = scanner.nextInt();
            int k = scanner.nextInt();
            int[] eles = new int[2 * eleNums];
            int[] res = new int[2 * eleNums];
            for (int j=0; j < eleNums*2; ++j){
                eles[j] = scanner.nextInt();
            }


            for (int iter=0; iter < k; ++iter) {
                int index = res.length - 1;
                int left = eleNums - 1;
                int right = 2 * eleNums - 1;
                for (int i = 0; i < eleNums; ++i) {
                    res[index--] = eles[right--];
                    res[index--] = eles[left--];
                }

                for (int i = 0; i < 2*eleNums; ++i) {
                    eles[i] = res[i];
                }
            }
            for (int i = 0; i < eles.length; ++i) {
                if (isFirstNum) {
                    System.out.print(res[i]);
                    isFirstNum = false;
                } else {
                    System.out.print(" " + res[i]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Shuffle shuffle = new Shuffle();
        shuffle.shuffle();
    }
}
