package format.dp;

/**
 * 512
 * desc: 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 * 不能返回0
 */
public class ChangeMoney2 {

    /**
     * 方法1： 动态规划： dp[i][j]表示使用i种面额组合金额j的方案数
     */
    public int change(int amount, int[] coins) {
        if(amount == 0 || coins == null)
            return 1;
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        for(int i = 0; i<= n; i++){   //这两个初始化是没有必要的实际上
            dp[i][0] = 0;
        }
        for(int i = 0; i<= amount; i++){
            dp[0][i] = 0;
        }
        for(int i = 1; i<= n; i++){
            for(int j = 1; j<= amount; j++){
                if(j < coins[i]){
                    dp[i][j] = dp[i-1][j];
                }
                else if(j == coins[i]){
                    dp[i][j] = dp[i-1][j] + 1;
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i]];
                }
            }
        }
        return dp[n][amount];
    }


    /**
     * 方法2： 动态规划的优化， 空间的优化, 不过这样没有那么好理解了
     * @param amount
     * @param coins
     * @return
     */
    public int change2(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1; // 初始化
        for(int i=0; i<coins.length; i++){
            for(int j=coins[i]; j<=amount; j++){
                dp[j] += dp[j-coins[i]];  // 其实相当于dp[i][j] = dp[i-1][j] + 0 或者 1 或 dp[i][j-coins[i], 实际上 dp[i][j-coins[i] 在一唯数组中等于 dp[i-1][j-coins[i]
            }
        }
        return dp[amount];
    }

}
