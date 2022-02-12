package format.BinarySearch;

/**
 * desc: 给定M×N矩阵，每一行、每一列都按升序排列，请编写代码找出某元素。
 */
public class FindValueInMatrix {

    /**
     * 从左下角开始，使用二分法，如果大于则向上，小于则向右，左下角元素是直角上所有元素的分界点，都是有序的，
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix.length-1;
        int j = 0;
        while( i >= 0 && j < matrix[0].length){
            if(matrix[i][j] == target){
                return true;
            }
            if(matrix[i][j] > target){
                i--;
            }
            else{
                j++;
            }
        }
        return false;

    }

    /**
     * 当然右上角也是可以的，时间效率都是稳定的 O（n）
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length-1;
        while( j >= 0 && i < matrix.length){
            if(matrix[i][j] == target){
                return true;
            }
            if(matrix[i][j] > target){
                j--;
            }
            else{
                i++;
            }
        }
        return false;

    }

}
