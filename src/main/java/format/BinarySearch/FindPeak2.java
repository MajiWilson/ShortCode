package format.BinarySearch;

/**
 * 852
 * desc: 给你由整数组成的山脉数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i 。
 * 必然存在
 **/
public class FindPeak2 {


    /**
     * 简单的二分查找
     */
    public int peakIndexInMountainArray(int[] arr) {
         int i = 0;
         int j = arr.length-1;
         while( i< j){
             int m = i + (j - i)/2;
             if(arr[m] > arr[m+1]){
                 j = m;
             }
             else{
                 i = m+1;
             }
         }
         return i;
    }

    /**
     * 直接遍历
     */
    public int peakIndexInMountainArray2(int[] arr) {
        int i=0;
        for(int a=0;a<arr.length-1;a++){
            if(arr[a]<arr[a+1]){
                continue;
            }else{
                i=a;
                break;
            }
        }
        return i;
    }



}
