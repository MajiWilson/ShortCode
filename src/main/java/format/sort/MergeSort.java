package format.sort;

/**
 * Class: 归并排序
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/2/27 , 21:25
 */
public class MergeSort {

    public void mergeSort(int[] array){
        mergeSort(array, 0, array.length - 1);
    }

    public void mergeSort(int[] array , int left ,int right ) {
        if( left < right ) {
            int mid = left  + (right - left) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid + 1, right);
        }
    }
    public void merge(int[] array, int left , int right , int rightEnd ) {
        int originLeft = left;
        int n = rightEnd - left + 1 ;
        int[] tempArray = new int[n];    // 空间复杂度为 O（n）
        int leftEnd = right-1;
        int i = 0;
        while(left<=leftEnd && right <= rightEnd ){
            if(array[left] < array[right] ){
                tempArray[i++] = array[left++];
            }
            else{
                tempArray[i++] = array[right++];
            }
        }
        while(left<=leftEnd){
            tempArray[i++] = array[left++];
        }
        while(right<=rightEnd){
            tempArray[i++] = array[right++];
        }
        for(i=0; i< n ;i ++){
            array[originLeft++] = tempArray[i];
        }
    }





}
