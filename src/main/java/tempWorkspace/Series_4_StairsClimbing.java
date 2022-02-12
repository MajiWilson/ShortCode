package tempWorkspace;

import java.util.Scanner;

/**
 * Class: n �����ݣ�һ����1�������������ַ�����һ����1����2����3�������ַ����� һ����2����3�������ٷ�����
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/2/29 , 22:37
 */
public class Series_4_StairsClimbing {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println( solutionOne(n)+" ");
        System.out.println( solutionTwo(n)+" ");
        System.out.println( solutionThree(n)+" ");
    }
    public static int solutionOne( int n ){
        if(n ==0 || n == 1 || n==2){
            return n ;
        }
        else{
            return solutionOne(n-1) + solutionOne(n-2);
        }
    }
    public static int solutionTwo( int n ){
        if(n==0 || n == 1 || n== 2){
            return n ;
        }
        if( n ==3){
            return 4;
        }
        else{
            return solutionTwo(n-1) + solutionTwo(n-2) +solutionTwo(n-3);
        }
    }
    public static int solutionThree( int n ){
        if(n==0 || n == 1){
            return 0 ;
        }
        if( n==2 || n ==3){
            return 1;
        }
        else{
            return solutionThree(n-2) +solutionThree(n-3);
        }
    }


}
