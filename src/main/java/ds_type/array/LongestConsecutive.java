package ds_type.array;

/**
 * 128. 最长连续序列
 */
//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
//请你设计并实现时间复杂度为 O(n) 的算法解决此问题。

import java.util.HashSet;
import java.util.Set;

/**
 * 假设不重复：思路： 哈希方式理论上效率比排序后遍历高）
 */
public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums ){
            numSet.add(num);
        }

        int longestConsecutive = 0;
        for (int num : nums) {
            // 避免重复的判断
            if (!numSet.contains( num -1)) {
                int curNum = num;
                int curLength = 1;
                while (numSet.contains(curNum + 1)) {
                    curLength++;
                    curNum++;
                }
                longestConsecutive = Math.max(curLength, longestConsecutive);
            }
        }
        return longestConsecutive;
    }

}
