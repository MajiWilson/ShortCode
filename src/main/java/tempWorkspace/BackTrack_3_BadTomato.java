package tempWorkspace;

import java.util.ArrayList;

/**
 * Class:/*���㷨�Ĺ����ǣ����������У���Ԫ�ص�ֵΪ0��1��2��
 *  * ����ֵΪ2����������Ը�Ⱦ���������ҵ�Ԫ���е�1��ʹ֮���2��
 *  * �󾭹�����ʱ��󣬾���Ԫ�ز��ڲ���仯�����ж��Ƿ������1��
 *
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/3/22 , 19:41
 */
public class BackTrack_3_BadTomato {
    private static int n= 0;
    private static int m = 0;
    private static int[][] matrix=null;
    public static void main(String[] args) {
        n = 6;
        m = 8;
        matrix =new int[n][m];
        for(int i =0;i<n;i++) {
            for(int j =0;j<m;j++) {
                matrix[i][j] = ((int)(Math.random()*100))%3;
            }
        }
        printMatrix();
        int time = change1To2();
        if(contains1()) {
            System.out.println("all tomato died: "+time);
        }
        else {
            System.out.println("some tomato survived : "+time);
        }
    }
    /* ����˼·�� ʵ����û���õ����ݣ�һ�δα�����ÿ�α�����ʱ�����ҵ������ѵ�λ�ã�Ȼ��ͳһ��Ⱦ
    * ���������Ż��� �����Ѿ����ֵ�2 ���Ըĳ��������ֱ���֮���ٴ����ж� */

    public static int change1To2() {
        int time =0;
        boolean flag =false;
        while(flag == false) {
            flag =true;
            ArrayList<int[]> list = new ArrayList<>();

            for(int i =0;i<n;i++) {
                for(int j=0;j<m;j++) {
                    if(matrix[i][j] ==2) {
                        if( (i-1>=0 && matrix[i-1][j] ==1) ||
                                (j-1>=0 && matrix[i][j-1] ==1) ||
                                (i+1<n  && matrix[i+1][j] ==1) ||
                                (j+1<m  && matrix[i][j+1] ==1) ) {
                            flag =false;
                            int[] x= new int[2];
                            x[0]=i;
                            x[1]=j;
                            list.add(x);
                        }
                    }

                }
            }
            for(int[] entry :list) {
                int p = entry[0];
                int q = entry[1];
                if(p-1>=0 && matrix[p-1][q] ==1 ){
                    matrix[p-1][q] =2;
                }
                if(q-1>=0 && matrix[p][q-1] ==1 ){
                    matrix[p][q-1] =2;
                }
                if(p+1<n && matrix[p+1][q] ==1 ){
                    matrix[p+1][q] =2;
                }
                if(q+1<m && matrix[p][q+1] ==1 ){
                    matrix[p][q+1] =2;
                }
            }
            list.clear();
            printMatrix();
            time++;
        }
        return time-1;


    }
    public static boolean contains1() {
        for(int i =0;i<n;i++) {
            for(int j =0;j<m;j++) {
                if(matrix[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void printMatrix() {
        System.out.println("-----------------");
        for(int i =0;i<n;i++) {
            for(int j =0;j<m;j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("-----------------");
    }

}
