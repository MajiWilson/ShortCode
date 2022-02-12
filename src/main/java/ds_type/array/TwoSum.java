package ds_type.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1
 * desc:给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，
 *      并返回他们的数组下标, 可以认为一个数组中只有一个满足要求的答案。
 **/
public class TwoSum {

    /* 先排序 ， 双指针，得到值， 然后找到索引 ，返回索引*/
    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] tempNum = new int[n];
        for( int i = 0; i< n; i++){
            tempNum[i] = nums[i];
        }
        Arrays.sort(tempNum);
        int left = Integer.MIN_VALUE;
        int right = Integer.MAX_VALUE;
        for(int i = 0, j = n-1; i < j ; ){
            int sum = tempNum[i] + tempNum[j];
            if(sum == target ){
                left = tempNum[i];
                right = tempNum[j];
                break;
            }
            else if( sum > target){
                j--;
            }
            else{
                i++;
            }
        }
        int[] result = new int[]{-1,-1};
        boolean flag = false;
        if(left != Integer.MIN_VALUE){  // 这里引入变量flag， 是因为如果left和right相同， 不至于返回同一个索引两次，
            for( int i = 0 ; i< n ;i++){
                if(nums[i] == left && !flag){
                    result[0] = i;
                    flag = true;
                    continue;
                }
                if(nums[i] == right){
                    result[1] = i;
                    continue;
                }
            }

        }
        return result;
    }
    /* 哈希方式 */
    public static int[] twoSum2(int[] nums, int target) {
        int max = 2047;
        int length = nums.length;
        int[] targetArray = new int[max + 1];
        for (int i = 0;i < length;i++) {
            int num = target - nums[i];
            int index = num & max;
            if (targetArray[index] != 0) {
                return new int[]{i, targetArray[index] - 1};
            }
            targetArray[nums[i] & max] = i + 1;
        }
        return null;
    }
    /* map方式 ，时间效率高，但是空间占用较大*/
    public static int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            else{
                map.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
