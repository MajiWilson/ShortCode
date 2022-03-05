package utils;

public class MatrixUtil {

    public static void print(int[][] matrix){
        if(null == matrix){
            return;
        }
        int row = matrix.length;
        for(int i = 0 ;i < row; i++){
            ArrayUtil.printArray(matrix[0]);
        }
    }


}
