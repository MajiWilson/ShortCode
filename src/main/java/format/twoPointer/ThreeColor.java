package format.twoPointer;

/**给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色
。输入: [2,0,2,1,1,0]
 输出: [0,0,1,1,2,2]
 不使用排序
 * @Author maojianwei
 * @Date 2020/8/12 16:23
 **/
public class ThreeColor {
    /*三指针法， i指向第一个非0位置，cur为工作指针， j指向第一个非2位置*/
    public void sortColors(int[] nums) {
        int i = 0;
        int j = nums.length-1;
        int cur = 0;
        while(cur <= j){
            if(nums[cur] == 2){
                nums[cur] = nums[j];
                nums[j] = 2;
                j--;
            }
            else if( nums[cur] == 1){
                cur++;
            }
            else{
                nums[cur] = nums[i];
                nums[i] = 0;
                i++;
                cur++; //之所以这里可以工作指针增加，原因是i除了初始时可能为2外，其余时刻均只能为1或0，
            }
        }

    }

}
