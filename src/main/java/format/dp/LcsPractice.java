package format.dp;

import java.util.Arrays;
import java.util.Random;

/**
 * Class: �������е�����������У�
 * ���Ž�ṹ�������������е����һλ���ԣ������ȣ����Ԫ��һ����LCS�������Ϊ��������ȣ����� S-1 �� T �� S ��T-1 ��LCS�������ֵ����
 *LCS ��һ��ֻ��һ�������������b�������޷������������У�������֪��LCS�ĸ�����
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/22 , 14:19
 */
public class LcsPractice {

    /**
     * lcs
     * @param s1
     * @param s2
     * @return
     */
    public static String  find(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] c = new int[n+1][m+1];
        int[][] b = new int[n+1][m+1];

        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){  //ע��������ź����鳤�Ȳ�һ��
                    c[i][j] = c[i-1][j-1] + 1;
                    b[i][j] = 3;
                } else if(c[i-1][j] > c[i][j-1]){
                    c[i][j] = c[i-1][j];
                    b[i][j] = 2;
                } else{
                    c[i][j] = c[i][j-1];
                    b[i][j] = 1;
                }
            }
        }
        return getLcsString(s1, s2, b);
    }

    public static String getLcsString(String s1, String s2, int[][] record){
        StringBuilder sb = new StringBuilder();
        int i = s1.length();
        int j = s2.length();
        while(i > 0 && j >0){
            if(record[i][j] == 3){
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            } else if(record[i][j] == 2){
                i--;
            } else{
                j--;
            }
        }
        return sb.reverse().toString();
    }


}
