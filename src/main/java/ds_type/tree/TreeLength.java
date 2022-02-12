package ds_type.tree;

import entity.TreeNode;

/**
 * 543
 * desc: 二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 */
public class TreeLength {

    public int maxLen = 0;

    // 计算最长节点长度，然后减1即可
    public int diameterOfBinaryTree(TreeNode root) {
        findMaxPath(root);
        return maxLen == 0 ? 0 : maxLen - 1;
    }

    public int findMaxPath(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftLen = findMaxPath(root.left) + 1;
        int rightLen = findMaxPath(root.right) + 1;
        if(leftLen + rightLen - 1 > maxLen){ // 更新最大的
            maxLen = leftLen+rightLen-1;
        }
        return Math.max(leftLen, rightLen); //递归选择更大的长度

    }
}
