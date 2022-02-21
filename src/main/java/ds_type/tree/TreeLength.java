package ds_type.tree;

import entity.TreeNode;

/**
 * 543
 * desc: 二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 */
public class TreeLength {

    public static int maxLength = 0;

    public static int getLongestLength(TreeNode root){
        maxLength = 0;
        dfs(root);
        return maxLength;

    }

    /**
     * 思路：
     *  最长路径要么过根节点， 要么不过，第二种需要在中间遍历每个节点时进行判断和更更新
     * 返回结果是以root为起点的最长路径，
     * @param root
     * @return
     */
    public static int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftMaxLength = dfs(root.left);
        int rightMaxLength = dfs(root.right);
        if(leftMaxLength + rightMaxLength + 1 > maxLength){
            maxLength = leftMaxLength + rightMaxLength + 1;
        }
        return leftMaxLength > rightMaxLength ? leftMaxLength + 1 : rightMaxLength +1 ;
    }
}
