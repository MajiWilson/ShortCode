package ds_type.array;

import org.junit.jupiter.api.Test;
import utils.ArrayUtil;

import java.util.List;

/**
 * @author weitong
 * @date 2022/02-23 7:57 下午
 */
public class ArrayTest {

    @Test
    public void subSetTest(){
        int[] array = ArrayUtil.generateRandomArray(5);
        ArrayUtil.printArray(array);
        List<List<Integer>> res = SubSet.getSubSet(array);
        for(List<Integer> list : res){
            int[] temp = new int[list.size()];
            for(int i = 0 ;i < list.size(); i++){
                temp[i] = list.get(i);
            }
            ArrayUtil.printArray(temp);
        }
    }
    @Test
    public void arrayCenterTest(){
        int[] array = {1,2,3,4,3,2,1};
        ArrayUtil.printArray(array);
        System.out.println(ArrayCenter.findArrayCenter(array));
    }


    @Test
    public void findModTest(){
        int[] array = {3,5,3,4,3,4,3,3,3,3,4,3,6,1};
        ArrayUtil.printArray(array);
        System.out.println(FindMod.findMod(array));
    }


    @Test
    public void findMinKNumInArrayTest(){
        int[] array = ArrayUtil.generateRandomArray(20);
        ArrayUtil.printArray(array);
        ArrayUtil.printArray(FindMinKnum.getKthMin(array, 4));

    }


    @Test
    public void finNumInValley(){
        int[] array = {28,26,24,15,11,6,5,4,1,7,13,23,29,55,100,33545};
        ArrayUtil.printArray(array);
        System.out.println(array[FindNumInValley.find(array, 13)]);

    }

    @Test
    public void separateArrayTest(){
        int[] array = {3,4,2,1,-3,4,6,-9,0,2,7,-4,-122,56,-6,0};
        ArrayUtil.printArray(array);
        SeparateArray.separate(array);
        ArrayUtil.printArray(array);
    }
}
