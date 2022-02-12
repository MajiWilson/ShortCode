package format.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 77
 * desc: 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class CombinationSum2 {

    /**
     * 回溯法： 从当前位置开始 n -cur + 1 个值中选择一个，然后继续选择值的后面去选，可以避免重复
     */
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> combination = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        getNum(1, n, k, combination, res);
        return res;
    }
    public void  getNum(int cur, int n, int k, List<Integer> combination, List<List<Integer>> res){
        if(k == 0){  //找到组合
            res.add(new ArrayList<>(combination));
            return;
        }
        if( cur > n || n-cur+1 < k){ // 剪枝
            return;
        }
        for( int i = cur; i <= n ; i++){
            combination.add(i);
            getNum(i + 1, n, k-1, combination, res);
            combination.remove(combination.size()-1);
        }
    }


}
