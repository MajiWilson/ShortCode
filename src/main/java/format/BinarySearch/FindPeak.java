package format.BinarySearch;

/**
 * 162
 * desc:峰值元素是指其值大于左右相邻值的元素。
 * 给你一个输入nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 */
public class FindPeak {


    /**
     * 如果数组中有且仅有一个山峰，直接用二分查找即可
     * 这里首先可以明确，左侧如果是下降的或者右侧是上升的，边界也视为封顶，因为nums[-1] 和nums[n] 为负无穷
     */
    public int findPeakElement(int[] nums) {
        int i = 0;
        int j = nums.length-1;
        while(i < j){
            int m = (i + j)/2;
            if(nums[m] > nums[m + 1]){  // 如果是下降坡则左边存在封顶
                j--;
            }
            else{ // 上升破则右边存在封顶
                i++;
            }
        }
        return i;

    }

}
