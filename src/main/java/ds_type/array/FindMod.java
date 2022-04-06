package ds_type.array;

/**
 * Class:�ҳ����������еĳ���һ�������
 * ˼·�� �����Ƚϣ���ͬɾ������ͬ�ۼƣ�����ʵ��ʱ����һ��count��ͳ�Ƶ�ǰ��������ֵ������ͬ��������ͬ�ۼӡ��������ֵ���ǽ����
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/4/17 , 19:40
 */
public class FindMod {

    /**
     * ���û�����ǰ�������� �ǲ���ȷ�ģ�
     * @param array
     * @return
     */

    public static int findMod(int[] array){
        if( array == null ){
            return -1;
        }
        if(array.length ==1){
            return array[0];
        }

        int cur = array[0];
        int count = 1;
        for( int i = 1; i< array.length; i++){
            if( array[i] == cur){
                count++;
            } else {
                count--;
            }
            if(count == 0){
                cur = array[i];
                count = 1;
            }
        }
        return cur;
    }

}
