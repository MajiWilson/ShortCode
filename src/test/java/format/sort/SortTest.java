package format.sort;

import org.junit.jupiter.api.Test;
import utils.ArrayUtil;

/**
 * @author weitong
 * @date 2022/02-13 11:48 上午
 */
public class SortTest {

    @Test
    public void testQuickSort(){
        int[] array = ArrayUtil.generateRandomArray(50);
        ArrayUtil.printArray(array);
        QuickSort.quickSort(array);
        ArrayUtil.printArray(array);
    }

    @Test
    public void testQuickSort2(){
        int[] array = ArrayUtil.generateRandomArray(50);
        ArrayUtil.printArray(array);
        QuickSort2.quickSort(array);
        ArrayUtil.printArray(array);
    }

    @Test
    public void testInsertSort(){
        int[] array = ArrayUtil.generateRandomArray(50);
        ArrayUtil.printArray(array);
        InsertSort.insertSort(array);
        ArrayUtil.printArray(array);
    }

    @Test
    public void testBubbleSort(){
        int[] array = ArrayUtil.generateRandomArray(50);
        ArrayUtil.printArray(array);
        BubbleSort.bubbleSort(array);
        ArrayUtil.printArray(array);
    }

    @Test
    public void testBubbleSortDesc(){
        int[] array = ArrayUtil.generateRandomArray(50);
        ArrayUtil.printArray(array);
        BubbleSortDesc.bubbleSort(array);
        ArrayUtil.printArray(array);
    }

    @Test
    public void testMergeSort(){
        int[] array = ArrayUtil.generateRandomArray(49);
        ArrayUtil.printArray(array);
        MergeSort.mergeSort(array);
        ArrayUtil.printArray(array);
    }

    @Test
    public void testCountSort(){
        int[] array = ArrayUtil.generateRandomArray(49);
        ArrayUtil.printArray(array);
        CountSort.countSort(array);
        ArrayUtil.printArray(array);
    }
    @Test
    public void testRandomSelect(){
        int[] array = ArrayUtil.generateRandomArray(49);
        ArrayUtil.printArray(array);
        System.out.println(RandomizedSelect.select(array, 48));
        ArrayUtil.printArray(array);
        System.out.println(RandomizedSelect.select(array, 3));
        ArrayUtil.printArray(array);
    }

    @Test
    public void testShellSort(){
        int[] array = ArrayUtil.generateRandomArray(16);
        ArrayUtil.printArray(array);
        ShellSort.shellSort(array);
        ArrayUtil.printArray(array);

    }
    @Test
    public void testShellSort2(){
        int[] array = ArrayUtil.generateRandomArray(10);
        ArrayUtil.printArray(array);
        ShellSort.shellSort2(array);
        ArrayUtil.printArray(array);

    }



}
