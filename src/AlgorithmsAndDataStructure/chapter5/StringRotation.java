package AlgorithmsAndDataStructure.chapter5;

/**
 * @author Qian Shaofeng
 * created on 2018/1/19.
 */
public class StringRotation {

    public boolean isRotation(String a, String b){
        if (a==null || b==null || a.length()!=b.length())
            return false;

        String concatB = b + b;
        if (concatB.contains(a))
            return true;
        return false;
    }

    public static void main(String[] args) {
        StringRotation sr = new StringRotation();
        System.out.println(sr.isRotation("cdba", "abcd"));
    }
}
