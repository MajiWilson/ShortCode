package format.twoPointer;

/**
 * @Author maojianwei
 * @Date 2020/8/10 16:15
 **/
public class TwoSum {
    public static void main(String[] args){
        int[] nums ={9, 3, 2, 10 ,5,-3};
        int[] index = twoSum(nums, 7);
        for( int i : index){
            if( i != -1){
                System.out.println(i+": "+nums[i]);
            }
            else{
                System.out.println(" no match !");
                break;
            }

        }
    }
    public static int[] twoSum(int[] nums, int target) {
        return null;
    }

}
