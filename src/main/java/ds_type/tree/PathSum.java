package ds_type.tree;

import entity.TreeNode;

/**
 * 112
 * desc: 从 根结点 到 叶子节点 是否存在和为targetSum的路径
 */

public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){  //递归出口1，空节点
            return false;
        }
        targetSum -= root.val;
        if(root.left == null && root.right == null && targetSum == 0){  // 递归出口2， 叶子节点
            if(targetSum == 0) {
                return true;
            }
            return false;
        }
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);// 递归操作， 只要有一条路径满足即可
    }


}
