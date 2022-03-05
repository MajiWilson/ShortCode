package format.twoPointer;


import format.BinarySearch.*;
import org.junit.jupiter.api.Test;
import utils.ArrayUtil;

public class TwoPointerTest {

    @Test
    public void colorSortTest(){
        int[] color = {0,2,1,2,0,1,2,0,1,2,0,1};
        ArrayUtil.printArray(color);
        ThreeColor.sort(color);
        ArrayUtil.printArray(color);
    }

    @Test
    public void stringSplitTest(){
        String s = "fsrgrtgrradadergxcddrhouh";
        StringSplit.split(s);
    }

    @Test
    public void maxContainerTest(){
        int[] array = {3,5,3,4,2,7,5};
        System.out.println(MaxContainer.getMaxArea(array));

    }

    @Test
    public void maxSubStringNoRepeatTest(){
        String s =  "agsrrhtyjujmistgthos";
        System.out.println(FindSubStringWithNoRepeat.findLongestSubString(s));
    }

    @Test
    public void maxLongestMountainTest(){
        int[] array = {2,3,5,4,7,1,2,3,4,5,7,3,2,3,4,5,6,5,4,3,2,1,0};
        ArrayUtil.printArray(array);
        ArrayUtil.printArray(FindLongestMountain.findLongestPeak(array));
    }

    @Test
    public void maxLongestMountainTest2(){
        int[] array = {2,3,5,4,7,1,2,3,4,5,7,3,2,3,4,5,6,5,4,3,2,1,0};
        ArrayUtil.printArray(array);
        ArrayUtil.printArray(FindLongestMountain.findLongestPeak2(array));
    }

    @Test
    public void findBreakTest(){
        int[] array = {5,6,7,9,11,0,1,2,3,4,5};
        System.out.println(FindBreak.find(array));
    }

    @Test
    public void fineOnlyPeakTest(){
        int[] array = {1,2,3,6,4};
        System.out.println(FindOnlyPeak.find(array));
    }
    @Test
    public void finePeakTest(){
        int[] array = {1,2,3,6,5,4,3,2,1,0};
        System.out.println(FindPeak.find(array));
    }

    @Test
    public void findMidTest(){
        int[] array = {4,5,6,7,8,-1,0,1,2,3};
        ArrayUtil.printArray(array);
        System.out.println(FindMid.findMid2(array));
    }

    @Test
    public void findMidOfTwqArrayTest(){
        int[] array1 = {2,5,8,13,16,20};
        int[] array2 = {0,3,4,9,14,17,23,34,45};
        System.out.println(FindMid2.findMid(array1, array2));

    }

    @Test
    public void findValleyTest(){
        int[] array = {9,5,3,6,8,15,199};
        System.out.println(FindValley.find(array));
    }





}
