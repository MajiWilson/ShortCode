package ds_type.tree;

import entity.TreeNode;

/**
 * desc: 二叉树中是否包含给定的节点
 */
public class HasNode {

    public boolean hasNode(TreeNode root, TreeNode target){
        if(root == null)
            return false;
        if(root == target)
            return true;
        boolean leftRes = hasNode(root.left, target);
        if(leftRes)      // 这里是剪枝的作用， 找到了就不用看右子树了
            return true;
        else{
            return hasNode(root.right, target);
        }
    }

}
