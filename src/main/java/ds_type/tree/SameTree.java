package ds_type.tree;

import entity.TreeNode;

/**
 * 100
 * desc: 相同的树，结构和指完全相同
 *
 */
public class SameTree {

    //逻辑： 树相同，不仅根节点值相同， 左右子树都相同
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) //递归出口1
            return true;
        if( p == null || q == null || p.val != q.val) // 递归出口2
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right); //左右子树都应该是相同的

    }
}
