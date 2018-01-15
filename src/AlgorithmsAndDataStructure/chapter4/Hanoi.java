package AlgorithmsAndDataStructure.chapter4;

/**
 * @author Qian Shaofeng
 * created on 2018/1/14.
 */
public class Hanoi {

    public void hanoi(int n){
        if (n > 0){
            move(n, "from", "mid", "to");
        }
    }

    private void move(int n, String from, String mid, String to){
        if (n == 1){
            System.out.println(from + " => " + to);
        }
        else {
            move(n-1, from, to, mid);
            move(1, from, mid, to);
            move(n-1, mid, from, to);
        }

    }

    public static void main(String[] args) {
        Hanoi h = new Hanoi();
        h.hanoi(10);
    }
}
