package ds_type.linkedlist;

import entity.ListNode;

/**
 * 876
 * desc:给定一个头结点为 head 的非空单链表，返回链表的中间结点。如果有两个中间结点，则返回第二个中间结点。
 */
public class FindMidNode {

    public ListNode middleNode(ListNode head) {
        if(head == null)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        while(true){
            if(fast.next!=null && fast.next.next!=null){
                fast = fast.next.next;
            }
            else if(fast.next != null){ // 如果不够两步则直走一步到头
                fast = fast.next;
            }
            else{ // fast.next == null;
                break;
            }
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 简单的优化代码
     */
    public ListNode middleNode2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            if (fast.next == null) {
                return slow;
            }
            if(fast.next.next==null){
                return slow.next;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
