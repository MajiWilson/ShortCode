package tempWorkspace;

import java.util.Arrays;

/**
 * Class: ����LCS �ķ�����
 * ��ռ��ǣ� l[i] ��ʾ�Ե�ǰԪ��Ϊ��β��������У�
 * ��¼�����⣬ÿ�ζ���Ҫ���ݣ����ֵ�һ��С�ڸ�Ԫ�ص�
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/22 , 20:21
 */
public class DP_3_LIS {

    public static void main(String[] args){
        int[] data = { 5, 3, 1, 2, 4, 5, 3, 6, 8, 2, 6,7, 9, 0 , 2};
        System.out.println("lis : " + lis(data) );
    }
    /* ˼·���ڱ������Ļ����ϣ� ��¼�˲������ݣ�����ʱ�������� O(n^2) */
    /* �÷����Ǵ���� ������������������������������������������������������������������������*/
    public static int lis( int[] data ){
        int n = data.length;
        int[] record = new int[n];
        Arrays.fill(record, 0) ;
        record[0] =1;
        int max = 0;
        for( int i = 1; i < n ; i++){
            if(data[i] >= data[i-1]){
                record[i] = record[i-1] + 1 ;//����ĵط���
            }
            else{
                int j = i-1;
                for( ; j >= 0; j--){
                    if(data[j] <= data[i]){
                        break;
                    }
                }
                if( j < 0 ){
                    record[i] = 1;
                }
                else{
                    record[i] = record[j] + 1 ;
                }
            }
            if(max < record[i]){
                max = record[i];
            }
        }
        return max;
    }
    /* �����ǶԵ� */
    public static int lis2( int[] data ){
        int n = data.length;
        int[] record = new int[n];
        Arrays.fill(record, 0) ;
        record[0] =1;
        int max = 0;
        for( int i = 1; i < n ; i++){
            if(data[i] >= data[i-1]){
                record[i] = record[i-1] + 1 ;//����ĵط���
            }
            else{
                int j = i-1;
                for( ; j >= 0; j--){
                    if(data[j] <= data[i]){
                        break;
                    }
                }
                if( j < 0 ){
                    record[i] = 1;
                }
                else{
                    record[i] = record[j] + 1 ;
                }
            }
            if(max < record[i]){
                max = record[i];
            }
        }
        return max;
    }
}
