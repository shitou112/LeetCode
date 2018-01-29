package sword2offer.niuke.problem;

import sword2offer.niuke.utils.ListNode;

/**
 * @author Qian Shaofeng
 * created on 2018/1/29.
 */
public class T14_FindKNode {

    public ListNode FindKthToTail(ListNode head, int k) {

        ListNode cur = head;
        ListNode res = head;
        int count = 0;
        while (cur!=null){
            ++count;
            cur = cur.next;
            if (count > k){
                res = res.next;
            }
        }

        return count>=k? res: null;
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

        T14_FindKNode t14 = new T14_FindKNode();
        System.out.println(t14.FindKthToTail(l1, 7).val);
    }
}
