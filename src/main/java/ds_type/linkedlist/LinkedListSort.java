package ds_type.linkedlist;

import entity.ListNode;

/**
 * 148
 * desc: 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表
 */
public class LinkedListSort {

    public ListNode sortList(ListNode head) {
        if(head == null)
            return null;
        return sortList(head, null);
    }

    /**
     * 逻辑： 二分，排序，合并，和数组的归并排序相同
     */
    public ListNode sortList(ListNode head, ListNode tail){
        if(head == null)
            return null;
        if(head.next == tail){
            head.next = null;     //这里子所以需要改成null， 是因为该子链只有一个节点，排序是不包括尾部的
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != tail){ // 注意： 快指针最多就是指向tail
            fast = fast.next;
            slow = slow.next;
            if(fast != tail){
                fast = fast.next;
            }
        }
        ListNode leftList = sortList(head, slow);
        ListNode rightList = sortList(slow, tail);
        return mergeTwoList(leftList, rightList);
    }

    public ListNode mergeTwoList(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }
        if( l2 == null){
            return l1;
        }
        if( l1.val < l2.val){
            l1.next = mergeTwoList(l1.next,  l2);
            return l1;
        }
        else{
            l2.next = mergeTwoList(l1, l2.next);
            return l2;
        }
    }

    /**
     * 进一步：可以将排序整合，采用非递归的方式可以提高效率
     */
    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(0);  //创建一个头节点， 来一个个比较
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }

    /**
     * 为了进一步降低空间复杂度，下面的方法逻辑是：先两两排序，然后4个4个排序。。。。
     */
    public static ListNode sortList3(ListNode head) {
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        dummyHead.next = head;
        // 先统计长度f
        ListNode p = dummyHead.next;
        int length = 0;
        while(p != null){
            ++length;
            p = p.next;
        }
        // 循环开始切割和合并
        for(int size = 1; size < length; size <<= 1){
            ListNode cur = dummyHead.next;
            ListNode tail = dummyHead;
            while(cur != null){
                ListNode left = cur;
                ListNode right = cut(cur, size); // 链表切掉size 剩下的返还给right
                cur = cut(right, size); // 链表切掉size 剩下的返还给cur
                tail.next = merge(left, right);
                while(tail.next != null){
                    tail = tail.next; // 保持最尾端
                }
            }
        }
        return dummyHead.next;
    }

    /**
     * 将链表L切掉前n个节点 并返回后半部分的链表头
     * @param head
     * @param n
     * @return
     */
    public static ListNode cut(ListNode head, int n){
        if(n <= 0) return head;
        ListNode p = head;
        // 往前走n-1步
        while(--n > 0 && p != null){
            p = p.next;
        }
        if(p == null) return null;
        ListNode next = p.next;
        p.next = null;
        return next;
    }

    /**
     * 合并list1和list2
     */
    public static ListNode merge(ListNode list1, ListNode list2){
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE), p = dummyHead;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                p.next = list1;
                list1 = list1.next;
            } else{
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }
        if(list1 == null){
            p.next = list2;
        } else{
            p.next = list1;
        }
        return dummyHead.next;
    }


}
