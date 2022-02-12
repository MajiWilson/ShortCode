package ds_type.linkedlist;

import entity.ListNode;

/**
 * 1721
 * desc: 给你链表的头节点 head 和一个整数 k 。交换 链表正数第 k 个节点和倒数第 k 个节点的值后，返回链表的头节点（链表 从 1 开始索引）。
 */
public class SwapNodes {

    /**
     * 双指针， 一个先走k-1步， 然后另一个开始一起走，这样之后left right 就分别指向两个需要交换的节点，交换val即可
     */
    public ListNode swapNodes(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        ListNode left = head;
        for(int i = 1; i<k ;i ++){
            left = left.next;
        }
        ListNode tmp = left;
        ListNode right = head;
        while(left.next != null){
            left = left.next;
            right = right.next;
        }
        left = tmp;
        int leftVal = left.val;
        left.val = right.val;
        right.val = leftVal;
        return head;
    }
}
