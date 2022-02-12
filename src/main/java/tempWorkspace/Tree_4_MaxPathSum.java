package tempWorkspace;

import entity.TreeNode;
import utils.Tree;

/**
 * Class:
 * Created by Master SkyWalker
 * May the force be with you !
 * 2020/5/11 , 18:40
 */
public class Tree_4_MaxPathSum {
    /* ȫ�����Ž� */
    public static int ans = Integer.MIN_VALUE;

    public static void main(String[] args){
        int[] data = {1,2,3,4,5,6,7};
        TreeNode root = Tree.generate(data);
        System.out.println( maxPathSum(root) );
    }
    public static int maxPathSum(TreeNode root) {
        if(root == null)
            return 0;
        dfs(root);
        return ans;
    }
    /* ˼·��ÿһ���ڵ㶼Ҫ�����������ڻ���ÿһ���ڵ��ʱ�򶼿����ҵ������ýڵ�����·���ͣ����·������Ҫ���ϸ��£�
    ͬʱÿһ�εݹ鶼Ҫ�����Ըýڵ�Ϊroot��������꣬ʵ�������·���Ͳ���������ã����ǹ����н��и��µġ�
    ����ĳ�ڵ�Ϊ�������·���������������
    ��1�� �������������������������������Ϊ��������Ϊ�ڵ㱾��
    ��2���������������������������������Ϊ���� ��Ϊ�ڵ㱾��һ������ֵ��ӵĺ�
    ��3������������������Ϊ�����ұ�С�ڵ���0�� ��Ϊ������������� + �ڵ�ֵ
    ��4�� ����������������Ϊ�������С�ڵ���0 �� ��Ϊ������������� + �ڵ�ֵ��*/
    private static int dfs(TreeNode root) {
        if(root == null)
            return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int temp = Math.max(left,right);
        if(temp > 0)
            temp += root.val;
        else
            temp = root.val;

        int val = root.val;
        if(left >= 0)
            val += left;
        if(right >= 0)
            val += right;

        ans = Math.max(ans, val);
        return temp;
    }

}
