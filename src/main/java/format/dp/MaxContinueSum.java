package format.dp;

/**
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 */
public class MaxContinueSum {

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i= 0; i< nums.length ;i++){
            if(sum >= 0){
                sum += nums[i];
            }
            else{
                sum = nums[i];
            }
            max = Math.max(max, sum);
        }
        return max;
    }


}
