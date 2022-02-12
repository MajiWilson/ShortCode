package ds_type.tree;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 235
 * desc: 二叉搜索树中两个节点的最近公共祖先， 节点自身可以是祖先
 */
public class CommonAncestorInBST {

    /**
     * 除了和二叉树一样的递归算法，还可以利用BST搜索的优势， 分别求到路径，然后找到结果
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathP = getPath(root, p);
        List<TreeNode> pathQ = getPath(root, q);
        TreeNode ancestor = null;
        for(int i = 0 ; i< pathP.size() && i < pathQ.size() ;i++){
            if(pathP.get(i) == pathQ.get(i)){
                ancestor = pathP.get(i);
            }
            else{
                break;
            }
        }
        return ancestor;

    }

    public List<TreeNode> getPath(TreeNode root, TreeNode target){
        List<TreeNode> path = new ArrayList<>();
        TreeNode curNode = root;
        while(curNode != target){
            path.add(curNode);
            if(curNode.val > target.val){
                curNode = curNode.left;
            }
            else{
                curNode = curNode.right;
            }
        }
        path.add(curNode);
        return path;
    }

    /**
     * 递归算法： 上述的效果并不是很好， 这里进一步借助其性质改善
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor2(root.left, p, q);
        }
        else if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        else{
            return root;
        }
    }


}
