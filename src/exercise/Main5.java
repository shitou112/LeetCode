package exercise;

import java.util.*;

/**
 * @author Qian Shaofeng
 * created on 2018/3/20.
 */
public class Main5 {

    static class Node{
        int v1;
        int v2;
        int value;

        public Node(int v1, int v2, int value){
            this.v1 = v1;
            this.v2 = v2;
            this.value = value;
        }
    }

    public static int getList(PriorityQueue<Node> queue, int n){
        Set<Integer> hashSet = new HashSet<>();
        int max = 0;
        while (hashSet.size() < n || queue.size()!=0){
            Node node = queue.poll();
            if (!hashSet.contains(node.v1) || !hashSet.contains(node.v2)){
                hashSet.add(node.v1);
                hashSet.add(node.v2);
                max = max<node.value? node.value:max;
            }


        }

        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        PriorityQueue<Node> queue = new PriorityQueue<>(m, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.value < o2.value)
                    return -1;
                else if (o1.value == o2.value)
                    return 0;
                else
                    return 1;
            }
        });
        for (int i=0; i < m; ++i){
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            int value = scanner.nextInt();
            Node node = new Node(v1, v2, value);
            queue.add(node);
            System.out.println(i);
        }

        int value = Main5.getList(queue, n);
        System.out.println(value);
    }
}
