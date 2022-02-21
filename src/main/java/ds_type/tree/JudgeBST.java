package ds_type.tree;

/**
 *
 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true,否则返回false。假设输入的数组的任意两个数字都互不相同
 [4,8,6,12,16,14,10]  true
 */
public class JudgeBST {

    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0)
            return false;
        if(sequence.length <= 1)
            return true;
        return judge(sequence, 0, sequence.length-2, sequence[sequence.length-1]);

    }

    public boolean judge(int[] arr, int start, int end, int root){
        if(start >= end){    // 如果孩子节点没有或者只有一个不管是大于还是小于root， 都是允许的
            return true;
        }
        int mid = -1;
        int i = start;
        for( ; i<= end; i++){ // 找到第一个大于root的节点， 则理论上左边就是左子树，mid-end 就是右子树
            if(arr[i] >= root){
                mid = i-1;
                break;
            }
        }
        if( i == end+1){
            mid = end;
        }
        for(int j = mid+1; j<= end ; j++){ //继续验证，如果不满足右半部分都大于Root ,则不用继续递归返回错误
            if(arr[j] < root){
                return false;
            }
        }
        if(mid < 0 ){ // 特殊情况，如果全部都是大于root的就不去递归左子树，因为arr[mid]会报错， 而右半部分即使没有也会无妨
            return judge(arr, mid+1, end-1, arr[end]);
        }
        return judge(arr,start,mid-1, arr[mid]) && judge(arr, mid+1, end-1, arr[end]); //均需要满足
    }

}
