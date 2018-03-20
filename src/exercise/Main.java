package exercise;

import java.util.Scanner;

public class Main {

    public long getNums(int n, int k) {
        if (n==1)
            return k;

        boolean posFlag = true;
        if ((n & 1) == 1) {
            posFlag = false;
        }

        long res = (long) Math.pow(k - 1, n);
        res = posFlag ? res + (k - 1) : res - (k - 1);

        return res;
    }

    public long getNum2(int n, int k){
        if (n==1)
            return k;
        if (n==2)
            return k*(k-1);
        if (n==3)
            return k*(k-1)*(k-2);

        long pre = k*(k-1);
        long cur = k*(k-1)*(k-2);
        long next = 0;

        for (int i=4; i <= n; ++i){
            next = (k-2)*cur + (k-1)*pre;
            pre = cur;
            cur = next;
        }

        return next;
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        System.out.println(main.getNums(n, k));
        System.out.println(main.getNum2(n ,k));
    }
}
