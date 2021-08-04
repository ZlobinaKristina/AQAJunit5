package Test.Suites;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestTitle {
    String m1 = "Address Book";
    ClassForTestS m11 =  new ClassForTestS(m1);
    @Test
    public void CheckTitle() {
        Assertions.assertEquals(m1, m11.OpenPageTitle());
    }
}
