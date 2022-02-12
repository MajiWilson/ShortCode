package format.dp;

import java.util.Arrays;

/**
 * 322
 * desc: 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回-1。
 */
public class ChangeMoney {

    /**
     * 贪心算法, 错误， 因为可能出现因为选择一个较大的面额，然后后面无法兑换的问题；
     */
    public int coinChange(int[] coins, int amount) {
        int count = 0;
        Arrays.sort(coins);
        for(int i = coins.length-1; i >=0 && amount >0; i--){
            while(amount >= coins[i]){
                count++;
                amount-=coins[i];
            }
        }
        if(amount != 0){
            return -1;
        }
        else{
            return count;
        }
    }

    /**
     * 动态规划
     */
    public int coinChange2(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1); // 更新
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

}
