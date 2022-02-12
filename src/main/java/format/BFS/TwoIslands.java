package format.BFS;

import java.util.*;

/**
 * 在给定的二维二进制数组 A 中，存在两座岛。（岛是由四面相连的 1 形成的一个最大组。）
 * 现在，我们可以将 0 变为 1，以使两座岛连接起来，变成一座岛
 * 返回必须翻转的 0 的最小数目。（可以保证答案至少是 1。）
 * @Author maojianwei
 * @Date 2020/8/4 18:19
 **/
public class TwoIslands {
    public static void main(String[] args ){
        int[][] array = {{1,1,1,1,1},
                        {1,0,0,0,1},
                        {1,0,1,0,1},
                        {1,0,0,0,1},
                        {1,1,1,1,1}};
        int[][] array2 = {
                {0,1,0},
                {0,0,0},
                {0,0,1}
        };
        int[][] array3 = {
                {0,1},
                {1,0}
        };
        System.out.println(shortestBridge(array));
        System.out.println(shortestBridge(array2));
        System.out.println(shortestBridge(array3));

    }
    /*思路，先找一个岛， 然后找到边缘，每次向外扩散一层，并更新边缘， 直至第一次接触 */
    public static int shortestBridge(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        boolean[][] mark = new boolean[row][col];
        Queue<int[]> queueIsland = new LinkedList<>();
        Queue<int[]> queueEdge = new LinkedList<>();

        /* 找到第一个1*/
        boolean flag = false;
        for(int i  = 0 ; i< row; i++){
            for( int j = 0; j < col ;j++){
                if( A[i][j] == 1){
                    queueIsland.offer(new int[]{i, j});
                    mark[i][j]= true;
                    flag =true;
                    break;
                }
            }
            if(flag){
                break;
            }
        }

        /* use bfs to find the first island*/
        while(!queueIsland.isEmpty()){
            int parentNum = queueIsland.size();
            for(int i = 0 ;i<parentNum; i++){
                int[] position = queueIsland.poll();
                if(position[0]-1 >=0 && A[position[0]-1][position[1]] == 1 && !mark[position[0]-1][position[1]]){
                    queueIsland.offer(new int[]{position[0]-1, position[1]});
                    mark[position[0]-1][position[1]] = true;
                }
                if(position[0]+1 < row && A[position[0]+1][position[1]] == 1  && !mark[position[0]+1][position[1]]){
                    queueIsland.offer(new int[]{position[0]+1, position[1]});
                    mark[position[0]+1][position[1]] = true;
                }
                if(position[1]-1 >=0  && A[position[0]][position[1]-1] == 1  && !mark[position[0]][position[1]-1]){
                    queueIsland.offer(new int[]{position[0], position[1]-1});
                    mark[position[0]][position[1]-1] = true;
                }
                if(position[1]+1 < col && A[position[0]][position[1]+1] == 1 && !mark[position[0]][position[1]+1] ){
                    queueIsland.offer(new int[]{position[0], position[1]+1});
                    mark[position[0]][position[1]+1] = true;
                }
                /* 如果该位置是边缘点（可以延伸）的话，加入到集合中，后续不断扩散 */
                if( !((position[0]-1 <0  || (position[0] -1 >=0 && A[position[0]-1][position[1]] == 1) ) &&
                        (position[0] + 1>= row || (position[0]+1 < row && A[position[0]+1][position[1]] == 1) ) &&
                        (position[1] - 1<0  || (position[1]-1 >=0 && A[position[0]][position[1]-1] == 1) ) &&
                        (position[1] + 1>= col || (position[1]+1 < col && A[position[0]][position[1]+1] == 1) ) )

                ){
                    queueEdge.offer(position);
                }
            }
        }

        /* 扩散，第一次接触的为最小桥梁的长度 */
        int distance = 0;
        while(!queueEdge.isEmpty()){
            int numParent = queueEdge.size();
            for(int i = 0 ;i< numParent; i++){
                int[] position = queueEdge.poll();
                if(position[0]-1 >=0 ){
                    if(!mark[position[0]-1][position[1]]){
                        if(A[position[0]-1][position[1]] == 1)
                            return distance;
                        else{
                            queueEdge.offer(new int[]{position[0]-1, position[1]});
                            mark[position[0]-1][position[1]] = true;
                        }
                    }
                }
                if(position[0]+1 < row ){
                    if(!mark[position[0]+1][position[1]]){
                        if(A[position[0]+1][position[1]] == 1)
                            return distance;
                        else{
                            queueEdge.offer(new int[]{position[0]+1, position[1]});
                            mark[position[0]+1][position[1]] = true;
                        }
                    }
                }
                if(position[1]-1 >= 0  ){
                    if(!mark[position[0]][position[1]-1]){
                        if(A[position[0]][position[1]-1] == 1)
                            return distance;
                        else{
                            queueEdge.offer(new int[]{position[0], position[1]-1});
                            mark[position[0]][position[1]-1] = true;
                        }
                    }
                }
                if(position[1]+1 < col ){
                    if(!mark[position[0]][position[1]+1]){
                        if(A[position[0]][position[1]+1] == 1)
                            return distance;
                        else{
                            queueEdge.offer(new int[]{position[0], position[1]+1});
                            mark[position[0]][position[1]+1] = true;
                        }
                    }
                }
            }
            distance++;

        }
        return distance;
    }
}
