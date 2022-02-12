package format.dp;

import entity.TreeNode;

/**
 * 337
 * desc: 房子只有一个路口，是一课二叉树，同样项连的两个房间不能同时被抢劫，求最大收获
 */
public class Robbery3 {


    /**
     * 利用递归：
     */
    public int rob(TreeNode root) {
        if(root == null){
            return 0;
        }
        int[] res = robTree(root);
        return Math.max(res[0], res[1]);
    }

    /**
     * 返回数组res[0]表示打劫root， res[1] 不打劫root
     * res[0] = 左孩子的res[1] + 右孩子的res[1] + root.val
     * res[1] = 左孩子中较大的 + 右孩子中较大的
     */
    public int[] robTree(TreeNode root){
        if(root == null){
            return new int[2];
        }
        int[] leftRob = robTree(root.left);
        int[] rightRob = robTree(root.right);
        int[] res = new int[2];
        res[0] = leftRob[1] + rightRob[1] + root.val;       // 取
        res[1] = Math.max(leftRob[0],leftRob[1]) + Math.max(rightRob[0], rightRob[1]);      //不取
        return res;
    }


}
