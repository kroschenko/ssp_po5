package queue;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses ({QueueEmptyTest.class, QueueManyElementsTest.class, QueueOneElementTest.class})
public class QueueSuiteTest {

}
