package format.dp;

/**
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 */
public class MaxContinueSum {

    /**
     * 一直累加即可：当出现小于零的时候直接放弃重新开始
     * 可以证明这就是最优解：如果sum < 0 sum + cur < cur, 每一次都是最优解
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            if (sum >= 0) {
                sum += num;
            } else {
                sum = num;
            }
            max = Math.max(max, sum);
        }
        return max;
    }



}
