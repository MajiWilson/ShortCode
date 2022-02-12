package ds_type.linkedlist;

import entity.ListNode;

/**
 * 82
 * desc: 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字
 */
public class DeleteRepeatNode {

    /**
     * 递归算法： 如果头节点为null或者只有一个节点直接返回，如果头节点存在重复，则找到第一个不同的节点，递归即可， 如果不同则递归后面的子序列
     */
    public ListNode deleteDuplicates1(ListNode head) {
        if(head == null || head.next == null){ //递归出口
            return head;
        }
        if(head.val == head.next.val){
            while(head.next!= null && head.next.val == head.val){
                head = head.next;
            }
            return deleteDuplicates(head.next); // 新头部 ，截断

        }
        else{
            head.next = deleteDuplicates(head.next); // 衔接
            return head;
        }
    }


    /**
     * 83
     * desc: 如果删除重复的留一个，比较简单直接遍历即可
     */
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode pre = pHead;
        ListNode cur = pHead.next;
        while(cur != null){
            if(cur.val == pre.val){
                pre.next = cur.next;
                cur = pre.next;
            }
            else{
                pre = cur;
                cur = cur.next;

            }
        }
        return pHead;
    }

    /**
     * 练习
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        if(head.val == head.next.val){
            while(head.next != null && head.next.val == head.val){
                head = head.next;
            }
            return deleteDuplicates(head.next);  //这里最后不同了或者next为null均需要舍弃这个head节点，因为一个不能保留
        }
        head.next = deleteDuplication(head.next); // 这里不等的话就可以保留
        return head;

    }
}
