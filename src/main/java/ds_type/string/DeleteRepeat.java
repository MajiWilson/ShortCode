package ds_type.string;

import java.util.Stack;

/**
 * 1047
 * desc:删除字符串中的所有相邻重复项,给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们
 * 输入："abbaca"
 * 输出："ca"
 * 注意： 题意中说明没有AAA这样大于两个连续重复，否则下列解法是有问题的。
 */
public class DeleteRepeat {

    /**
     * 使用栈，每次和栈顶元素进行比较
     */
    public String removeDuplicates(String S) {
        char[] chars = S.toCharArray();
        Stack<Character> letters = new Stack<>();
        for(int i = 0 ;i < chars.length ; i++ ){
            if(!letters.isEmpty() && chars[i] == letters.peek() ){
                letters.pop();
            }
            else {
                letters.push(chars[i]);
            }
        }
        StringBuilder result= new StringBuilder();
        while( !letters.isEmpty() ){
            result.append( letters.pop());
        }
        return result.reverse().toString();

    }

    /**
     *双指针， 一个指向最终位置，不断更新，  一个指向遍历位置，不断向前
     */
    public String removeDuplicates2(String S){
        int n = S.length();
        char[] letters = S.toCharArray();
        int j = 0;
        for( int i =0 ; i < n ; i++, j++){
            letters[j] = letters[i];
            if (j != 0 && letters[j] == letters[j-1]) {
                j -= 2;  // 两个都不要，指针后退
            }
        }
        return new String(letters, 0, j);
    }



}
