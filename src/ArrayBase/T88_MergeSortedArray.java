package ArrayBase;

/**
 * @author Qian Shaofeng
 * created on 2017/12/11.
 */
public class T88_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int index = m+n;
        while (m!=0 && n!=0){
            if (nums1[m-1] >= nums2[n-1]){
                nums1[--index] = nums1[m-1];
                --m;
            }else {
                nums1[--index] = nums2[n-1];
                --n;
            }
        }

        while (n!=0){
            nums1[--index] = nums2[--n];
        }
    }

    public static void main(String[] args) {
        T88_MergeSortedArray msa = new T88_MergeSortedArray();
        int[] nums1 = {1,2,3,4,5,6, 0, 0, 0, 0 ,0 ,0 ,0 ,0};
        int[] nums2 = {1,4,5,7};
        msa.merge(nums1, 6, nums2, nums2.length);
        System.out.println();
    }
}
