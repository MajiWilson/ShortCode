package tempWorkspace;

import java.util.Stack;

/**
 * Class: һ�仰���ʵ��򣬱����Ų���˳��
 * I love you, and you ? - > ? you and , you, love, I
 *
 * ˼·�� ��1����ȫ����ת��Ȼ��ֲ�������ת���ɣ��ѵ����� word �ı߽��жϣ�
 * ��2��ʹ��ջ���ռ�Ƚϴ󣬲��ʺϳ�ƪ���£�
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/31 , 23:09
 */
public class String_3_ReverseWords {
    public static void main(String[] args){
        String s = "Alin, you know that, I love you forever!";
        System.out.println( getReverseWordsByStack(s));
    }
    public static String getReverseWordsByStack(String s){

        int n = s.length();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        Stack<String> stack =new Stack<>();
        while( i< n){
            sb.delete(0,sb.length());
            while(i<n && (s.charAt(i) == ' ' || s.charAt(i) == ',' || s.charAt(i) == '.'||  s.charAt(i) == '!')){
                sb.append(s.charAt(i));
                i++;
            }
            if(sb.length() == 0  && i< n ){
                while(i<n && !(s.charAt(i) == ' ' || s.charAt(i) == ',' || s.charAt(i) == '.' ||  s.charAt(i) == '!')){
                    sb.append(s.charAt(i));
                    i++;
                }
            }
            stack.push( sb.toString());
        }
        sb.delete(0,sb.length());
        while(!stack.isEmpty()){
            sb.append( stack.pop());
        }
        return sb.toString();
    }



}
