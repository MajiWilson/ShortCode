package format.backtracking;

import org.junit.jupiter.api.Test;
import utils.ArrayUtil;

import java.util.List;

public class BacktrackingTest {

    @Test
    public void allRangeAllowRepeat(){
        int[] array = {4,7,7,5};
        List<List<Integer>> res = AllRangeAllowRepeat.permuteUnique(array);
        System.out.println(res.size());
        for(List<Integer> list : res){
            ArrayUtil.printArray(list);
        }
    }

    @Test
    public void allRangeAllowRepeat2(){
        int[] array = {4,7,7,5};
        List<int[]> res = AllRangeAllowRepeat2.permuteUnique(array);
        System.out.println(res.size());
        for(int[] list : res){
            ArrayUtil.printArray(list);
        }
    }

    @Test
    public void allRangeAllowRepeat3(){
        int[] array = {4,7,7,5};
        List<List<Integer>> res = AllRangeAllowRepeat3.permuteUnique(array);
        System.out.println(res.size());
        for(List<Integer> list : res){
            ArrayUtil.printArray(list);
        }
    }
}
