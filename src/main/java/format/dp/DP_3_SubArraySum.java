package format.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * Class:?	给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/4/9 , 12:41
 */
public class DP_3_SubArraySum {

    public static void main(String[] args){
        int[] array = {1,2,3,0,3,4,2,6,0,-3,2,1};//{1,2,3,}、{1，2，3，0}、{3,0,3}、{4,2}、{6}、{6，0}、{6,0,-3,2,1};
        System.out.println(solution1(array, 6));
        System.out.println(solution2(array, 6));
    }

    /* 暴力求解， 两层循环  */
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

    /*动态规划: 最优解 ：记录 sum 为累加和 ， 则 如果之前的sum - k有多少个，那么这次就会有多少个新的， */
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
