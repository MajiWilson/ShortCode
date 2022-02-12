package format.twoPointer;

import java.util.ArrayList;
import java.util.List;

/**字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，
 * 同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"

 * @Author maojianwei
 * @Date 2020/8/13 10:39
 **/
public class StringSplit {
    public static void main(String[] args){
        String s = "caedbdedda" ;
        List<Integer> list = partitionLabels(s);
        for(Integer i : list){
            System.out.println(i);
        }
    }
    /* 双指针，同向，  一个执行开始，一个指向最前沿，还有一个工作指针，
    从开始位置出发，每次都会去找当前字符的最后位置，更新前沿，*/
    public static List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        char[] letters = S.toCharArray();
        int n = letters.length;
        int base = 0;
        int frontier =-1;
        for(int i = 0; i< n ;i++ ){
            if(frontier < i && frontier!=-1){
                res.add(frontier - base +1);
                base= i;
                frontier = -1;
            }
            char focusChar = letters[i];
            for(int j = n-1; j>=base; j--){
                if(letters[j] == focusChar){
                    if( j == n-1){
                        res.add(j-base +1);
                        return res;
                    }
                    if(j > frontier)
                        frontier = j;
                    break;
                }
            }
        }
        return res;
    }

    /*双指针，优化时间，避免每次从尾部扫描的重复工作，而是先保存每个字符最后出现的最后一次位置即可last[] */
    public List<Integer> partitionLabels2(String S) {
        int[] last = new int[26];
        for (int i = 0; i < S.length(); i++) {
            last[S.charAt(i) - 'a'] = i;
        }

        int end = 0, start = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if (i == end) {
                res.add(i - start + 1);
                start = i + 1;
            }
        }
        return res;
    }
}
