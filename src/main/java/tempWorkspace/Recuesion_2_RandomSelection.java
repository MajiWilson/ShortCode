package tempWorkspace;

/**
 * Class: ����������ڵ�K��Ԫ��
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/20 , 22:32
 */
public class Recuesion_2_RandomSelection {
    public static int[] data = {4,2,3,6,7,5,1,0,9,8};
    public static void main(String[] args){
        for( int i = 0 ;i < data.length; i++){
            int[] temp = data.clone();
            System.out.println( randomSelect(temp ,0,data.length-1 , i+1) );
        }

    }
    /* ����ʱ���������˳���ֵ�� ʹ�û��ַ����и��� */
    public static int randomSelect(int[] data, int left, int right, int k ){

        if(left == right ) {
           return data[left];
        }
        if(left> right){
            return -1;
        }
        int p = partition(data, left, right);
        int order = p-left+1;    /* �ؼ���������p  h�� k �Ƚϣ�����ʹ�� p-left+1 �� k �Ƚ�  */
        if( order == k){
            return data[p];
        }
        else if( order > k ){
            return randomSelect(data, left, p-1, k);
        }
        else{
            return randomSelect(data, p+1, right, k-order);
        }
    }
    public static int partition(int[] data, int left, int right){
        int pivot = data[right];
        int i = left-1;
        int j = left;
        while(j<right){
            if(data[j] < pivot ){
                i++;
                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
            j++;
        }
        i++;
        data[right] = data[i];
        data[i] = pivot;
        return i;
    }
}
