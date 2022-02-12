package tempWorkspace;

/**
 * Class: ��̬�滮
 * ���Ž������� ��ĳ��Ϊ��β����Ӷκ�Ҫô��0 Ҫô������һ����Ϊ��β�����е���Ӷκ� ���ϸ�Ԫ�ص�ֵ
 * ����b[j] ��ʾ �� a[j] Ϊ��β�����е���Ӷκ�
 * if j == 1 b[j] = max{0, a[1] };
 * if j != 1 b[j] = max{0, b[j-1] + a [j] };
 * * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/22 , 12:40
 */
public class DP_3_MaxSubSum3 {
    private static int n =20;
    public static void main(String[] args) {
        int[] array = {-7 , -12 , 20 , -10 , -16 , 2 , 16,  -24 , 11 , -19 ,  5,  23,  0 , -11,  14,  16 ,  -23 , 23  ,-24 , -22};
        System.out.println("maxSubSum: "+ maxSubSum(array));
    }
    /* ע�� sum[n-1] ���������յĽ�������յĽ���� sum �е����ֵ��ʱ�临�Ӷ�Ϊ O��n��  */
    public static int maxSubSum(int[] array){
        int[] sum = new int[n];
        sum[0] = Math.max(array[0], 0 );
        int maxSum = sum[0];
        for( int i = 1 ; i < n ;i ++){
            sum[i] = Math.max( 0, sum[i-1] + array[i] );
            if( maxSum < sum[i]){
                maxSum = sum[i];
            }
        }
        return maxSum;
    }

}
