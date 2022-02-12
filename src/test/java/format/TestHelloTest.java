package format;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestHelloTest {


    @Test
    public void testPrint(){
        Assertions.assertEquals("alin, may the force be with you!", TestHello.printHello("alin"));
    }

}
