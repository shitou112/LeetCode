package sword2offer.niuke.problem;

import sword2offer.niuke.utils.ListNode;

/**
 * @author Qian Shaofeng
 * created on 2018/1/29.
 */
public class T15_InverseLinkedList {

    public ListNode ReverseList(ListNode head) {
        if (head==null)
            return head;

        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp;
        while (cur != null){
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        return pre;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;

        T15_InverseLinkedList t14 = new T15_InverseLinkedList();
        ListNode res = t14.ReverseList(l1);
        System.out.println(res);

    }
}
