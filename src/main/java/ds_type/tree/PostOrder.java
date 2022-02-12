package ds_type.tree;

import entity.TreeNode;

import java.util.*;

/**
 * 145
 * desc : 后序遍历
 */
public class PostOrder {

    /**
     * 递归算法
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    public void dfs(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        dfs(root.left, res);
        dfs(root.right, res);
        res.add(root.val);
    }

    /**
     * 递归算法1: 基于前序遍历， 注意两点：
     *  （1）先将左孩子入栈，后访问，这与标准前序列是相反的；
     *  （2）结果序列需要reverse，才是 （ left -> right -> root)
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        TreeNode curNode;
        while(!stack.isEmpty()){
            curNode  = stack.pop();
            res.add(curNode.val);
            if(curNode.left != null){
                stack.push(curNode.left);
            }
            if(curNode.right != null){
                stack.push(curNode.right);
            }

        }
        Collections.reverse(res);
        return res;
    }

    /**
     * 递归算法2: 基于前序遍历， 注意两点：
     *  （1）先查看右孩子，然后看左孩子， 与前序相反
     *  （2）结果序列需要reverse，才是 （ left -> right -> root)
     */
    public List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curNode = root;
        while(curNode != null || !stack.isEmpty()){
            if(curNode != null){
                res.add(curNode.val);
                stack.push(curNode);
                curNode = curNode.right;
            }
            else{
                curNode = stack.pop().left;
            }
        }
        Collections.reverse(res);
        return res;
    }
    /**
     * 递归算法3
     */
    public List<Integer> postorderTraversal4(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curNode = root;
        TreeNode visited = null;
        while(!stack.isEmpty() || curNode != null){
            if(curNode != null){
                stack.push(curNode);
                curNode = curNode.left;
            }else{
                curNode = stack.peek();
                if(curNode.right != null && curNode.right != visited){ //如果右孩子存在且没有被访问，则暂时不弹出，先去访问右子树
                    curNode = curNode.right;
                }else{    // 没有右孩子 或者 右孩子已经访问过了（右子树），则访问根节点，并向上回退
                    res.add(curNode.val);
                    visited = curNode;
                    stack.pop();
                    curNode = null;
                }
            }
        }

        return res;
    }
}
