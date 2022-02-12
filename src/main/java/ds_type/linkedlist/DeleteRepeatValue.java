package ds_type.linkedlist;

import entity.ListNode;

/**
 * 83
 * desc : 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次
 */
public class DeleteRepeatValue {


    /**
     * 逻辑是维护两个变量，一个为当前节点，一个为下一个不同节点（或空），时间为O(n)
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;
        ListNode curNode = head;
        while(curNode != null){
            ListNode nextNode = curNode.next;
            while(nextNode!= null && nextNode.val == curNode.val){
                nextNode = nextNode.next;
            }
            curNode.next = nextNode;
            curNode = curNode.next;
        }
        return head;
    }
}
