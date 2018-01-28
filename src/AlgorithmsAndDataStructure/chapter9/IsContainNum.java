package AlgorithmsAndDataStructure.chapter9;

/**
 * @author Qian Shaofeng
 * created on 2018/1/28.
 */
public class IsContainNum {

    public boolean isContainNum(int[] array, int target){
        if (array==null || array.length==0)
            return false;

        int left = 0;
        int right = array.length-1;
        while (left <= right){
            if (array[left] < array[right])
                return binSearch(array, left, right, target);

            int mid = (left+right) / 2;
            if (array[mid] == target)
                return true;

            if (array[left] > array[mid]){
                if (target >= array[left]){
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
            else if (array[mid] > array[right]){
                if (target <= array[right]){
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
            else {
                for (int i=left; i <= right; ++i){
                    if (array[i]==target)
                        return true;
                }
                return false;
            }
        }

        return false;
    }

    public boolean binSearch(int[] array, int s, int e, int target){
        if (s > e)
            return false;

        int mid = (s+e) / 2;
        if (array[mid] == target)
            return true;

        if (array[mid] < target){
            return binSearch(array, mid+1, e, target);
        }
        else {
            return binSearch(array, s, mid-1, target);
        }
    }

    public static void main(String[] args) {
        IsContainNum c = new IsContainNum();
        int[] array = {4, 5, 6, 4 ,4 ,4, 4 };
        System.out.println(c.isContainNum(array, 5));
    }
}
