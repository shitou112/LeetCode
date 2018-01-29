package sword2offer.niuke.problem;

/**
 * @author Qian Shaofeng
 * created on 2018/1/29.
 */
public class T13_OddEvenOrder {

    public void reOrderArray(int [] array) {
        int oddNum=0, evenNum=array.length-1;
        int num = array.length-1;
        int[] newArray = new int[array.length];
        for(int i=0; i < array.length; ++i){
            if(array[i]%2==1)
                newArray[oddNum++] = array[i];
            else
                newArray[evenNum--] = array[i];
        }
        int i;
        for(i=0; i < oddNum; ++i){
            array[i] = newArray[i];
        }
        for(; i < array.length; ++i){
            array[i] = newArray[num--];
        }

    }



    public static void main(String[] args) {
        T13_OddEvenOrder t13 = new T13_OddEvenOrder();
        int[] array = {1, 2, 3, 4, 5, 6};
        t13.reOrderArray(array);
        System.out.println(array);
    }
}
