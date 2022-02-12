package ds_type.linkedlist;

import entity.ListNode;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 23
 * desc: 合并多个升序列表为一个有序列表
 */
public class MergeMultiList {

    public ListNode mergeTwoLists(ListNode list1,ListNode list2){
        if(list1 == null || list2 == null)
            return (list1 == null)? list2 : list1;
        ListNode head = new ListNode(0);
        ListNode cur = head;
        ListNode l1 = list1,l2 = list2;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = (l1 == null) ? l2 : l1;
        return head.next;
    }

    /**
     * 先二分法两两合并,假设有5个链表，
     *              （1 + 2） ->t1
     *               (t1 + 3) -> t2
     *               (3 + 4 ) -> t3
     *               (t2 + t3) -> t4
     * 合并的次数为4次， 比按次序进行合并而言，代价更小， 比较次数更少
     */
    public ListNode merge(ListNode[] lists,int l,int r){
        if(l > r )
            return null;
        if(l == r)
            return lists[l];
        int mid = l + (r - l) / 2;
        return mergeTwoLists(merge(lists,l,mid), merge(lists,mid + 1,r));
    }
    public ListNode mergeKLists(ListNode[] lists) {

        return merge(lists,0,lists.length - 1);
    }


    /*********************************************************************************************************************
     * 效率较低的简单方法，集合，每次找到最小的然后递归加入到新链表中  不推荐
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        int n = lists.length;
        if(n==0){
            return null;
        }
        if(n == 1){
            return lists[0];
        }
        Set<ListNode> nodes = new HashSet<>();
        for(ListNode node : lists){
            if(node != null){
                nodes.add(node);
            }
        }
        if(nodes.size() == 0)
            return null;
        return recur(nodes);
    }
    public ListNode recur(Set<ListNode> nodes){
        if(nodes.size() == 1){
            for(ListNode node :nodes){ //只有一个列表就直接返回唯一的一个链表
                return node;
            }
        }
        int min = Integer.MAX_VALUE;
        ListNode minNode = null;
        for(ListNode node : nodes){
            if(node.val < min){
                min = node.val;
                minNode = node;
            }
        }
        nodes.remove(minNode);
        if(minNode.next != null){
            nodes.add(minNode.next);
        }
        minNode.next = recur(nodes);
        return minNode;
    }

    /**********************************************************************************************************************
     *
     *借助堆来完成遍历, 小根堆，每次都是最小的，这样可以显著提高效率
     */
    public ListNode mergeKLists3(ListNode[] lists) {
        if (lists == null || lists.length <= 0)
            return null;
        ListNode result = null;
        ListNode temp = null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {  // 默认就是小根堆
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }//小根堆
        });
        for (int i = 0; i < lists.length; i++)
            if (lists[i] != null)
                queue.add(lists[i]);
        while (!queue.isEmpty()) {
            if (queue.peek().next != null)
                queue.add(queue.peek().next);
            if (result == null) {     // 这里不必要先poll()再add(）是因为链表是升序的，不会是root,
                result = new ListNode(queue.poll().val);
                temp = result;
            } else {
                temp.next = new ListNode(queue.poll().val);
                temp = temp.next;
            }
        }
        return result;
    }
}
