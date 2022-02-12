package ds_type.tree;

import entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class BSTToLinkedList {

    /**
     * 方法1： 先中序遍历将所有节点按照最终顺序存储，然后一依次调整指针即可， 这里借助队列，空间复杂度较高
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        dfs(pRootOfTree, queue);
        TreeNode head = queue.poll();
        head.left = null;
        TreeNode preNode = head;
        TreeNode curNode;
        while(!queue.isEmpty()){
            curNode = queue.poll();
            curNode.left = preNode;
            preNode.right = curNode;
            preNode = curNode;
        }
        preNode.right = null;
        return head;
    }

    public void dfs(TreeNode root, Queue<TreeNode> queue){
        if(root != null){
            dfs(root.left, queue);
            queue.offer(root);
            dfs(root.right, queue);
        }
    }

    /**
     * 方法2： 在遍历的时候就开始 调整， 使用头插法， 所以顺序不是典型的左 中  右 而是 右 中 左，
     * 如果使用尾插法则左 中 右 且需要位置一个尾指针；
     */
    TreeNode list = null;
    public TreeNode Convert2(TreeNode pRootOfTree) {
        if(pRootOfTree == null)
            return pRootOfTree;
        Convert(pRootOfTree.right);
        if(list == null){
            list = pRootOfTree;
        } else {
            list.left = pRootOfTree;
            pRootOfTree.right = list;
            list = pRootOfTree;
        }
        Convert(pRootOfTree.left);

        return list;
    }


}
