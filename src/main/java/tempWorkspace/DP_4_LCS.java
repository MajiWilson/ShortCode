package tempWorkspace;

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
public class DP_4_LCS {
    private static int n=26;
    private static int m=23;
    private static int[][] c=new int[n+1][m+1];
    private static int[][] b=new int[n+1][m+1];


    public static void main(String[] args) {
        Random random1 = new Random(1);
        Random random2 = new Random(3);
        String s1="";
        for(int i =0;i<n;i++) {
            s1+=(char)(random1.nextInt(13)+'a');
        }
        String s2="";
        for(int i =0;i<m;i++) {
            s2+=(char)(random2.nextInt(13)+'a');
        }
        System.out.println("s1: "+s1);
        System.out.println("s2: "+s2);
        String lcs = Lcs(s1,s2);
        System.out.println("lcs:"+lcs);
        System.out.println(c[n][m]);
    }
    /*  �Ե�����*/
    public static String Lcs(String s1, String s2) {
        /* ��ʼ�� */
        for(int i = 0 ; i < n ;i ++){
            Arrays.fill(c[i], 0);
        }

        for(int i =1;i<=n;i++) {
            for(int j =1;j<=m;j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    c[i][j] = c[i-1][j-1]+1;
                    b[i][j]=3;
                }
                else if(c[i-1][j] >c[i][j-1]) {
                    c[i][j] = c[i-1][j];
                    b[i][j] = 2;
                }
                else {
                    c[i][j] = c[i][j-1];
                    b[i][j] = 1;
                }
            }
        }
        printC();
        printB(s1,s2);
        return findLcs(s1);
    }
    public static String findLcs(String s1) {
        StringBuilder lcs = new StringBuilder();
        int i =n,j=m;
        while(i>0 && j>0) {
            if(b[i][j] == 3) {
                lcs.append(s1.charAt(i-1));
                i--;
                j--;
            }
            else if(b[i][j] == 2){
                i--;
            }
            else {
                j--;
            }
        }
        return lcs.reverse().toString();
    }
    public static void printC(){
        System.out.println("************** C *****************");
        for(int i = 0 ;i < c.length; i++){
            for( int j = 0 ; j < c[0].length; j++){
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void printB(String s1,String s2) {
        System.out.printf("%2c%c", ' ','|');
        System.out.printf("%3c", ' ');
        for(int i=1;i<=m;i++) {
            System.out.printf("%3c",s2.charAt(i-1));
        }
        System.out.println();
        for(int i =0;i<=m;i++) {
            System.out.printf("%3s","---");
        }
        System.out.println();
        System.out.printf("%3s", " ");
        for(int i=0;i<=m;i++) {
            System.out.printf("%3d",b[0][i]);
        }
        System.out.println();
        for(int i =0;i<=m;i++) {
            System.out.printf("%3s","---");
        }
        System.out.println();
        for(int i =1;i<=n;i++) {
            System.out.printf("%2c%c", s1.charAt(i-1),'|');
            for(int j=0;j<=m;j++) {
                System.out.printf("%3d", b[i][j]);
            }
            System.out.println();
            for(int x =0;x<=m;x++) {
                System.out.printf("%3s","---");
            }
            System.out.println();
        }
    }

}
