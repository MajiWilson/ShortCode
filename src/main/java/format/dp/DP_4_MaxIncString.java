package format.dp;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.Arrays;

/**
 * Class:���������ַ�����s[i]��s[i-1],����aaa��abc�ǣ�acb���ǣ�
 * ��n�������ַ�����ѡ�������ƴ����������ƴ������������ַ������ȣ�
 *
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/22 , 21:08
 */
public class DP_4_MaxIncString {
    public static void main(String[] args ){
        String[] strings = {
                "abc",
                "bdefg",
                "hi",
                "hkl",
                "s",
                "op",
                "ijktu",
                "uvwxyz",
                "ch",
                "mn"
        };

        System.out.println(  maxIncString1( sortStringByLastChar(strings) ) );
        System.out.println(  maxIncString2( sortStringByLastChar(strings) ) );
    }
    /* ��������ٷ���O(n^2) ������֤�� */
    public static String maxIncString1(String[] strings){

        int n = strings.length;
        int max = 0;
        String maxString = "";

        StringBuilder s = new StringBuilder();
        for( int i = 0 ; i< n ;i ++ ){
            s.delete(0, s.length());
            s.append(strings[i]);
            for( int j = i+1; j < n ; j++ ){
                if(strings[j].charAt(0) >= s.toString().charAt( s.length()-1 ) ){
                    s.append( strings[j]+" ");
                }
            }

            if(s.length() > max){
                max = s.length();
                maxString = s.toString();

            }
        }
        return maxString;
    }

    /*  ��̬�滮 : ��ռ� dp[i] ��ʾ�� ���ַ���Ϊ��β����� */
    public static String maxIncString2(String[] strings){
        int n = strings.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 0 );
        dp[0] = strings[0].length();
        int result =dp[0];
        int indexMax = 0;
        for(int i = 1 ; i < n ; i ++){
            int start = strings[i].charAt(0);
            int max = 0;
            for( int j = i-1 ; j >= 0 ; j--){
                if ( strings[j].charAt( strings[j].length() -1 ) <= start  && dp[j] > max ){
                    max = dp[j];
                }
            }
            dp[i] = strings[i].length() + max ;
            result = dp[i] > result ? dp[i] : result;
            indexMax = i;
        }
        StringBuilder sb = new StringBuilder();
        int i = indexMax;
        while(i>=0){
            int temp = i;
            sb.append(new StringBuilder(strings[i]).reverse().toString() + " ");
            result -= strings[i].length();
            i--;
            while(i >=0){
                if(dp[i] == result && strings[i].charAt(strings[i].length() -1) <= strings[temp].charAt(0)){
                    break;
                } else{
                    i--;
                }
            }
        }

        return sb.reverse().toString();

    }
    public static String[] sortStringByLastChar(String[] origin){
        int n = origin.length;
        String[] newStrings = new String[n];
        for( int i = 0 ; i < n ; i++ ){
            StringBuilder temp = new StringBuilder();
            newStrings[i] = temp.append(origin[i]).reverse().toString();
        }
        Arrays.sort(newStrings);

        for( int i = 0 ; i < n ; i++ ){
            StringBuilder temp = new StringBuilder();
            newStrings[i] = temp.append(newStrings[i]).reverse().toString();
        }
        return newStrings;


    }



}
