package ds_type.matrix;

import org.junit.jupiter.api.Test;

public class MatrixTest {


    @Test
    public void findMaxHeightInMap(){
        int[][] map = {
                {0, 0, 1},
                {1, 0, 0},
                {0, 0, 0}
        };

        System.out.println(GetMaxInMap.getMaxHeight(map));
    }

    @Test
    public void findMaxHeightInMap2(){
        int[][] map = {
                {0, 0, 1},
                {1, 0, 0},
                {0, 0, 0}
        };

        System.out.println(GetMaxInMap.getMaxHeight2(map));
    }
}
