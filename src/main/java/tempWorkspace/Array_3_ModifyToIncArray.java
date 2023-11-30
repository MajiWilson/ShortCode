//package tempWorkspace;
//
//import org.omg.CORBA.FREE_MEM;
//
///**
// * Class:����һ������Ϊ n ���������飬�����ж��� ��� �ı� 1 ��Ԫ�ص�����£��������ܷ���һ���ǵݼ����С�
// * ���ı�һ��Ԫ��ʹ֮��Ϊ���ϸ����������
// *
// * Created by Master SkyWalker
// * May the force be with you !
// * 2020/4/20 , 18:00
// */
//public class Array_3_ModifyToIncArray {
//    public static void main(String[] args){
//        int[] array = {2,3,3,2,4};
//        System.out.println( modifyArray(array) );
//    }
//    /* ˼·�� ���ҳ�������еĸ������������С�� n- 1 ��������Ҫ��  */
//    public static boolean modifyArray(int[] array){
//        int n = lis(array);
//        return n >= array.length -1 ? true : false;
//
//    }
//    public static int lis(int[] array){
//        int n = array.length;
//        int[] record = new int[n];
//        record[0] = 1;
//        int max = 0;
//        for( int i = 1 ; i< n ; i++ ){
//            int num = 0;
//            int index = -1;
//            for( int j = i-1; j >= 0; j-- ){
//                if(array[j] <= array[i]){
//                    if( record[j] + 1  > num ) {
//                        num = record[j] + 1;
//                        index = j;
//                    }
//                }
//            }
//            record[i] = index == -1 ?  1: num;
//            max = record[i] > max ? record[i] : max;
//        }
//        return max;
//
//    }
//
//    /*����ʱ�临�ӶȽϸߣ����ܽϲ�����Ż� */
//    public static boolean modifyArray2(int[] nums){
//        int count=0;
//        for(int i=0; i<nums.length-1; i++)
//        {
//            if(nums[i]>nums[i+1])
//            {
//                if(count==1)
//                {
//                    return false;
//                }
//                if(i==0)
//                {
//                    nums[i]=nums[i+1]-1;
//                    count++;
//                    continue;
//                }
//                if(nums[i-1] < nums[i+1] )
//                {
//                    count++;
//                    nums[i]=nums[i-1];
//                }else{
//                    count++;
//                    nums[i+1]=nums[i];
//                }
//            }
//        }
//        return true;
//    }
//
//
//
//
//}
