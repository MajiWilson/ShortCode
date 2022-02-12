package tempWorkspace;

import java.util.Scanner;

/**
 * Class:��¥�ݵķ�ʽ��3�֣�һ����һ�㡢һ��������һ�������㣬
 * ������������ԭ������¥�ݵĶ����У�һ��������ķ�ʽֻ��ʹ��һ�Σ�
 * ����������K��¥��ʱ���ж����ַ�ʽ��
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/5/8 , 12:19
 */
public class Series_5_ClimbStirs3Ways {
    public static boolean flag = true;
    public static void main(String[] args) {
        int n = 30;
        for(int i = 1 ; i< n ;i++) {
            long t1 = System.currentTimeMillis();
            int a = climbByRecursion(i);
            long t2 = System.currentTimeMillis();
            long t3 = System.currentTimeMillis();
            int b = climbByDP(i);
            long t4 = System.currentTimeMillis();
            System.out.println((a == b) + "  " + a + "  " + b);
            System.out.println( "time:" + (t2-t1) + " , " + (t4-t3) );
        }
    }

    /* �ݹ飺 ���ӶȺܸ�*/
    public static int climbByRecursion(int n ){
        if( n == 0 || n == 1 ){
            return 1;
        }
        if( n == 2 ){
            return 2;
        }
        int n3 = 0, n2 = 0, n1 = 0;
        if(flag){
            flag = false;
            n3 = climbByRecursion( n -3);
            flag = true;
        }
        n2 = climbByRecursion(n-2);
        n1 = climbByRecursion(n-1);
        return n1 + n2 + n3;
    }
    /*��̬�滮��˼·���е����ϣ�����i���ԣ� Ҫô�� i-1 ֱ��һ����ת�� Ҫô�� i-2 ֱ��������ת��Ҫô��i-3����ֱ����ת��
    * ���ǵ������������Ҫ�ų�i-3���Ѿ���ת��һ�ε����������֤��i-3���ֻ��һ���������������
    * �������������i-3 ��ȥ��3��ʣ��i-6�����ֳ������֣�������������ߺ��ұߣ���������������ֻ��һ����2�������˻���
    * ʱ��Ч�ʸߺܶ�*/
    public static int climbByDP(int n ){
        if( n == 1 || n == 2){
            return n;
        }
        if( n == 3){
            return 4;
        }
        int[] stepsBy2 = climbBy2Steps(n);
        int num1 = 1;
        int num2 = 2;
        int num3 = 4;
        for(int i = 4; i<= n ; i++){
            int temp = num3 + num2 + num1 ;
            int numOfRest = i - 6;
            int numOfInappropriate = 0;
            for(int j = 0 ; j<= numOfRest ; j++ ){
                numOfInappropriate += stepsBy2[j] * stepsBy2[numOfRest-j];
            }
            num1 = num2;
            num2 = num3;
            num3 = temp - numOfInappropriate;
        }
        return num3;
    }
    public static int[] climbBy2Steps( int n ){
        int[] result = new int[n+1];
        result[0] = 1;
        result[1] = 1;
        result[2] = 2;
        for(int i = 3; i <= n ; i++){
            result[i] = result[i-1] + result[i-2];
        }
        return result;
    }
}
