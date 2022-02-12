package ds_type.linkedlist;

import entity.ListNode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 逆序打印链表
 */
public class PrintListReverse {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        while(listNode != null){
            res.add(listNode.val);
            listNode = listNode.next;
        }
        Collections.reverse(res);
        return res;

    }
}
