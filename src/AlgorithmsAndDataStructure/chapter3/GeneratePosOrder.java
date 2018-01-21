package AlgorithmsAndDataStructure.chapter3;

/**
 * @author Qian Shaofeng
 * created on 2018/1/12.
 */
public class GeneratePosOrder {

    int posIndex = 0;

    public int[] generatePosOrder(int[] pre, int[] in){
        if (pre==null || in==null)
            return null;

        posIndex = pre.length;
        return null;

    }

    private int generatePosOrder(int[] pre, int preStart, int preEnd, int inStart, int inEnd, int pos, int posIndex){
        return 0;
    }
}
