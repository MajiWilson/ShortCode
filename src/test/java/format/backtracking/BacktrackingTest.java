package format.backtracking;

import format.twoPointer.StringSplit;
import org.junit.jupiter.api.Test;
import utils.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
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

    @Test
    public void testSampleCombination(){
        List<List<String>> samples = new ArrayList<>();
        List<String> sample1 = new ArrayList<String>(Arrays.asList("a", "b", "c"));
        List<String> sample2 = new ArrayList<>(Arrays.asList("1", "2", "3"));
        List<String> sample3 = new ArrayList<>(Arrays.asList("A", "B", "C"));
        samples.add(sample1);
        samples.add(sample2);
        samples.add(sample3);

        List<List<String>> res = SampleCombination.sampleCombination(samples);
        for(List<String> list : res){
            for (String s : list){
                System.out.print( s + " ");
            }
            System.out.println();
        }
    }
}
