package AlgorithmsAndDataStructure.chapter4;

/**
 * @author Qian Shaofeng
 * created on 2018/1/18.
 */
public class JumpGame {
    public int jumpGame(int[] array){
        if (array==null || array.length==0)
            return 0;

        int maxJump = array[0];
        int index = 0;
        int count = 0;
        while (index < array.length-1){
            int nextMaxIndex = 0;
            int nextIndex = 0;
            for (int i=index+1; i < maxJump+1 && i < array.length; ++i){
                if (i+array[i] > nextMaxIndex){
                    nextIndex = i;
                    nextMaxIndex = i + array[i];
                }
            }

            index = nextIndex;
            maxJump = nextMaxIndex;
            ++count;
        }

        return count;
    }

    public static void main(String[] args) {
        JumpGame jp = new JumpGame();
        int[] array = {3, 2, 3, 1, 1, 4};
        System.out.println(jp.jumpGame(array));
    }
}
