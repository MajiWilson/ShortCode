package format.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47
 * desc: 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 */
public class AllRangeAllowRepeat {

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> perm = new ArrayList<Integer>();
        boolean[] vis = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, ans, 0, perm, vis);
        return ans;
    }

    public static void backtrack(int[] nums, List<List<Integer>> ans, int idx, List<Integer> perm, boolean[] vis) {
        if (idx == nums.length) {
            ans.add(new ArrayList<Integer>(perm));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            /**
             * 这里进行减枝，因为是在某一次批次上进行的，所以相同的元素，只会交换一次；且因为是按顺序的，所以上一个没有使用，自己也不去更新
             */
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            perm.add(nums[i]);
            vis[i] = true;
            backtrack(nums, ans, idx + 1, perm, vis);
            vis[i] = false;
            perm.remove(idx);
        }
    }

}
