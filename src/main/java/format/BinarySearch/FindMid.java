package format.BinarySearch;

/**
 * 4
 * desc
 * 有序数组：从中间随意截断，前面放后面，找出中位数比如： 5781234  -> 4
 */
public class FindMid {

    /**
     * 二分查找找到断点的下标，然后就可以知道中位数了
     */
    public double findMid(int[] array){
        int n = array.length;
        int i = 0 ;
        int j = n-1;
        int b = 0;
        while(  i < j){
            int m = ( i + j)/2;
            if(array[m] > array[m+1]){
                b = m+1;
                break;
            }
            if(array[0] > array[m]){
                j--;
            }
            else{
                i++;
            }

        }
        int left =  (n + 1)/2;
        int right = (n + 2)/2;
        if(n - b + 1 >= right){
            return (array[n + left - 1] + array[n + right - 1]) /2.0;
        }
        if(n - b + 1 == left){
            return (array[0] + array[n-1])/2.0;
        }
        return (array[left - n + b -2] + array[right -n +b -2])/2.0;

    }
}
