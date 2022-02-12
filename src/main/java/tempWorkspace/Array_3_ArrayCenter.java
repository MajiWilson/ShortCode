package tempWorkspace;

/**
 * Class:?	���������������������Ԫ����ӵĺ͵����Ҳ�����Ԫ����ӵĺ͡�
 * ������鲻����������������ô����Ӧ�÷��� -1��
 * ��������ж��������������ô����Ӧ�÷��������ߵ���һ��
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/4/4 , 17:06
 */
public class Array_3_ArrayCenter {
    public static void main(String[] args){
        int[] array1 = {1,2,3,4,5,3,3,3,3,3};
        int[] array2 = {1,2,3,4,5,6,7,8,9,10};
        System.out.println( getArrayCenter(array1) );
        System.out.println( getArrayCenter(array2) );
    }
    public static int getArrayCenter(int[] array){
        if(array == null || array.length <= 1 ){
            return -1;
        }
        int leftSum = 0 ;
        int rightSum = 0;
        int n = array.length;
        for( int i = 0 ;i < n ;i ++){
            rightSum += array[i];
        }
        for( int i = 0; i < n ;i ++){
            leftSum += array[i];
            rightSum -= array[i];
            if(leftSum == rightSum ){
                return i;
            }
        }
        return -1;

    }
}
