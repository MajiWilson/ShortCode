package format.BinarySearch;

/**
 * 4
 * desc:给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 */
public class FindMid2 {

    /**
     * 方法1： 先归并，整体排序， 然后找出中位数， 时间和空间均是O(n)
     * 如果不合并，而是使用两个指针，虽然空间可以为O（1），但时间是一样的，需要比较所有元素；
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] newArray = merge(nums1, nums2);
        int n = newArray.length;
        if( n% 2 != 0){
            return newArray[n/2]*1.0;
        }
        return (newArray[n/2 - 1] + newArray[n/2])/2.0;
    }

    public int[] merge(int[] array1, int[] array2){
        int n = array1.length;
        int m = array2.length;
        int[] result = new int[n + m];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < n && j < m){
            if(array1[i] < array2[j]){
                result[k++] = array1[i++];
            }
            else{
                result[k++] = array2[j++];
            }
        }
        while(i < n){
            result[k++] = array1[i++];
        }
        while(j < m){
            result[k++] = array2[j++];
        }
        return result;
    }


    /**
     * 二分查找： 时间可以到 O( log（m+n）)
     * 相当于找第k小的值
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }

    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2)
            return getKth(nums2, start2, end2, nums1, start1, end1, k);
        if (len1 == 0)
            return nums2[start2 + k - 1];

        if (k == 1) // 如果在两个数组中找第一小的，返回较小值即可
            return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) { // 舍弃小的左半部分
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }
        else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }

}
