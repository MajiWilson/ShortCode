package ds_type.tree;

import entity.TreeNode;

/**
 * esc: 给定一棵二叉搜索树，请找出其中第k个节点
 */
public class KthNumInBST2 {

    int res, k;
    public int kthNum(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    /**
     * 中序遍历（ left -> root -> right ）
     */
    public void dfs(TreeNode root) {
        if(root == null || k == 0) // 递归出口 & 剪枝,及时停止
            return;
        dfs(root.left);
        if(--k == 0)
            res = root.val;
        dfs(root.right);
    }




}
