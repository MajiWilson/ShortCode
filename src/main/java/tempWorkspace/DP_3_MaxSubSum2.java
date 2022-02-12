package tempWorkspace;

/**
 * Class: ���η��������⣺
 * ������ ��Ӷ�Ҫô����ߣ�Ҫô���ұߣ�Ҫô����е㣬���ߵ����ֵ�������ս�
 *
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/22 , 12:34
 */
public class DP_3_MaxSubSum2 {

    private static int n =20;
    public static void main(String[] args) {
        int[] array = {-7 , -12 , 20 , -10 , -16 , 2 , 16,  -24 , 11 , -19 ,  5,  23,  0 , -11,  14,  16 ,  -23 , 23  ,-24 , -22};
        System.out.println("maxSubSum: "+ maxSubSum(array, 0 , n-1));
    }
    /*���η���ʱ�临�Ӷ�Ϊ O��nlog n)*/
    public static int maxSubSum(int[] array,int left,int right) {
        if(left == right)
            return array[left];
        else {
            int mid =( left+right)/2;
            int leftMax = maxSubSum(array,left,mid); //case 1
            int rightMax = maxSubSum(array,mid+1,right); //case 2
            int midMax = maxMidSubSum(array,left,mid,right); //case 3
            //������ģ�Ҫô����ߣ�Ҫô���ұߣ�Ҫô���Ǻ���е��
            int max = leftMax > rightMax ? leftMax : rightMax;
            max = max > midMax ? max : midMax ;
            return max;
        }
    }
    /*  ��Ҫע�⣺ ���ص����ٰ��� mid �� mid+1 ����ֵ�ĺͣ��������� */

    public static int maxMidSubSum(int[] array, int left, int mid, int right) {
        int leftSum =0;
        int temp1 = Integer.MIN_VALUE;
        for(int i = mid ;i>=left;i--) {//��߼������ͣ������ģ��ӵ����Ϊֹ��
            leftSum += array[i];
            if(leftSum > temp1 ) {
                temp1 = leftSum;

            }
        }
        int rightSum =0;
        int temp2 = Integer.MIN_VALUE;
        for(int j = mid+1 ; j<= right; j++) {//�ұ߼������ͣ�Ҳ�������ģ��ӵ����Ϊֹ
            rightSum += array[j];
            if(rightSum > temp2) {
                temp2 = rightSum;
            }
        }
        return temp1 + temp2;
    }
}
