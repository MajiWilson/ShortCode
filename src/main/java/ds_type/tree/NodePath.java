package ds_type.tree;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * desc： 给定一个节点，找到从根节点到其路径
 */
public class NodePath {


    public List<TreeNode> getPath(TreeNode root, TreeNode target){
        List<TreeNode> path = new ArrayList<>();
        if(root ==null || target == null)
            return path;
        findPath(root, target, path);
        path.add(target);
        return path;
    }

    /**
     * 前序遍历： 如果找到该节点直接返回，没有找到则从孩子上找， 如果孩子上也没找到，则这个子树上就没有找到
     */
    public boolean findPath(TreeNode root, TreeNode target, List<TreeNode> path){
        if(root == target){
            return true;
        }
        path.add(root);
        boolean res = false;
        if(root.left!= null){
            res = findPath(root.left, target, path);
        }
        if(!res && root.right != null){
            res = findPath(root.right, target, path);
        }
        if(!res){
            path.remove(path.size()-1); // 这个子树不在路径上需要删掉
        }
        return res;
    }


}
