package ds_type.array;

import entity.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Class: Լɪ��
 * ѭ������Ļ�ʱ�临�ӶȱȽϴ�O(NM) ) ;
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/16 , 23:12
 */
public class JosephRing {

    public static void main(String[] args){
        int n = 8 ;
        josephRing1(n,3);
        josephRing2(n,3);
    }
    /* i ��ʾ����һλ��ʼ������Ĭ���ϴ�Ϊ0 */

    public static void josephRing1(int n ,int m ){

        List<Integer> list = new ArrayList<>();
        for(int i = 1 ; i<= n ; i++){
            list.add(i);
        }
        int i = 0;
        System.out.println();
        while(!list.isEmpty()){
            i = (i+m-1)%list.size();        //ÿ��ɾ����Ϊ i = �� i + m - 1) % ʣ��ڵ�
            System.out.print(list.get(i) + " ");
            list.remove(i);
        }
    }

    /**
     * ��������
     */
    public static void josephRing2(int n ,int m ){

        ListNode head = new ListNode(1);
        ListNode cur = head;
        for(int i = 2; i<= n ; i++){
            ListNode newNode = new ListNode(i);
            cur.next = newNode;
            cur = cur.next;
        }
        cur.next = head; // �ɻ�
        ListNode pre = cur;
        cur = head;
        System.out.println();
        while(cur != pre){      // ����
            for( int i = 1 ;i< m; i++){
                cur = cur.next;
                pre = pre.next;
            }
            System.out.print(cur.val + " ");
            pre.next = cur.next;
            cur = pre.next;
        }
        System.out.print(cur.val + " ");
    }
}
