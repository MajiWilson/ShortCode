package format.backtracking;

import java.util.*;

/**
 * 给定字符串，给出所有可能的组合（可能有字符重复）
 *
 */
public class AllRangeString {


    /**
     * 递归：回溯， 注意最后不一定是字典序列， 所以需要最后排序，
     * @param str
     * @return
     */
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        char[] letters = str.toCharArray();
        Arrays.sort(letters);
        dfs(letters, 0, res);
        Collections.sort(res);
        return res;
    }

    public void dfs(char[] letters, int k, ArrayList<String> res ){
        if( k == letters.length-1){
            res.add(new String(letters));
        }
        else{
            for( int i = k; k< letters.length; k++ ){
                if(letters[i] == letters[k] && i !=k){    // 重复的就不交换
                    continue;
                }
                char tmp = letters[k];
                letters[k] = letters[i];
                letters[i] = tmp;

                dfs(letters , k+1, res);

                tmp = letters[k];
                letters[k] = letters[i];
                letters[i] = tmp;
            }
        }
    }
}
