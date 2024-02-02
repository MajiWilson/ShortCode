package ds_type.matrix;

/**
 * 463. 岛屿的周长
 * 简单
 * 717
 * 相关企业
 * 给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。
 *
 * 网格中的格子 水平和垂直 方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 *
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 */
public class RoundOfIsland {
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        if (n==0) {
            return 0;
        }
        int m = grid[0].length;

        int round = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j=0; j < m ; j++){
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }
        return round;
    }

    public int dfs(int[][] grid, int row, int col){
        int n = grid.length;
        int m = grid[0].length;

        //递归出口
        if(row < 0 || col < 0 || row >= n || col >= m){
            return 1 ;
        }
        if(grid[row][col] == 0){
            return 1;
        }
        if(grid[row][col] == 2){
            return 0;
        }
        grid[row][col] = 2;
        return
                dfs(grid, row-1, col) +
                dfs(grid, row+1, col) +
                dfs(grid, row, col-1) +
                dfs(grid, row,col +1);

    }

}
