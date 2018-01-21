package AlgorithmsAndDataStructure.chapter5;

/**
 * @author Qian Shaofeng
 * created on 2018/1/19.
 */
public class Deformation {

    public boolean isDeformation(String str1, String str2){
        if (str1==null || str2==null || str1.length()!= str2.length())
            return false;

        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();

        int[] map = new int[256];
        for (int i=0; i < chs1.length; ++i){
            ++map[chs1[i]];
        }

        for (int j=0; j < chs2.length; ++j){
            if (map[chs2[j]]-- == 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Deformation d = new Deformation();
        String str1 = "123";
        String str2 = "1";
        System.out.println(d.isDeformation(str1, str2));
    }
}
