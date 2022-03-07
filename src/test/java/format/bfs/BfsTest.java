package format.bfs;

import format.BFS.NumsSquare;
import format.BFS.TwoIslands;
import org.junit.jupiter.api.Test;

public class BfsTest {

    @Test
    public void numSquareTest(){
        NumsSquare.numSquares3(100000);
    }


    @Test
    public void findDistanceBetweenIslandsTest(){
        int[][] array = {
                {1,1,1,1,1},
                {1,0,0,0,1},
                {1,0,1,0,1},
                {1,0,0,0,1},
                {1,1,1,1,1}};

        System.out.println(TwoIslands.getShortestDistance(array));
    }
}
