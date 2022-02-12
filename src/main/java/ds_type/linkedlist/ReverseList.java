package ds_type.linkedlist;

import entity.ListNode;

/**
 * desc: 反转链表
 */
public class ReverseList {


    /**
     * 头插法
     */
    public ListNode reverseList(ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.next = null;
        ListNode curNode = head;
        while(curNode!=null){
            ListNode tmp = curNode.next;
            curNode.next = newHead.next;
            newHead.next = curNode;
            curNode = tmp;
        }
        return newHead.next;
    }

    /**
     * 递归
     */
    public ListNode reverseList2(ListNode head) {
        if(head  == null || head.next == null){
            return head;
        }
        ListNode newHead  = reverseList2(head.next); // 先给子链表倒置，主要下一个节点成为了最后一个节点
        head.next.next = head;    // head.next依然可以指向下一个节点，这是关键
        head.next = null;
        return  newHead;

    }
    /**
     * 双指针： 一个指向新的链表头， 一个指向当前遍历节点，类似于头插法
     */
    public ListNode reverseList3(ListNode head) {
        ListNode pre = null;
        ListNode curNode = head;
        while(curNode != null){
            ListNode tmp = curNode.next;
            curNode.next = pre;
            pre = curNode;
            curNode = tmp;
        }
        return pre;
    }

}
