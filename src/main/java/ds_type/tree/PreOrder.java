package ds_type.tree;

import entity.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 144
 * desc: 前序遍历
 */
public class PreOrder {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    /**
     *  递归算法
     */
    public void dfs(TreeNode root, List<Integer> data){
        if(root == null)
            return;
        data.add(root.val);
        dfs(root.left, data);
        dfs(root.right, data);
    }

    /**
     * 非递归算法：借助栈
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        TreeNode curNode;
        while(!stack.isEmpty()){
            curNode = stack.pop();
            res.add(curNode.val);
            if(curNode.right != null){      // 注意这里右节点先入栈，后弹出
                stack.push(curNode.right);
            }
            if(curNode.left!= null){
                stack.push(curNode.left);
            }
        }
        return res;
    }
    /**
     * 非递归算法2：借助栈
     */
    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curNode = root;
        while(curNode != null || !stack.isEmpty()){   // 这种方法的逻辑是先一直遍历到最左边，同时将根节点加入结果，并入栈，然后弹出查看有节点，重复此过程。
            if(curNode!=null){
                res.add(curNode.val);
                stack.push(curNode);
                curNode = curNode.left;
            }
            else{
                curNode = stack.pop().right;
            }
        }
        return res;
    }

}
