package ds_type.tree;

import entity.TreeNode;


/**
 * 110
 * desc: 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1
 */
public class JudgeBalancedTree {
    /**
     * 递归算法：从上到下，每次计算树高，中间涉及重复计算，效率很低
     */
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        int leftDepth = treeDeep(root.left);
        int rightDepth = treeDeep(root.right);
        return Math.abs(leftDepth-rightDepth) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int treeDeep(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(treeDeep(root.left), treeDeep(root.right)) + 1;
    }
    /**
     * 递归算法2： 有任何子树不平衡时就剪枝向上传递， -1表示不平衡， 否则返回树高即可。
     */
    public boolean isBalanced2(TreeNode root) {
        return dfs(root) >= 0;
    }

    public int dfs(TreeNode root){
        if(root == null)
            return 0;
        int left = dfs(root.left);
        if(left == -1)    // 及时剪枝
            return -1;
        int right = dfs(root.right);
        if(right == -1)
            return -1;
        if(Math.abs(left -right) > 1)
            return -1;
        return Math.max(left, right) + 1;  // 返回树高
    }
}
