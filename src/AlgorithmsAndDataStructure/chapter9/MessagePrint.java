package AlgorithmsAndDataStructure.chapter9;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Qian Shaofeng
 * created on 2018/1/28.
 */
public class MessagePrint {

    class Message{
        int num;

        Message next;

        public Message(int num){
            this.num = num;
        }
    }

    int cur = 1;

    Message head = null;

    Map<Integer, Message> map = new HashMap<>();


    public void receiveMessage(int num){
        if (head==null){
            head = new Message(num);
        }
        else {
            Message message = new Message(num);
            map.put(num, message);
            if (message.num < head.num){
                message.next = head;
                head = message;
            }
            else {
                Message cur = head;
                while (cur.next!=null && message.num > cur.next.num){
                    cur = cur.next;
                }
                message.next = cur.next;
                cur.next = message;
            }

        }

        if (num == cur){
            printMessage(head);
        }
    }

    private void printMessage(Message message){
        if (message == null)
            return;

        Message pre = message;
        Message cur = message.next;
        System.out.println(pre.num);
        this.cur++;

        while (cur!=null && (cur.num-pre.num)==1){
            System.out.println(cur.num);
            pre = cur;
            cur = cur.next;
            this.cur++;
        }

        head = cur;

    }

    public static void main(String[] args) {
        MessagePrint mp = new MessagePrint();
        mp.receiveMessage(2);
        mp.receiveMessage(1);

        mp.receiveMessage(4);
        mp.receiveMessage(5);
        mp.receiveMessage(6);
        mp.receiveMessage(7);
        mp.receiveMessage(3);


    }
}
