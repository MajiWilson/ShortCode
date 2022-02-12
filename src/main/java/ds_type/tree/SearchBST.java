package ds_type.tree;

import entity.TreeNode;

/**
 * 700
 * desc: 二叉搜索树的搜索
 */
public class SearchBST {

    //非递归写法
    public TreeNode searchBST(TreeNode root, int val) {
        while(root != null){
            if(root.val == val)
                break;
            if(root.val < val)
                root = root.right;
            else
                root = root.left;
        }
        return root;
    }

    //递归写法
    public TreeNode searchBST2(TreeNode root, int val) {
        if (root == null){
            return null;
        }
        if (root.val == val){
            return root;
        } else if (root.val < val){
            return searchBST2(root.right, val);
        } else{
            return searchBST2(root.left, val);
        }
    }
}
