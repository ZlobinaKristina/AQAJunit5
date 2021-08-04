package Test.Suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import static org.junit.runners.Suite.*;

@RunWith(Suite.class)
@SuiteClasses
        ({TestTitle.class,
                TestURL.class}) //выполняется только второй тест (?)
class TestSuite {
}
