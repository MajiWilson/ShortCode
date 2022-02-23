package ds_type.string;

import org.junit.jupiter.api.Test;

/**
 * @author weitong
 * @date 2022/02-22 7:49 下午
 */
public class StringTest {
    @Test
    public void deleteRepeatTest1(){
        String s = "rrdrrdssdwwttrrwew";
        System.out.println(s);
        String s2 = DeleteRepeat.removeDuplicates(s);
        System.out.println(s2);
    }

    @Test
    public void deleteRepeatTest2(){
        String s = "rrdrrdssdwwttrrwew";
        System.out.println(s);
        String s2 = DeleteRepeat.removeDuplicates2(s);
        System.out.println(s2);
    }
}
