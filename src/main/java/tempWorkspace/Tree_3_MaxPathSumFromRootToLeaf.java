package tempWorkspace;

import entity.Tree;
import entity.TreeNode;

/**
 * Class: ����Ӹ��ڵ㵽Ҷ�ӽڵ�����·���ͣ��ݹ��˼�롣
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/5/11 , 18:57
 */
public class Tree_3_MaxPathSumFromRootToLeaf {
    public static void main(String[] args){
        int[] data = {1,3,2,7,5,6,8,9,-1,10,4,13,-1,-1,6};
        TreeNode root = Tree.generate(data);

        System.out.println( getMaxPathSumFromRoot(root) );
    }
    /* ���������һ�� val ����Ϊ���������  */
    public static int getMaxPathSumFromRoot(TreeNode root){
        if(root == null ){
            return 0;
        }
        int left = getMaxPathSumFromRoot(root.left);
        int right = getMaxPathSumFromRoot(root.right);
        int temp = Math.max(left , right);
        return temp +  root.val;

    }
}
