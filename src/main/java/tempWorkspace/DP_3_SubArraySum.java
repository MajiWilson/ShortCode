package tempWorkspace;

import java.util.HashMap;
import java.util.Map;

/**
 * Class:?	����һ�����������һ������ k������Ҫ�ҵ��������к�Ϊ k ��������������ĸ�����
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

    /* ������⣬ ����ѭ��  */
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

    /*��̬�滮: ���Ž� ����¼ sum Ϊ�ۼӺ� �� �� ���֮ǰ��sum - k�ж��ٸ�����ô��ξͻ��ж��ٸ��µģ� */
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

}
