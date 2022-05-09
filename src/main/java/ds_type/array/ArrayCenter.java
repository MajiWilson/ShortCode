package ds_type.array;

/**
 * Class:?	���������������������Ԫ����ӵĺ͵����Ҳ�����Ԫ����ӵĺ͡�
 * ������鲻����������������ô����Ӧ�÷��� -1��
 * ��������ж��������������ô����Ӧ�÷��������ߵ���һ��
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/4/4 , 17:06
 */
public class ArrayCenter {
    public static int findArrayCenter(int[] array){
        if(array == null){
            return -1;
        }
        int leftSum = 0;
        int rightSum = 0;
        for(int i = 0 ; i< array.length; i++){
            rightSum += array[i];
        }

        for(int i = 0 ;i < array.length; i++){
            rightSum -= array[i];
            if(leftSum == rightSum){
                return i;
            }
            leftSum += array[i];
        }
        return -1;
    }
}
