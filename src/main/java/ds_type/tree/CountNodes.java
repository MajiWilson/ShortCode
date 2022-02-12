package ds_type.tree;

import entity.TreeNode;

public class CountNodes {
    public int countNodes(TreeNode root){
        if (root == null){
            return  0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;

    }
}
