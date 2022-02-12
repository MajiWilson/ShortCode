package tempWorkspace;

import java.util.Arrays;

/**
 * Class:��Ҫ����һ����󣬵��ʿ���ѧ���Ѿ�̽������������е���Դ�ֲ���
 * ���ô�СΪ?m * n ������ grid �����˱�ע��ÿ����Ԫ���е������ͱ�ʾ��һ��Ԫ���еĻƽ�������
 * ����õ�Ԫ���ǿյģ���ô���� 0��
 * Ϊ��ʹ������󻯣�����Ҫ�����¹��������ɻƽ�
 * ÿ���󹤽���һ����Ԫ���ͻ��ռ��õ�Ԫ���е����лƽ�
 * ��ÿ�ο��Դӵ�ǰλ�������������ĸ������ߡ�
 * ÿ����Ԫ��ֻ�ܱ����ɣ����룩һ�Ρ�
 * ���ÿ��ɣ����룩�ƽ���ĿΪ 0 �ĵ�Ԫ��
 * �󹤿��Դ������� ����һ�� �лƽ�ĵ�Ԫ�����������ֹͣ��
 ���룺grid = [[0,6,0],[5,8,7],[0,9,0]]
 �����24
 ���ͣ�
 [[0,6,0],
 [5,8,7],
 [0,9,0]]
 һ���ռ����ƽ��·���ǣ�9 -> 8 -> 7

 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/4/16 , 10:53
 */
public class BackTrack_4_GoldMiner {
    public static void main(String[] args){
        int[][] grid = {
                {1, 0, 7, 0, 0, 0 },
                {2, 0, 6, 0, 1, 0 },
                {3, 5, 6, 7, 4, 2 },
                {4, 3, 1, 0, 2, 0 },
                {3, 0, 5, 0, 20,0 }
        };
        System.out.println(getMaximumGold(grid));
    }
    /*�û��ݷ�����ȷ����������ȷ���Ϊ60 */
    public static int getMaximumGold(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int[] result = new int[2];
        result[1] = 0;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if( grid[i][j]!=0 ){
                    reInitVisited(visited);
                    result[0] = 0;
                    backTrack(grid, i, j, result, visited);
                }
            }
        }
        return result[1];
    }
    public static void backTrack(int[][] grid, int row, int col, int[] earnings, boolean[][] visited){
            earnings[0] += grid[row][col];
            earnings[1] = earnings[0] > earnings[1] ? earnings[0] : earnings[1];
            visited[row][col] = true;
            if( row-1 >= 0 && grid[row-1][col]!=0 && !visited[row-1][col] ){
                backTrack(grid, row-1, col ,earnings, visited);
                earnings[0] -= grid[row-1][col];
            }
            if( row+1 < grid.length && grid[row+1][col]!=0 && !visited[row+1][col] ){
                backTrack(grid, row+1, col ,earnings, visited);
                earnings[0] -= grid[row+1][col];
            }
            if( col-1 >= 0 && grid[row][col-1] !=0 && !visited[row][col-1] ){
                backTrack(grid, row, col-1 ,earnings, visited);
                earnings[0] -= grid[row][col-1];
            }
            if( col+1 <grid[0].length  && grid[row][col+1] !=0 && !visited[row][col+1] ){
                backTrack(grid, row, col+1 ,earnings, visited);
                earnings[0] -= grid[row][col+1];
            }
    }
    public static void reInitVisited(boolean[][] visited){
        for( int i = 0 ; i < visited.length ; i ++){
            Arrays.fill(visited[i], false);
        }
    }
}
