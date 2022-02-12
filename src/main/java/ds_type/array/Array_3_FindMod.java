package ds_type.array;

/**
 * Class:找出整形数组中的超过一半的数字
 * 思路： 两两比较，不同删除，相同累计，具体实现时利用一个count来统计当前数量最多的值，当不同相消，相同累加。最后保留的值就是结果。
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/4/17 , 19:40
 */
public class Array_3_FindMod {
    public static void main(String[] args){
        int[] array = {1, 2, 3, 4, 2, 2, 1, 1, 1, 2, 1, 1, 1, 9 };
        int count = 0 ;
        int result = array[0];
        for( int num : array){
            if( count == 0 ){
                result = num ;
            }
            if( result == num ){
                count ++ ;
            }
            else{
                count--;
            }
        }
        System.out.println( result );
    }

}
