package exercise;

import java.util.Scanner;

/**
 * @author Qian Shaofeng
 * created on 2018/3/20.
 */
public class Main4 {

    public static int getNums(int[] array){
        int counts = 0;
        for (int i=0; i < array.length-1; ++i){
            if (array[i] == (i+1)) {
                if (array[i+1]==(i+2)){
                    ++i;
                }

                ++counts;
            }
        }

        return counts;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i=0; i < n; ++i)
            array[i] = scanner.nextInt();

        System.out.println(Main4.getNums(array));
    }
}
