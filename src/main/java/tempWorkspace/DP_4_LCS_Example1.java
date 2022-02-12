package tempWorkspace;

import java.util.Arrays;

/**
 * Class:���һ���ַ���S���������ַ���T���Ӷ���,��S = T + T,
 *  * ���Ǿͳ�S����ƽ����,����"","aabaab","xxxx"����ƽ����.
 * ţţ������һ���ַ���s,�������ţţ��s���Ƴ������ٵ��ַ�,
 * ��ʣ�µ��ַ�����һ��ƽ������
 * ���仰˵,�����ҳ�s��������в�����������й���һ��ƽ������
 * ˼·�ǣ������з֣������ִ���LCS�ĸ������
 *
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/22 , 15:07
 */
public class DP_4_LCS_Example1{
    public static void main(String[] args) {
        String s = "dafcdgqdefragchdegtof";// acdefacdef
        int result = 0;
        int n = s.length();
        for(int i =1;i<n;i++) {
            int temp = lcs(s.substring(0,i),s.substring(i,n));
            if(result < temp) {
                result = temp;
            }
        }
        System.out.println(result*2);
    }
    public static int lcs(String s1,String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] c = new int[n+1][m+1];
        for(int i =0;i<=n;i++) {
            Arrays.fill(c[i], 0);
        }
        for(int i =1; i <= n; i++) {
            for(int j =1; j <= m; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    c[i][j] = c[i-1][j-1]+1;
                }
                else if( c[i-1][j] > c[i][j-1] ) {
                    c[i][j] = c[i-1][j];
                }
                else {
                    c[i][j] = c[i][j-1];
                }
            }
        }
        return c[n][m];
    }

}

