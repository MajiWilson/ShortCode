package ds_type.array;

import java.util.ArrayList;

/**
 * 找出数组中最小的k个数
 */
public class FindMinKnum {

    /**
     * 分治算法：
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if(k == 0 || k > input.length){
            return res;
        }
        int left = 0;
        int right = input.length-1;
        while(true){
            int p = partition(input, left, right);
            int num = p -left + 1;
            if(num == k){
                for(int i = left; i<= p; i++){
                    res.add(input[i]);
                }
                return res;
            }
            else if(num > k ){
                right = p-1;  // 不包括分界点
            }
            else{
                for(int i = left; i<= p; i++){
                    res.add(input[i]);
                }
                k -=  num;
                left = p+1;  //不包括分界点
            }
        }
    }

    public int partition(int[] arr, int left, int right){
        int pivot = arr[right];
        int i = left;
        int j = left -1;
        while(i < right){
            if(arr[i] < pivot){
                j++;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
            i++;
        }
        j++;
        arr[right] = arr[j];
        arr[j] = pivot;
        return j;
    }

}
