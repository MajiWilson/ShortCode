package ds_type.linkedlist;

import entity.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * desc: 反转链表
 */
public class ReverseList {


    /**
     * 头插法
     */
    public static ListNode reverse1(ListNode head) {
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
    public static ListNode reverse(ListNode head) {
        if(null == head || head.next == null){
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    /**
     * 双指针： 一个指向新的链表头， 一个指向当前遍历节点，类似于头插法
     */
    public static ListNode reverseList3(ListNode head) {
       ListNode pre = null;
       ListNode cur = head;
       while(cur != null){
           // 断链身体需要保存剩余链
           ListNode temp = cur.next;

           cur.next = pre;
           pre = cur;

           cur = temp;
       }
       return pre;
    }

}
