package ds_type.tree;


import entity.TreeNode;

/**
 * 树高计算
 */
public class TreeDeep {

    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
