package ds_type.linkedlist;

import entity.ListNode;

/**
 * 328
 * desc: 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
 */
public class ReorganizeList {

    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null )
            return head;
        ListNode oddHead = head;
        ListNode oddPre = head;
        ListNode oddCur = head.next.next;
        ListNode evenNHead = head.next;
        ListNode evenPre = head.next;  // 维护两条链表，尾插法更新，最后拼接即可
        ListNode evenCur = oddCur == null ? null : oddCur.next;
        while(oddCur != null){
            oddPre.next = oddCur;
            oddPre = oddCur;
            oddCur = evenCur == null? null : evenCur.next;
            if(evenCur != null){
                evenPre.next  = evenCur;
                evenPre = evenCur;
                evenCur = oddCur == null ? null :oddCur.next;
            }
        }
        oddPre.next = evenNHead;
        evenPre.next = null;
        return oddHead;

    }

    /**
     * 优化代码， 不需要使用尾插法进行，head 和 head.next就是两个头部， 维护两个遍历指针odd even ,后面的关系可以直接用
     */
    public ListNode oddEvenList2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode evenHead = head.next;
        ListNode odd = head;
        ListNode even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

}
