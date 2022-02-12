package ds_type.tree;

import entity.TreeNode;

/**
 * 236
 * desc: 找到该树中两个指定节点的最近公共祖先, 注意一个节点可以是自己的祖先
 */
public class CommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        if(leftNode != null && rightNode != null){
            return root;
        }
        if(leftNode == null)
            return rightNode;
        else
            return leftNode;
    }

}
