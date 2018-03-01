package AlgorithmsAndDataStructure.chapter2;

import AlgorithmsAndDataStructure.utils.Node;

/**
 * @author Qian Shaofeng
 * created on 2018/3/1.
 */
public class C15_ReversePart {

    public Node reversePart(Node head, int from, int to){
        int len = 0;
        Node cur = head;
        Node fPre = null;
        Node tPos = null;
        while (cur != null){
            ++len;
            if (len == from-1)
                fPre = cur;
            if (len == to+1)
                tPos = cur;
            cur = cur.next;
        }

        if (from < 1 || to > len){
            return head;
        }

        Node pre = fPre==null? head: fPre.next;
        cur = pre.next;
        pre.next = tPos;

        Node tmp;
        while (cur != tPos){
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        if (fPre != null){
            fPre.next = pre;
            return head;
        }

        return pre;
    }

    public static void main(String[] args) {
        C15_ReversePart rp = new C15_ReversePart();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        n1.next = n2;
        n2.next = n3;

        Node head = rp.reversePart(n1, 1, 2);
        System.out.println(head);
    }

}
