package sword2offer.niuke.problem;

import sword2offer.niuke.utils.ListNode;

/**
 * @author Qian Shaofeng
 * created on 2018/1/30.
 */
public class T16_MergeTwoListNode {

    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1==null)
            return list2;
        if(list2 == null)
            return list1;


        ListNode cur1 = list1;
        ListNode cur2 = list2;
        ListNode head;
        if(cur1.val <= cur2.val){
            head = cur1;
            cur1 = cur1.next;
        }
        else{
            head = cur2;
            cur2 = cur2.next;
        }

        ListNode cur = head;
        while(cur1!=null && cur2!=null){
            if(cur1.val <= cur2.val){
                cur.next = cur1;
                cur1 = cur1.next;
                cur = cur.next;
            }
            else{
                cur.next = cur2;
                cur2 = cur2.next;
                cur = cur.next;
            }
        }

        if(cur1==null)
            cur.next = cur2;
        else
            cur.next = cur1;

        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(1);
        ListNode l6 = new ListNode(1);
        ListNode l7 = new ListNode(1);

        l1.next = l2;
        l2.next = l3;

        l4.next = l5;
        l5.next = l6;
        l6.next = l7;

        T16_MergeTwoListNode t16 = new T16_MergeTwoListNode();
        l1 = t16.Merge(l1, l4);
        System.out.println(l1);
    }
}
