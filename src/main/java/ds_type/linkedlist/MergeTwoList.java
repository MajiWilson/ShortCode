package ds_type.linkedlist;

import entity.ListNode;

/**
 * 21
 * desc: 合并两个有序链表
 */
public class MergeTwoList {


    /**
     * 递归算法： 每次比较当前两个头节点，小的保留，继续比较后面的，这样时间复杂度为O（n + m)
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /**
     * 非递归算法：
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        ListNode head = new ListNode(0);
        ListNode curNode = head;
        while(l1!=null && l2 != null){
            if(l1.val < l2.val){
                curNode.next = l1;
                l1 = l1.next;
            }
            else{
                curNode.next = l2;
                l2 = l2.next;
            }
            curNode = curNode.next;
        }
        curNode.next = l1 ==null ? l2 : l1;
        return head.next;
    }
}
