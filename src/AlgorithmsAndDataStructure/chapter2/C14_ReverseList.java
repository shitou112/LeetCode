package AlgorithmsAndDataStructure.chapter2;

import AlgorithmsAndDataStructure.utils.Node;

/**
 * @author Qian Shaofeng
 * created on 2018/3/1.
 */
public class C14_ReverseList {

    public Node reverseList(Node head){

        Node pre = null;
        Node tmp;
        while (head != null){
            tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }


        return pre;
    }

    public static void main(String[] args) {
        C14_ReverseList rs = new C14_ReverseList();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        n1.next = n2;
        n2.next = n3;

        Node head = rs.reverseList(n1);
        System.out.println(head);
    }
}
