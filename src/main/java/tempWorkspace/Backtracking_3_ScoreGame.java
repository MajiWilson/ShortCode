package tempWorkspace;

import java.util.HashMap;
import java.util.Map;

/**
 * Class:  ����С�������ĸ����飬��������������������
 * ÿ������ʤ����3�֣��䷽��0�֣�ƽ������Ե�1��
 * Ҫ��������еĿ��ܵı������
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/5/18 , 18:05
 */
public class Backtracking_3_ScoreGame {
    public static void main(String[] args){
        char[][] schedule = {
                {'A', 'B'},
                {'A', 'C'},
                {'A', 'D'},
                {'B', 'C'},
                {'B', 'D'},
                {'C', 'D'}
        };
        Map<Character, Integer> marks = new HashMap<>();
        marks.put('A', 0);
        marks.put('B', 0);
        marks.put('C', 0);
        marks.put('D', 0);
        getPossibleBenchMark( schedule, 0 , marks );
    }
    /* ���û��ݷ����б��������ݽ����������� ��ÿ�α����������ֽ���� �����ڽ������� */
    public static void getPossibleBenchMark(char[][] schedule, int k, Map<Character, Integer> marks){
        if( k == schedule.length ){
            System.out.print( marks.get( 'A' )  + " ");
            System.out.print( marks.get( 'B' )  + " ");
            System.out.print( marks.get( 'C' )  + " ");
            System.out.println( marks.get( 'D' )  + " ");
        }
        else{
            marks.put( schedule[k][0], marks.get(schedule[k][0]) + 3 );
            getPossibleBenchMark(schedule, k+1, marks); // �׷�ʤ��
            marks.put( schedule[k][0], marks.get(schedule[k][0]) - 3 );

            marks.put( schedule[k][1], marks.get(schedule[k][1]) + 3 );
            getPossibleBenchMark(schedule, k+1, marks); // �ҷ�ʤ��
            marks.put( schedule[k][1], marks.get(schedule[k][1]) - 2 );

            marks.put( schedule[k][0], marks.get(schedule[k][0]) + 1 );
            getPossibleBenchMark(schedule, k+1, marks); // ˫����ƽ
            marks.put( schedule[k][0], marks.get(schedule[k][0]) - 1 );/* ˼���� ����ΪʲôҪ�ָ�?*/
            marks.put( schedule[k][1], marks.get(schedule[k][1]) - 1 );
        }
    }

}
