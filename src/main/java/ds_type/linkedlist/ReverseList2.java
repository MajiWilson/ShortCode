package ds_type.linkedlist;

import entity.ListNode;

/**
 * 92
 * desc: 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 1 ≤ m ≤ n ≤ 链表长度。
 */
public class ReverseList2 {

    /**
     * 先找到第一个需要倒置的节点， 然后使用头插法新建一个头节点， 倒置完了以后就整体加上去
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode curNode = head;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode pre = newHead;
        ListNode tmpHead = new ListNode(0);
        int i = 1;
        while(i < left){
            curNode = curNode.next;
            pre = pre.next;
        }
        ListNode end = curNode;
        for( i = left ;i<= right; i++){
            ListNode nextNode = curNode.next;
            curNode.next = tmpHead.next;
            tmpHead.next = curNode;
            curNode = nextNode;
        }
        pre.next = tmpHead.next;
        end.next = curNode;
        return newHead.next;
    }
}
