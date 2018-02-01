package CampusRecruitment;

import java.util.Scanner;

/**
 * @author Qian Shaofeng
 * created on 2018/1/30.
 */
public class C1_FindKStudents {

    long max;

    public long solution(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n==0)
            return 0;

        int[] array = new int[n];
        for (int i=0; i < n; ++i){
            array[i] = sc.nextInt();
        }


        int k = sc.nextInt();
        int d = sc.nextInt();

        long[][] maxMap = new long[k+1][n+1];
        long[][] minMap = new long[k+1][n+1];

        return maxAbility(array, k, d);
    }

    private long maxAbility(int[] array, int k, int d){
        maxAbility(array, 0, 1, k, d);
        return max;
    }

    private void maxAbility(int[] array, int index, long res, int k, int d){
        if (k==0){
            if (res > max) {
                max = res;
            }
            return;
        }

        for (int i=index; i < array.length; ++i){
            if (index==0 || i-index<d){
                maxAbility(array, i+1, res*array[i], k-1, d);
            }
            else {
                break;
            }


        }
    }

    public long solution2(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n==0)
            return 0;

        int[] array = new int[n];
        for (int i=0; i < n; ++i){
            array[i] = sc.nextInt();
        }


        int k = sc.nextInt();
        int d = sc.nextInt();

        long[][] dp = getDp(array, k, d);

        long res = 0;
        for (int i=k; i < array.length; ++i){
            if (dp[k-1][i] > res)
                res = dp[k-1][i];
        }


        return res;
    }

    private long[][] getDp(int[] array, int k, int d){
        long[][] maxValue = new long[k][array.length];
        long[][] minValue = new long[k][array.length];

        for (int i=0; i < array.length; ++i){
           minValue[0][i] = maxValue[0][i] = array[i];
        }

        for (int i=1; i < k; ++i){
            for (int j=i; j < array.length; ++j){

                long maxStudents = Long.MIN_VALUE;
                long minStudents = Long.MAX_VALUE;

                for (int id=j-1; id>=(j-d) && id>=0; --id){
                    if (maxStudents < Math.max(maxValue[i-1][id]*array[j], minValue[i-1][id]*array[j])){
                        maxStudents = Math.max(maxValue[i-1][id]*array[j], minValue[i-1][id]*array[j]);
                    }

                    if (minStudents > Math.min(maxValue[i-1][id]*array[j], minValue[i-1][id]*array[j])){
                        minStudents = Math.min(maxValue[i-1][id]*array[j], minValue[i-1][id]*array[j]);
                    }
                }

                maxValue[i][j] = maxStudents;
                minValue[i][j] = minStudents;

            }
        }

        return maxValue;
    }

    public static void main(String[] args) {
        C1_FindKStudents c1 = new C1_FindKStudents();
        long res = c1.solution2();
        System.out.println(res);
    }
}
