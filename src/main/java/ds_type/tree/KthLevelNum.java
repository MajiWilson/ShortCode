package ds_type.tree;

import entity.TreeNode;

/**
 *  desc: 二叉树第k层的节点数目
 */
public class KthLevelNum {

    /**
     * 递归算法
     */
    public int kthLevelNum(TreeNode root, int k){
        if(root == null || k <= 0)    // k<=0 用来过滤第一次调用的非法 k 值
            return 0;
        if(root != null && k == 1){  //递归出口
            return 1;
        }
        return kthLevelNum(root.left, k-1) + kthLevelNum(root.right, k-1);
    }
}
