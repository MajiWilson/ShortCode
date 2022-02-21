package format.sort;

/**
 * Class: �鲢����
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/2/27 , 21:25
 */
public class MergeSort {

    /**
     * ����ӿ�
     * @param array
     */
    public static void mergeSort(int[] array){
        mergeSort(array, 0, array.length - 1);
    }

    /**
     * ���ν�������Ȼ��鲢
     * @param array
     * @param left
     * @param right
     */
    public static void mergeSort(int[] array, int left , int right){
        if(left < right){
            int m = (left + right)/2;
            mergeSort(array, left, m);
            mergeSort(array, m+1, right);
            merge(array, left, m+1, right);
        }
    }

    /**
     * �ϲ��������飺��Ҫ��������ռ�
     * @param array
     * @param left
     * @param mid
     * @param right
     */
    public static void merge(int[] array, int left, int mid, int right){
        int[] temp = new int[right-left +1];
        int i = left;
        int j = mid;
        int k = 0;
        while( i< mid && j <= right){
            if(array[i] > array[j]){
                temp[k++] = array[j++];
            }else{
                temp[k++] = array[i++];
            }
        }
        while(i< mid){
            temp[k++] = array[i++];
        }
        while(j <= right){
            temp[k++] = array[j++];
        }
        for(i = left, k = 0; i<=right; i++ ){
            array[i] = temp[k++];
        }


    }









}
