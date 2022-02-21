package tempWorkspace;


import entity.Node;

import java.util.Scanner;

/**
 * Class:��n����Χ��һȦ��˳���źš��ӵ�һ���˿�ʼ��������1��3��������������3�����˳�Ȧ�ӣ���������µ���ԭ���ڼ��ŵ���λ��
 * 5 -> 4
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/2/29 , 21:12
 */
public class Order_3_LastRemain {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(  lastRemain( n ) );
    }

    public static int lastRemain(int n ){
        if( n ==1){
            return 1;
        }
        Node head = new Node(1);
        Node parent = head;
        Node curNode = null;
        for(int i =2;i<=n;i++){
             curNode = new Node(i);
             parent.next = curNode;
             parent = curNode;
        }
        curNode.next = head;
        parent = curNode;
        curNode =head;
        while( curNode.next !=curNode ){
            for(int i = 0 ;i < 2;i++){
                parent=parent.next;
                curNode = curNode.next;
            }
            parent.next = curNode.next;
            curNode = parent.next;
        }
        return curNode.value;
    }

}

