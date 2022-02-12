package ds_type.tree;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 113
 * desc: 找到从根节点到叶子节点路径总和等于给定目标和的所有路径
 */
public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new ArrayList<>();
        if(root == null){
            return paths;
        }
        List<Integer> curPath = new ArrayList<>();
        findAllPath(root, targetSum, curPath, paths);
        return paths;
    }

    public void findAllPath(TreeNode root, int sum, List<Integer> curPath, List<List<Integer>> paths){
        curPath.add(root.val); //每一个节点，我们都加入list, 最后在从list中减去， 即回溯

        if(root.left == null && root.right == null && sum == 0){ //递归出口1
            paths.add(new ArrayList<>(curPath));
        }
        if(root.left != null){ // 递归操作， else 为递归出口2
            findAllPath(root.left, sum-root.val, curPath, paths);
        }
        if(root.right != null){ //递归操作， else 为递归出口3
            findAllPath(root.right, sum-root.val, curPath, paths);
        }

        curPath.remove(curPath.size()-1);
    }


    /**
     * 练习
     */

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        if(root == null){
            return res;
        }
        tranverse(root, target,path, res);
        return res;
    }
    public void tranverse(TreeNode root, int target, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> res){
        path.add(root.val);
        target -= root.val;
        if(root.left == null && root.right == null){
            if(0 == target){
                res.add(new ArrayList<>(path));
            }
        }
        else{
            if(root.left != null){
                tranverse(root.left, target, path, res );
            }
            if(root.right != null){
                tranverse(root.right, target ,path, res);
            }
        }
        path.remove(path.size()-1);
    }


}
