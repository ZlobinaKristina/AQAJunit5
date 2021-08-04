package Test.Suites;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestURL {
    String m1 = "http://a.testaddressbook.com/";
    ClassForTestS m22 =  new ClassForTestS(m1);
    @Test
    public void CheckURL() {
        Assertions.assertEquals(m1, m22.OpenPageURL());
    }


}
