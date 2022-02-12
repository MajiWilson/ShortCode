package ds_type.tree;

import entity.TreeNode;

/**
 * desc: 给定一棵二叉搜索树，请找出其中第k大的节点
 */
public class KthNumInBST {

    /**
     * 方法1： 引入getTreeSize()方法， 思想简单， 但是具有较多的重复计算， 效率较低
     */
    public int kthLargest(TreeNode root, int k) {
        k = getTreeSize(root) - k + 1;
        int rank;
        while(true){
            rank = getTreeSize(root.left) + 1;
            if( rank == k){
                return root.val;
            }else if(rank > k ){
                root = root.left;
            }
            else{
                root = root.right;
                k -= rank;
            }
        }
    }

    public int getTreeSize(TreeNode root){
        if(root == null){
            return 0;
        }
        return getTreeSize(root.left) + getTreeSize(root.right) + 1;
    }

    /**
     * 方法2： 引入全局变量，中序遍历（ right -> root ->left ), 时间复杂度为 O（k)
     *
     */
    int res, k;
    public int kthLargest2(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }
    public void dfs(TreeNode root) {
        if(root == null || k == 0) // 递归出口，空节点或者已经变量了前面K大的节点了，
            return;
        dfs(root.right);
        if(--k == 0)
            res = root.val;
        dfs(root.left);
    }
}
