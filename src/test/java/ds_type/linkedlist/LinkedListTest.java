package ds_type.linkedlist;

import entity.ListNode;
import org.junit.jupiter.api.Test;

import utils.LinkedListUtil;


import java.util.List;

/**
 * @author weitong
 * @date 2022/02-17 7:05 下午
 */
public class LinkedListTest {


    @Test
    public void judgeCircleExistTest(){
        ListNode head = LinkedListUtil.generateLinkedList(10);
        LinkedListUtil.print(head);
        System.out.println(JudgeCircleExist.judge(head));
    }

    @Test
    public void findMidNode(){
        ListNode head = LinkedListUtil.generateLinkedList(10);
        LinkedListUtil.print(head);
        System.out.println(FindMidNode.findMid2(head).val);
    }

    @Test
    public void findMidNode2(){
        ListNode head = LinkedListUtil.generateLinkedList(13);
        LinkedListUtil.print(head);
        System.out.println(FindMidNode.findMid(head).val);
    }

    @Test
    public void findMidNode3(){
        ListNode head = LinkedListUtil.generateLinkedList(10);
        LinkedListUtil.print(head);
        System.out.println(FindMidNode2.middleNode(head).val);
    }
    @Test
    public void findMidNode4(){
        ListNode head = LinkedListUtil.generateLinkedList(11);
        LinkedListUtil.print(head);
        System.out.println(FindMidNode2.middleNode2(head).val);
    }

    @Test
    public void KthNode(){
        ListNode head = LinkedListUtil.generateLinkedList(9);
        LinkedListUtil.print(head);
        System.out.println(KthNode.getKthFromEnd(head, 3).val);
    }

    @Test
    public void reversePrintTest(){
        ListNode head = LinkedListUtil.generateLinkedList(9);
        LinkedListUtil.print(head);
        LinkedListUtil.printReverse(head);
    }
    @Test
    public void reverseListTest1(){
        ListNode head = LinkedListUtil.generateLinkedList(9);
        LinkedListUtil.print(head);
        LinkedListUtil.print(ReverseList.reverseList3(head));
    }

    @Test
    public void reverseListTest2(){
        ListNode head = LinkedListUtil.generateLinkedList(9);
        LinkedListUtil.print(head);
        LinkedListUtil.print(ReverseList.reverse1(head));
    }

    @Test
    public void reverseListTest3(){
        ListNode head = LinkedListUtil.generateLinkedList(9);
        LinkedListUtil.print(head);
        LinkedListUtil.print(ReverseList.reverse(head));
    }

    @Test
    public void reverseListTestBetween(){
        ListNode head = LinkedListUtil.generateLinkedList(12);
        LinkedListUtil.print(head);
        LinkedListUtil.print(ReverseListBetween.reverseBetween(head, 3,9));

    }

    @Test
    public void deleteRepeatValueTest(){
        int[] array = {1,1,3,5,5,5,7,7,8,9,9,9};
        ListNode head = LinkedListUtil.generateListByArray(array);
        LinkedListUtil.print(head);
        ListNode newHead = DeleteRepeatValue.delete2(head);
        LinkedListUtil.print(newHead);

    }

    @Test
    public void deleteRepeatValueTest1(){
        int[] array = {1,1,3,5,5,5,7,7,8,9,9,9};
        ListNode head = LinkedListUtil.generateListByArray(array);
        LinkedListUtil.print(head);
        ListNode newHead = DeleteRepeatValue.delete1(head);
        LinkedListUtil.print(newHead);

    }

    @Test
    public void deleteRepeatValueTest13(){
        int[] array = {1,1,3,5,5,5,7,7,8,9,9,9};
        ListNode head = LinkedListUtil.generateListByArray(array);
        LinkedListUtil.print(head);
        ListNode newHead = DeleteRepeatValue.delete3(head);
        LinkedListUtil.print(newHead);

    }

    @Test
    public void deleteAllRepeatValueTest1(){
        int[] array = {1,1,3,5,5,5,7,7,8,9,9,9};
        ListNode head = LinkedListUtil.generateListByArray(array);
        LinkedListUtil.print(head);
        ListNode newHead = DeleteAllRepeatValue.delete(head);
        LinkedListUtil.print(newHead);

    }


    @Test
    public void swapNodeTest(){
        ListNode head = LinkedListUtil.generateLinkedList(12);
        LinkedListUtil.print(head);
        SwapNodes.swapNodes(head, 8);
        LinkedListUtil.print(head);

    }

    @Test
    public void oddEvenListTest1(){
        ListNode head = LinkedListUtil.generateLinkedList(11);
        LinkedListUtil.print(head);
        ReorganizeList.oddEvenList2(head);
        LinkedListUtil.print(head);
    }

    @Test
    public void oddEvenListTest2(){
        ListNode head = LinkedListUtil.generateLinkedList(13);
        LinkedListUtil.print(head);
        ReorganizeList.oddEvenList3(head);
        LinkedListUtil.print(head);
    }
    @Test
    public void oddEvenListTest3(){
        ListNode head = LinkedListUtil.generateLinkedList(13);
        LinkedListUtil.print(head);
        ReorganizeList.oddEvenList(head);
        LinkedListUtil.print(head);
    }
    @Test
    public void oddEvenListTest4(){
        ListNode head = LinkedListUtil.generateLinkedList(17);
        LinkedListUtil.print(head);
        List<ListNode> res = ReorganizeList.oddEvenList4(head);
        LinkedListUtil.print(res.get(0));
        LinkedListUtil.print(res.get(1));

    }

    @Test
    public void interceptionReverseTest(){
        ListNode head = LinkedListUtil.generateLinkedList(10);
        LinkedListUtil.print(head);
        ListNode newHead = InterceptionReverseList.reverse(head);
        LinkedListUtil.print(newHead);

    }


    @Test
    public void interceptionMergeTest(){
        ListNode head1 = LinkedListUtil.generateLinkedList(2);
        ListNode heda2 = LinkedListUtil.generateLinkedList(9);
        LinkedListUtil.print(head1);
        LinkedListUtil.print(heda2);
        ListNode newHead = InterceptionMergeList.merge(head1, heda2);
        LinkedListUtil.print(newHead);

    }
    @Test
    public void interceptionMergeTest2(){
        ListNode head1 = LinkedListUtil.generateLinkedList(9);
        ListNode heda2 = LinkedListUtil.generateLinkedList(7);
        LinkedListUtil.print(head1);
        LinkedListUtil.print(heda2);
        ListNode newHead = InterceptionMergeList.merge2(head1, heda2);
        LinkedListUtil.print(newHead);

    }
    @Test
    public void interceptionMergeTest3(){
        ListNode head1 = LinkedListUtil.generateLinkedList(9);
        ListNode heda2 = LinkedListUtil.generateLinkedList(6);
        LinkedListUtil.print(head1);
        LinkedListUtil.print(heda2);
        ListNode newHead = InterceptionMergeList.merge3(head1, heda2);
        LinkedListUtil.print(newHead);

    }
    @Test
    public void mergeTwoOrderedListTest(){
        int[] array1 = {1,3,6,9,12,15,16};
        int[] array2 = {2,4,7,11,18,20};
        ListNode head1 = LinkedListUtil.generateListByArray(array1);
        ListNode head2 = LinkedListUtil.generateListByArray(array2);
        ListNode res = MergeTwoOrderedList.merge(head1, head2);
        LinkedListUtil.print(res);
    }

    @Test
    public void mergeTwoOrderedListTes2(){
        int[] array1 = {1,3,6,9,12,15,16};
        int[] array2 = {2,4,7,11,18,20};
        ListNode head1 = LinkedListUtil.generateListByArray(array1);
        ListNode head2 = LinkedListUtil.generateListByArray(array2);
        ListNode res = MergeTwoOrderedList.merge2(head1, head2);
        LinkedListUtil.print(res);
    }

    @Test
    public void mergeMultiOrderedListTest1(){
        int[] array1 = {1,3,6,9,12,15,16};
        int[] array2 = {2,4,7,11,18,20};
        int[] array3 = {3,3,7,9,15,15,36};
        int[] array4 = {2,6,7,18,18,19};
        int[] array5 = {1,1,10,11,12,18,20};
        int[] array6 = {5,5,10,11,13,30};
        ListNode head1 = LinkedListUtil.generateListByArray(array1);
        ListNode head2 = LinkedListUtil.generateListByArray(array2);
        ListNode head3 = LinkedListUtil.generateListByArray(array3);
        ListNode head4 = LinkedListUtil.generateListByArray(array4);
        ListNode head5 = LinkedListUtil.generateListByArray(array5);
        ListNode head6 = LinkedListUtil.generateListByArray(array6);
        ListNode[] lists = {head1, head2, head3, head4, head5, head6};
        ListNode res = MergeMultiList.mergeKLists(lists);
        LinkedListUtil.print(res);
    }

    @Test
    public void mergeMultiOrderedListTest2(){
        int[] array1 = {1,3,6,9,12,15,16};
        int[] array2 = {2,4,7,11,18,20};
        int[] array3 = {3,3,7,9,15,15,36};
        int[] array4 = {2,6,7,18,18,19};
        int[] array5 = {1,1,10,11,12,18,20};
        int[] array6 = {5,5,10,11,13,30};
        ListNode head1 = LinkedListUtil.generateListByArray(array1);
        ListNode head2 = LinkedListUtil.generateListByArray(array2);
        ListNode head3 = LinkedListUtil.generateListByArray(array3);
        ListNode head4 = LinkedListUtil.generateListByArray(array4);
        ListNode head5 = LinkedListUtil.generateListByArray(array5);
        ListNode head6 = LinkedListUtil.generateListByArray(array6);
        ListNode[] lists = {head1, head2, head3, head4, head5, head6};
        ListNode res = MergeMultiList.mergeKLists2(lists);
        LinkedListUtil.print(res);
    }

    @Test
    public void mergeMultiOrderedListTest3(){
        int[] array1 = {1,3,6,9,12,15,16};
        int[] array2 = {2,4,7,11,18,20};
        int[] array3 = {3,3,7,9,15,15,36};
        int[] array4 = {2,6,7,18,18,19};
        int[] array5 = {1,1,10,11,12,18,20};
        int[] array6 = {5,5,10,11,13,30};
        ListNode head1 = LinkedListUtil.generateListByArray(array1);
        ListNode head2 = LinkedListUtil.generateListByArray(array2);
        ListNode head3 = LinkedListUtil.generateListByArray(array3);
        ListNode head4 = LinkedListUtil.generateListByArray(array4);
        ListNode head5 = LinkedListUtil.generateListByArray(array5);
        ListNode head6 = LinkedListUtil.generateListByArray(array6);
        ListNode[] lists = {head1, head2, head3, head4, head5, head6};
        ListNode res = MergeMultiList.mergeKLists3(lists);
        LinkedListUtil.print(res);
    }

    @Test
    public void listSortTest(){
        ListNode head = LinkedListUtil.generateLinkedList(21);
        LinkedListUtil.print(head);

        ListNode sortHead = ListSort.mergeSort(head);

        LinkedListUtil.print(sortHead);
    }

    @Test
    public void listSortTest2(){
        ListNode head = LinkedListUtil.generateLinkedList(20);
        LinkedListUtil.print(head);

        ListNode sortHead = ListSort.quickSort(head);

        LinkedListUtil.print(sortHead);
    }







}
