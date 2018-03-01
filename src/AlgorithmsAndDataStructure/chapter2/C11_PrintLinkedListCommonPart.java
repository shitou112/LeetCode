package AlgorithmsAndDataStructure.chapter2;

import AlgorithmsAndDataStructure.utils.Node;

/**
 * @author Qian Shaofeng
 * created on 2018/3/1.
 */
public class C11_PrintLinkedListCommonPart {

    public void printCommonPart(Node head1, Node head2){
        if (head1 == null || head2 == null)
            return;

        Node cur1 = head1;
        Node cur2 = head2;

        while (cur1!=null && cur2!=null){
            if (cur1.value < cur2.value){
                cur1 = cur1.next;
            }
            else if (cur1.value == cur2.value){
                System.out.println(cur1.value+" ");
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            else {
                cur2 = cur2.next;
            }
        }
    }
}
