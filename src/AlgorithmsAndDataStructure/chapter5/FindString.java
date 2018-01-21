package AlgorithmsAndDataStructure.chapter5;

/**
 * @author Qian Shaofeng
 * created on 2018/1/21.
 */
public class FindString {
    public int findString(String[] strs, String target){
        if (strs==null || target==null)
            return -1;

        return binSearch(strs, target);
    }

    public int binSearch(String[] strs, String target){
        int start = 0;
        int end = strs.length-1;
        while (start <= end){
            int mid = (start + end) / 2;
            if (mid <= end && strs[mid] == null){
                ++mid;
            }

            if (mid > end)
                break;

            int value = strs[mid].compareTo(target);
            if (value == 0)
                return mid;
            else if (value < 0){
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        FindString fs = new FindString();
//        String[] strs = {null, "a", null, "a", null, "b", null, "c"};
        String[] strs = new String[0];
        System.out.println(fs.binSearch(strs, "b"));
    }
}
