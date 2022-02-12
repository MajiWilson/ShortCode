package ds_type.tree;

import entity.TreeNode;

/**
 * desc : 输出一颗二叉树的镜像
 */
public class MirrorTree {

    /**
     *  递归： 每一个节点都需要进行左右节点的交换
     */
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null)
            return null;
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
    }

}
