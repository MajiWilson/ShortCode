package format.twoPointer;

/**我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：

 B.length >= 3
 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
例如：输入：[2,1,4,7,3,2,5]
     输出：5
 * @Author maojianwei
 * @Date 2020/8/11 14:54
 **/
public class FindLongestMountain {

    /* 双指针， 同向， 时间为n, 一座一座山峰遍历，更新最大值 */
    public static int longestMountain3(int[] A){
        int n = A.length;
        int max = 0, start = 0;
        while (start < n) {
            int end = start;
            if (end + 1 < n && A[end] < A[end + 1]) {
                while (end + 1 < n && A[end] < A[end + 1])
                    end++;
                if (end + 1 < n && A[end] > A[end + 1]) {
                    while (end + 1 < n && A[end] > A[end + 1])
                        end++;
                    max = Math.max(max, end - start + 1);
                }
            }
            start = Math.max(end, start + 1);
        }
        return max;
    }
    /* 双指针，对每一个peak, 维持反向的两个指针，一直到尽头为止 */
    public static int longestMountain2(int[] A) {
        int n = A.length;
        if (A == null || n < 3) {
            return 0;
        }
        int max = 0;
        for(int i = 1; i < n-1; i++){
            if(A[i-1] < A[i] && A[i]> A[i+1]){ // it is a peak
                int l = i-1;
                int r = i+1;
                while(l-1 >=0 && A[l-1] < A[l]){
                    l--;
                }
                while(r+1<n && A[r+1] < A[r]){
                    r++;
                }
                max = max < (r-l+1)?(r-l+1):max;
                i= r-1;
            }
        }
        return max;
    }
    public static void main(String[] args){
        int[] array = {2,1,4,7,3,2,5};
        System.out.println(longestMountain2(array));
    }
}
