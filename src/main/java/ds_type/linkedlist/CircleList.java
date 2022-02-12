package ds_type.linkedlist;

import entity.ListNode;

/**
 * 142
 * desc:给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 */
public class CircleList {

    /**
     * 141
     * 判断是否有环
     */
    public boolean hasCycle(ListNode head) {
        if(head == null)
            return false;
        ListNode fast = head;
        ListNode slow = head;       //特别注意这里又一个问题，不要在while中判断是否相等，因为初始化就是相等的！！！
        while(fast != null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)  //开始移动后比较相等
                return true;
        }
        return false;
    }
    /**
     * 快慢指针
     */
    public ListNode detectCycle(ListNode head) {
        if(head == null)
            return null;
        ListNode fast = head;
        ListNode slow = head;       //特别注意这里又一个问题，不要在while中判断是否相等，因为初始化就是相等的！！！
        while(fast != null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)  //开始移动后比较相等
                break;
        }
        if(fast == null || fast.next == null)
            return null;
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
