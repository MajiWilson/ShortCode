package format.twoPointer;

import java.util.HashMap;
import java.util.Map;

/**请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * @Author maojianwei
 * @Date 2020/8/13 13:51
 **/
public class FindSubStringWithNoRepeat {

    /*双指针法：同向，一个遍历，一个指向最左边开始的位置，借助哈希保存元素和位置
    * 如果元素存在，判断是否上次出现位置在开始位置之后，
    * 如果之后，则需要更新开始位置，并更新当前最大值*/
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1)
            return s.length();
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;
        for( int i = 0 ; i< s.length(); i++ ){
            char ch = s.charAt(i);
            if(map.containsKey(ch)) {
                if (map.get(ch) >= left) {
                    left = map.get(ch) + 1;
                }
            }
            max = Math.max(i - left+1, max);
            map.put(ch,i);
        }
        return max;
    }
    /* 双指针 优化，当然本质没啥区别*/
    public int lengthOfLongestSubstring2(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0;
        int temp = 0;
        char[] ch = s.toCharArray();
        for(int i =0; i< ch.length;i++){
            if(map.containsKey(ch[i])){
                left = Math.max(left,map.get(ch[i])+1);
            }
            temp = Math.max(temp,i-left+1);
            map.put(ch[i],i);
        }
        return temp;
    }

}
