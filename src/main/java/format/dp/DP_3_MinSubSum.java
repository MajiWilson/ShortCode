package format.dp;

/**
 * Class:
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/22 , 15:33
 */
public class DP_3_MinSubSum {
    private static int n =20;
    public static void main(String[] args) {
        int[] array = {-7 , -12 , 20 , -10 , -16 , 2 , 16,  -24 , 11 , -19 ,  5,  23,  0 , -11,  14,  16 ,  -23 , 23  ,-24 , -22};
        System.out.println("minSubSum: "+ minSubSum(array));
        System.out.println("minSubSum: "+ minSubSum2(array));
    }
    /* ע�� sum[n-1] ���������յĽ�������յĽ���� sum �е����ֵ��ʱ�临�Ӷ�Ϊ O��n��  */
    public static int minSubSum(int[] array){
        int[] sum = new int[n];
        sum[0] = Math.min(array[0], 0 );
        int minSum = sum[0];
        for( int i = 1 ; i < n ;i ++){
            sum[i] = Math.min( 0, sum[i-1] + array[i] );
            if( minSum > sum[i]){
                minSum = sum[i];
            }
        }

        return minSum;
    }


    /**
     * ���Ƶġ� һ����ǰ����ܺ��Ѿ�����������¿�ʼ�ۼ�
     * @param array
     * @return
     */

    public static int minSubSum2(int[] array){
        int sum = 0;
        int minSum = sum;
        for(int i = 0 ;i < array.length ;i++){
            if(sum > 0){
                sum = array[i];
            } else{
                sum += array[i];
            }
            minSum = minSum > sum ? sum : minSum;
        }
        return minSum;
    }
}
