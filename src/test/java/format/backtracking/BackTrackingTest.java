package format.backtracking;

import org.junit.jupiter.api.Test;
import utils.ArrayUtil;
import utils.MatrixUtil;

import java.util.List;

public class BackTrackingTest {

    @Test
    public void allArrayRange(){
        int[] num = {1,2,3,4,5,6};
        List<int[]> res = AllRange.permute(num);
        System.out.println("预期：" + (6*5*4*3*2));
        System.out.println(res.size());
        for(int[] permutation : res){
            ArrayUtil.printArray(permutation);
        }
    }
    @Test
    public void allArrayRang2(){
        int[] num = {1,2,3,4,5,6};
        AllRange2.permute(num);
    }

    /**
     * 使用列表，需要维护一个标识访问过的数组
     */
    @Test
    public void allArrayRang3(){
        int[] num = {1,2,3,4};
        List<List<Integer>> res = AllRange3.permute(num);
        System.out.println("预期：" + (4*3*2));
        System.out.println(res.size());
        for(List<Integer> permutation : res){
            ArrayUtil.printArray(permutation);
        }

    }

    @Test
    public void allArrayRange4(){
        int[] num = {1,2,2,3};
        List<List<Integer>> res = AllRangeAllowRepeat.permuteUnique(num);
        System.out.println("预期：" + (7*6*5*4*3*2));
        System.out.println(res.size());
        for(List<Integer> permutation : res){
            ArrayUtil.printArray(permutation);
        }
    }

    @Test
    public void allStringRangeTest(){
        String s = "alii";
        List<String> res = AllRangeString.Permutation(s);
        for(String perm : res){
            System.out.println(perm);
        }
    }

    @Test
    public void combinationTest1(){
        int[] array ={ 1, 3,4,5,6,7,8,13,14,15};
        int target = 14;
        List<List<Integer>> res = CombinationSum.getCombination(array, target);
        for(List<Integer> combination : res){
            ArrayUtil.printArray(combination);
        }
    }

    @Test
    public void combinationTest2(){
        List<List<Integer>> res = CombinationSum2.getCombination(10, 4);
        for(List<Integer> combination : res){
            ArrayUtil.printArray(combination);
        }
    }
    @Test
    public void combinationTest3(){
        List<List<Integer>> res = CombinationSum2.combine(5, 2);
        for(List<Integer> combination : res){
            ArrayUtil.printArray(combination);
        }
    }

    @Test
    public void findStringInMatrix(){
        char[][] matrix = {
                {'a', 'l', 'i','n','i','s'},
                {'m', 'j', 'i','b','i','h'},
                {'o', 'l', 'l','e','h','k'},
                {'a', 'l', 'i','n','i','s'}
        };
        System.out.println(FindStringInMatrix.exist(matrix, "hell"));
    }

    @Test
    public void findIslandNum(){
        int[][] area = {
                {1,0,0,1,0,1},
                {0,1,1,0,0,1},
                {1,0,0,0,1,1},
                {1,0,1,1,0,1}
        };
        MatrixUtil.print(area);
        System.out.println(IslandNum.getIslandNum(area));
    }

    @Test
    public void subSetTest(){
        int[] array = {1,1,2,3};
        List<List<Integer> > res = SubSet2.subsetsWithDup(array);
        for(List<Integer> set : res){
            ArrayUtil.printArray(set);
        }
    }

    @Test
    public void subSetTest2(){
        int[] array = {1,1,2,3};
        List<List<Integer> > res = SubSet2.subsetsWithDup2(array);
        for(List<Integer> set : res){
            ArrayUtil.printArray(set);
        }
    }
    @Test
    public void subSetTest3(){
        int[] array = {1,2,3};
        List<List<Integer> > res = SubSet.getSubSet(array);
        System.out.println(res.size());
        for(List<Integer> set : res){
            ArrayUtil.printArray(set);
        }
    }
}
