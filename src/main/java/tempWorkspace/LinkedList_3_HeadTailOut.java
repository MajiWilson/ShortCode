package tempWorkspace;

import utils.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Class: ����һǰһ������µ�����
 * 1 -> 2 -> 3 -> 4 -> 5
 * 1 -> 5 -> 2 -> 4 -> 3
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/5/9 , 10:37
 */
public class LinkedList_3_HeadTailOut {
    public static void main(String[] args){
        Node head = new Node(1);
        Node parentNode = head;
        Node curNode ;
        for( int i  =2 ;i <= 20 ; i++){
            curNode = new Node(i);
            parentNode.next = curNode;
            parentNode = curNode;
        }
        printList( head );
        Node newHead = reArrangeList( head );
        printList( newHead );
    }
    /* ˼·�� ���ö��е��������������ö��׺Ͷ�β����ֵ ʵ������������ã���Ϊ����Ĳ�ѯЧ�ʽϵ� */
    public static Node reArrangeList( Node head ){
        LinkedList<Integer> queue = new LinkedList<>();
        Node curNode = head;
        while(null != curNode){
            queue.add(curNode.value);
            curNode = curNode.next;
        }
        Node newHead = new Node(queue.removeFirst());
        Node parentNode = newHead;
        while( !queue.isEmpty() ){
            curNode = new Node(queue.removeLast());
            parentNode.next = curNode;
            parentNode = curNode;
            if(!queue.isEmpty()){
                curNode = new Node(queue.removeFirst());
                parentNode.next = curNode;
                parentNode = curNode;
            }
            else{
                break;
            }
        }
        return newHead;



    }

    public static void printList(Node head){
        Node curNode = head;
        while( null != curNode ){
            System.out.print( curNode.value + "  ->  ");
            curNode = curNode.next;
        }
        System.out.println();
    }
}
