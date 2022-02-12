package format.sort;

/**
 * Class: ��������
 * ������һ����Χ�ڣ�
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/2/27 , 21:47
 */
public class CountSort {
    public int N = 100;

    public void countSort(int[] array){
        int[] count = new int[N];    // �ռ临�Ӷ�O��N��
        int n = array.length;
        for(int i = 0; i< N ;i ++){  // ��ʼ��Ϊ0 ��java��Ҳ����ʡ��
            count[i] = 0;
        }
        for(int i = 0 ; i< n; i++){  // ����
            count[array[i]]++;
        }
        for(int i =1 ;i< N ;i++){    // �ۼ�
            count[i] += count[i-1];
        }
        int[] result = new int[n];
        for(int i =0;i< n ;i++){     // ���
            result[ count[ array[i] ] -1 ]  = array[i];   // ע����� �� ��ŵ�ϸ��
            count[array[i]]--;
        }
        for(int i = 0; i< n ;i++){   // ����
            array[i] =result[i];
        }
    }
}
