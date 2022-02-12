package format.BinarySearch;

/**
 * 形如V形的数组， 不存在重复的数字
 */
public class FindNumInValley {

    public int findMin(int[] nums){
        int i = 0 ;
        int j = nums.length-1;
        while(i < j ){
            int m = i + (j - i)/2;
            if( nums[m]  < nums[m+1] ){  //升破, 注意这里使用 j = m 而不是 就= m-1， 因为nums[m】可能就是谷底
                j = m;
            }
            else{ //降坡
                i = m + 1;   //这时候不会出现上面的问题，因为nums[m]坑定不是谷底
            }
        }
        return nums[j];
    }

    /**
     * 思路1： 先找到最小下标， 然后两边分别二分查找即可。
     */
    public int findNum(int[] nums, int target){
        return -1;
    }
}

