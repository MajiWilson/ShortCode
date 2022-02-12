package format.backtracking;

/**
 * 200
 * desc: 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 */
public class IslandNum {

    public int numIslands(char[][] grid) {
        int count = 0;
        for( int i = 0; i< grid.length; i++){
            for(int j = 0; j< grid[0].length; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(i, j, grid);
                }
            }
        }
        return count;
    }

    public void dfs(int row, int col, char[][] grid){
        grid[row][col] = '0';
        if(row-1 >= 0 && grid[row-1][col] == '1'){
            dfs(row-1, col, grid);
        }
        if(row+1 < grid.length && grid[row+1][col] == '1'){
            dfs(row+1, col, grid);
        }
        if(col-1 >= 0 && grid[row][col-1] == '1'){
            dfs(row, col-1, grid);
        }
        if(col+1 < grid[0].length && grid[row][col+1] == '1'){
            dfs(row, col+1, grid);
        }

    }
}
