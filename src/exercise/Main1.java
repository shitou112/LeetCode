package exercise;

import java.util.Scanner;

/**
 * @author Qian Shaofeng
 * created on 2018/3/20.
 */
public class Main1 {

    public static void jiami(String str){
        char[] chs = str.toCharArray();
        for (int i=0; i < chs.length; ++i){
            if ((chs[i] >='a' && chs[i] <='z') || (chs[i]>='A' && chs[i]<='Z')){
                if (chs[i] == 'z'){
                    chs[i] = 'a';
                }
                else if (chs[i] == 'Z'){
                    chs[i] = 'Z';
                }
                else {
                    chs[i] += 1;
                }
            }
        }

        System.out.println(chs);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Main1.jiami(str);
    }
}
