package ds_type.linkedlist;

import entity.ListNode;

/**
 * 142
 * desc: 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 *       将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *       给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 */
public class ReorganizeList2 {
    /**
     * 相当于穿线重排: 先找到中点，划分为两个链表， 右边链表倒置， 然后逐个链接即可，
     */
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
            return;
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow.next;
        mid = reverse(mid);
        slow.next = null;
        ListNode nextNode = head.next; // nextNode 记录断点的下一个节点，后续需要接着
        head.next = mid;
        ListNode curNode = mid;
        while(curNode != null){
            ListNode tmp = curNode.next;
            curNode.next = nextNode;
            curNode = nextNode;
            nextNode = tmp;
        }
    }

    public ListNode reverse(ListNode root){
        if(root == null || root.next == null)
            return root;
        ListNode newNode = reverse(root.next);
        root.next.next = root;
        root.next = null;
        return newNode;
    }
}
