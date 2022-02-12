package ds_type.tree;

import entity.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 94
 * desc: 中序遍历
 */
public class InOrder {

    /**
     * 递归算法
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    public void dfs(TreeNode root, List<Integer> res){
        if(root == null)
            return;
        dfs(root.left, res);
        res.add(root.val);
        dfs(root.right, res);
    }

    /**
     * 非递归算法：
     * 逻辑： 一直到最左， 入栈不加入结果，然后出栈，访问节点，然后访问节点的右子树
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curNode = root;
        while(curNode != null || !stack.isEmpty()){
            if(curNode != null){
                stack.push(curNode);
                curNode = curNode.left;
            }
            else{
                curNode = stack.pop();
                res.add(curNode.val);
                curNode = curNode.right;
            }
        }
        return res;
    }



}
