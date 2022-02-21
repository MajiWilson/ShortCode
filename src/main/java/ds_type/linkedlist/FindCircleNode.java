package ds_type.linkedlist;

import entity.ListNode;

/**
 * 142
 * desc:给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 */
public class FindCircleNode {


    /**
     * 快慢指针: 确定有环以后，快指针回到头节点，两者再次相遇的时候刚好在入口
     */
    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;       //特别注意这里又一个问题，不要在while中判断是否相等，因为初始化就是相等的！
        while(fast != null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        // 判断是否有环， 没有直接返回空
        if(fast == null || fast.next == null){
            return null;
        }

        slow = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;

    }

    /**
     * 代码的优化
     */
    public ListNode detectCycle2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            } else {
                fast = fast.next.next;
                slow = slow.next;
                if (slow == fast) {
                    break;
                }
            }
        }
        slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
