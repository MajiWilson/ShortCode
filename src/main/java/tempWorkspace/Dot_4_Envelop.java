package tempWorkspace;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**��Ƭ��װ��һϵ�е��ŷ�A?=?{a1,??a2,??...,??an}�С�С���Ѿ����̵��й����˺ܶ���ŷ⣬��ϣ���ܹ�����ͷ�о����ܶ���ŷ��װ��Ƭ��
 * Ϊ��ֹ��Ƭ���ŷⱻ�𻵣�
 * ֻ�г����С���ŷ��ܹ�װ���Щ���ŷ⣬ͬ�ߴ���ŷⲻ����װ����Ƭ���ŷⶼ�����۵���
 *
 * �����������飬ÿ��ĵ�һ�а�����������n, w, h��1<=n<=5000, 1<=w, h<=10^6���ֱ��ʾС����ͷ���ŷ������Ϳ�Ƭ�Ĵ�С��
 * ��������n���У�ÿ������������wi��hi��Ϊ��i���ŷ�Ĵ�С��1<=wi, hi<=10^6��
 * 3 3 3
 * 5 4
 * 12 11
 * 9 8
 * ��� �� 3
 * 1 3 2
 * Class:
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/4/18 , 14:07
 */
public class Dot_4_Envelop {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while( in.hasNextInt() ){
            int n = in.nextInt();
            int[][] envlope = new int[n+1][2];
            envlope[0][0] = in.nextInt();
            envlope[0][1] = in.nextInt();
            for( int i = 1 ; i<= n ;i ++){
                envlope[i][0] = in.nextInt();
                envlope[i][1] = in.nextInt();
            }
            Integer[] result = getBestSeal(envlope);
            if(result == null ){
                System.out.println(0);
            }
            else{
                System.out.println( result.length);
                for( int order : result){
                    System.out.print( order + " ");
                }
            }
            System.out.println();
        }
    }
    public static Integer[] getBestSeal(int[][] envelop){
        List<Integer> result = new ArrayList<>();
        int n = envelop.length;
        int[] card = envelop[0];
        while(true){
            int area = Integer.MAX_VALUE;
            int temp = -1;
            for( int i = 1; i < n ; i++){
                if( envelop[i][0] >= card[0] && envelop[i][1] >= card[1] && envelop[i][0] * envelop[i][1] > card[0]*card[1]
                && envelop[i][0] * envelop[i][1] < area ){
                    area = envelop[i][0] * envelop[i][1];
                    temp = i ;
                }
            }
            if(temp == -1){
                break;
            }
            else{
                result.add(temp);
                card = envelop[temp];
            }
        }
        Integer[] array = new Integer[result.size()];
        result.toArray(array);
        return array;
    }

}
