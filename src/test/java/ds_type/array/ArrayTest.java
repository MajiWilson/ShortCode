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
}
