package format.dp;

import org.junit.jupiter.api.Test;
import utils.ArrayUtil;

import javax.annotation.processing.SupportedAnnotationTypes;

public class DpTest {

    @Test
    public void lcsTest(){
        String s1 = "mwajviatlin";
        String s2 = "cmajfialing";
        System.out.println(LcsPractice.find(s1, s2));
    }

    @Test
    public void lisTest1(){
        // 使用LCS的方法求lis有问题，如果不是严格递增的
        int[] array = {3,5,2,7,4,5,8,6,9,13,10,23,17};
        ArrayUtil.printArray(array);
        ArrayUtil.printArray(Lis.getLis(array));
    }

    @Test
    public void lisTest2(){
        // 使用LCS的方法求lis有问题，不是严格递增的
        int[] array = {1,1,2,3,7,3,4,8,2,1,8};
        ArrayUtil.printArray(array);
        ArrayUtil.printArray(Lis.getLis(array));
    }

    @Test
    public void lisTest3(){
        int[] array = {8,9,3,6,7,13,15,9,20,4};
        ArrayUtil.printArray(array);
        ArrayUtil.printArray(Lis.getLis2(array));
    }

    @Test
    public void lisTest4(){
        int[] array = {8,9,3,6,7,13,15,9,20,4};
        ArrayUtil.printArray(array);
        System.out.println(Lis.getLis3(array));
    }

    @Test
    public void maxContinuesSum(){
        int[] array = {3,2,4,-3,-2,4,-7, 18};
        System.out.println(MaxContinueSum.maxSubArray(array));
    }

    @Test
    public void robTest1(){
        int[] nums = {3,4,1,5,7,3,5,7,2,3};
        System.out.println(Robbery.rob(nums));
        System.out.println(Robbery.rob2(nums));
        System.out.println(Robbery.rob3(nums));

    }

    @Test
    public void cutLineMaxMultiTest(){
        System.out.println(CutLine.cuttingRope(10));
    }

    @Test
    public void minCostClimbStairs(){
        int[] cost = {3,2,1,5,2,4,6,3,1,4};
        ArrayUtil.printArray(cost);
        System.out.println(ClimbStairs2.getMinCost(cost));
        System.out.println(ClimbStairs2.getMinCost2(cost));
        System.out.println(ClimbStairs2.minCostClimbingStairs(cost));


    }

    @Test
    public void coverAreaTest(){
        System.out.println(CoverArea.getSolutions(12));
        System.out.println(CoverArea.getSolutions2(12));
        System.out.println(CoverArea.rectCover(12));
        System.out.println(CoverArea.rectCover2(12));
    }

    @Test
    public void changeMoneySolutionsTest(){
        int[] coins = {10,5,3,1};
        int amount = 10;
        System.out.println(ChangeMoney2.getSolutions(coins, amount));

    }



}
