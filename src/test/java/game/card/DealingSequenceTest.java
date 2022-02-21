package game.card;

import org.junit.jupiter.api.Test;
import utils.ArrayUtil;

import java.util.Arrays;

/**
 * @author weitong
 * @date 2022/02-19 9:45 下午
 */
public class DealingSequenceTest {
    @Test
    public void dealingSequenceTest(){
        int[] array = ArrayUtil.generateRandomArray(10);
        ArrayUtil.printArray(array);
        int[] dealingSequence = DealingSequence.getDealingSequence(array);
        ArrayUtil.printArray(dealingSequence);

        int[] originArray = DealingSequence.recoverDealingSequence(dealingSequence);
        ArrayUtil.printArray(originArray);
    }
    @Test
    public void dealingSequenceTest2(){
        int[] array = {1,2,3,4,5,6,7,8,9};
        ArrayUtil.printArray(array);
        int[] dealingSequence = DealingSequence.getDealingSequence(array);
        ArrayUtil.printArray(dealingSequence);

        int[] originArray = DealingSequence.recoverDealingSequence2(dealingSequence);
        ArrayUtil.printArray(originArray);
    }

    @Test
    public void dealingSequenceTest3(){
        int[] array = {1,2,3,4,5,6,7,8,9};
        ArrayUtil.printArray(array);
        int[] dealingSequence = DealingSequence.getDealingSequence2(array);
        ArrayUtil.printArray(dealingSequence);

        int[] originArray = DealingSequence.recoverDealingSequence2(dealingSequence);
        ArrayUtil.printArray(originArray);
    }
}
