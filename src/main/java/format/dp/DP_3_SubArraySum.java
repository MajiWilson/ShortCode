package format.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. ��Ϊ K ��������	����һ�����������һ������ k������Ҫ�ҵ��������к�Ϊ k ��������������ĸ�����
 * ���룺nums = [1,1,1], k = 2
 * �����2
 *
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/4/9 , 12:41
 */
public class DP_3_SubArraySum {

    public static void main(String[] args){
        int[] array = {1,2,3,0,3,4,2,6,0,-3,2,1};//{1,2,3,}��{1��2��3��0}��{3,0,3}��{4,2}��{6}��{6��0}��{6,0,-3,2,1};
        System.out.println(solution1(array, 6));
        System.out.println(solution2(array, 6));
    }

    /* ÿһ��λ�ÿ�ͷ����ͳ���ۻ����ɣ� ������� N2�� ����ѭ��  */
    public static int solution1(int[] array, int k){
        int n = array.length;
        int count = 0;
        for(int i = 0 ; i< n ; i++ ){
            int sum = 0;
            for( int j = i ;j < n ; j++){
                sum += array[j];
                if( sum == k){
                    count++;
                }
            }
        }
        return count;
    }

    /*��̬�滮: ���Ž� ����¼ sum Ϊ�ۼӺͣ�ǰ׺�ͣ�  �� �����֮ǰ��sum - k�ж��ٸ�����ô��ξͻ��ж��ٸ��µģ�
            ���裨k =70),
                ��λ��i ��ʱ��  Prefix (i) = 100, ����֮ǰ���ֹ�ǰ׺��Ϊ 30���������Ϊ���������ұ����ģ�����֪��һ�����ڣ�
                ��λ��j(j < i) Prefix (j) = 30, ��j-i֮��һ�����������Һ�Ϊ70��
                *��Ȼ��һ��ֻ��һ��j, Ҳ�п�����j ,l , m (��<i),j-i��l-i��m-i֮�䶼���������Һ�Ϊ70��
                *�ص���ÿһ��Ԫ�ض���Ҫ���Լ���ǰ׺�ʹ����ϣ���У� ����Ҫ�ڳ�ʼ����ʱ������ǰ׺��Ϊ0�������������ͳһ����

    *  */
    public static int solution2(int[] array, int k){
        int n = array.length;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        for( int i = 0 ; i < n ;i++){
            sum += array[i];
            if( map.containsKey(sum - k )){
                count += map.get(sum - k );
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }


    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1);
        for (int i = 0 ;i < nums.length; i++) {
            sum += nums[i];
            if (prefixCount.containsKey(sum - k)) {
                count += prefixCount.get(sum-k);
            }
            prefixCount.put(sum, prefixCount.getOrDefault(sum, 0) + 1);
        }
        return count;

    }


}
