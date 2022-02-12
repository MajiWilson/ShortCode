package format.dp;

import java.util.Arrays;

/**
 * 300
 * desc: 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 */
public class Lis {
    /**
     * 方法1： 利用最长公共子序列方法, 这个方法不是完全正确的，因为要求严格递增，所以如果{1,1,1,1,1} 的结果会是5而不是1，
     */
    public int lengthOfLIS(int[] nums) {
        int[] sortedNums = new int[nums.length];
        for(int i = 0 ; i<nums.length; i++){
            sortedNums[i] = nums[i];
        }
        Arrays.sort(sortedNums);
        return lcs(nums, sortedNums);
    }

    public int lcs(int[] arr1, int[] arr2){
        int n = arr1.length;
        int m = arr2.length;
        int[][] dp = new int[n+1][m+1];
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=m; j++){
                if(arr1[i-1] == arr2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else if(dp[i-1][j] > dp[i][j-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[n][m];
    }

    /**
     * 方法2： 动态规划， 时间复杂度你n^2
     */
    public static int lis2( int[] data ){
        int n = data.length;
        int[] record = new int[n];
        Arrays.fill(record, 1);
        int max = 1;
        for( int i = 1; i < n ; i++){
            for(int j = i-1; j>=0; j--){  //注意这里不是找第一个小于data[i]的而是所有小于的都要比较一下选择最大的
                if(data[i] < data[i]){
                    record[i] = Math.max(record[i], record[j] + 1);
                }
            }
            if(max < record[i]){
                max = record[i];
            }
        }
        return max;
    }

    /**
     * 方法3： 动态规划，存储的含义不同，dp[]中存储的是一个递增串（不是最终的lis), 但是长度是一样的 时间为nlogn
     * 对于每一个新的元素，要么比dp中所有的都大添加到末尾， 要么要与某个大于它的值替换（最小的大于），替换是为了以后可能成为新的一部分
     */
    public int lis3(int[] nums) {
        final int n = nums.length;
        int[] dp = new int[n] ;
        int m=0;
        for (int i = 0; i < n; i++) {
            int left = 0,right = m-1;
            while (left <= right) {
                int mid = (left + right) >> 1;
                if (dp[mid] >= nums[i]) {
                    right = mid -1;
                } else {
                    left = mid +1;
                }
            }
            dp[++right] = nums[i];
            if (right == m) {
                m++;
            }
        }
        return m;
    }

    /**
     * 练习
     */
    public int lis4(int[] nums) {
        int n = nums.length;
        int[] record = new int[n];
        int count = 0;
        for(int i = 0 ;i< n;i++){
            int left = 0;
            int right = count-1;
            while(left <= count){
                int mid = left + (right-left)/2;
                if(record[mid] >= nums[i]){
                    right = mid-1;
                }
                else{
                    left = mid +1;
                }
            }
            right++;
            record[right] = nums[i];
            if(right == count){
                count++;
            }
        }
        return count;
    }


}
