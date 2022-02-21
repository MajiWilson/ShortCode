package format.sort;

/**
 * Class: ��������
 * ������һ����Χ�ڣ�
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/2/27 , 21:47
 */
public class CountSort {
    //��ֵ��Χ 0 �� N-1
    public static int N = 100;

    public static void countSort(int[] array){
        int[] count = new int[N];
        // ����
        for(int i = 0 ; i< array.length; i++){
            count[array[i]] ++;
        }
        //�ۼ�
        for(int i = 1 ; i< count.length; i++){
            count[i] += count[i-1];
        }
        // ����
        int[] res = new int[array.length];
        for(int i = 0; i < array.length; i++){
            // ע���������ŵ�����, �������Ǵ�0��ʼ��
            res[count[array[i]]-1] = array[i];
            count[array[i]]--;
        }
        // ��ֵ
        for(int i = 0; i< array.length; i++){
            array[i] = res[i];
        }

    }



}
