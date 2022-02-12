package format.quick_power;

import org.junit.jupiter.api.Test;

/**
 * 简单乘方的计算：
 * 使用快速幂：迭代方程式
 * 计算a^n
 *      if n   == 0  -> 1;
 *      if n%2 == 0 -> a^(n/2) * a^(n/2)
 *      if n%2 == 1 -> a^(n-1) * a
 *
 * @author weitong
 * @date 2022/01-17 7:58 下午
 */
public class SimpleExponentiationBySquaringTest {

    @Test
    public void test(){
        System.out.println(SimpleExponentiationBySquaring.calculateContinuous(3,13));
        System.out.println(SimpleExponentiationBySquaring.calculate(3,13));
        System.out.println(SimpleExponentiationBySquaring.calculateNonRer(3,13));
    }


}
