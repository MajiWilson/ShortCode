package format.backtracking;

import java.util.*;

/**
 * 46:
 * desc: 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 */
public class AllRange {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        getAllRange(nums, 0, res);
        return res;
    }

    /**
     * 回溯法
     */
    public void getAllRange(int[] nums, int cur, List<List<Integer>> res){
        if(cur == nums.length -1){ //递归出口
            List<Integer> combination = new ArrayList<>();
            for(int x : nums)
                combination.add(x);
            res.add(combination);
        }
        for(int i = cur; i < nums.length; i++){ //交换后需要交换回来
            int tmp = nums[cur];
            nums[cur] = nums[i];
            nums[i] = tmp;

            getAllRange(nums, cur + 1, res);

            nums[i] = nums[cur];
            nums[cur] = tmp;
        }
    }



}
