package ds_type.tree;

import entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111
 * 树从更节点到叶子节点的最小长度，即最小深度
 */

public class MinDepth {
    /**
     *  bfs , 层序遍历
     */
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        int depth = 1;
        TreeNode curNode = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(curNode);
        while(!queue.isEmpty()){
            int num = queue.size();
            for(int i = 0 ; i< num ;i++){ // 注意这里容易犯错如果写成 for(int i = 0 ; i< group.size() ; i++) 是错的因为队列大小在动态变化
                curNode = queue.poll();
                if(curNode.left == null && curNode.right == null){
                    return depth;
                }
                if(curNode.left != null){
                    queue.offer(curNode.left);
                }
                if(curNode.right != null ){
                    queue.offer(curNode.right);
                }
            }
            depth++;
        }
        return depth;
    }

    /**
     *  递归方法
     */
    public int minDepth2(TreeNode root) {
        if(root==null)  //递归出口1， 空节点
            return 0;
        if(root.left == null && root.right == null){  // 递归出口2，叶子节点
            return 1;
        }
        return Math.min(minDepth2(root.left), minDepth2(root.right)) + 1;

    }
}
