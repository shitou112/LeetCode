package AlgorithmsAndDataStructure.chapter8;

/**
 * @author Qian Shaofeng
 * created on 2018/1/26.
 */
public class MissNum {

    public int minMissMum(int[] array){
        if (array==null || array.length==0)
            return 1;

        for (int i=0; i < array.length; ++i){
            while (array[i] > 0 && array[i]!=i+1 && array[i]-1 < array.length){
                int tmp = array[array[i]-1];
                if (tmp==array[i]) {
                    break;
                }
                array[array[i] - 1] = array[i];
                array[i] = tmp;

            }
        }

        for (int i=0; i < array.length; ++i){
            if (array[i]!=i+1)
                return i+1;
        }

        return array.length+1;
    }

    public static void main(String[] args) {
        MissNum m = new MissNum();
        int[] array = {-1, 1, 1, 1, 1, 1, 1};
        System.out.println(m.minMissMum(array));
        double a = Math.log(8) / Math.log(2);
        System.out.println(a);
    }
}
