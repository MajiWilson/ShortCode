package ds_type.array;

/**
 * Class:?	数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 * 如果数组不存在中心索引，那么我们应该返回 -1。
 * 如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个
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
