package stack;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        StackClearTest.class,
        StackPopTest.class,
        StackPushTest.class
})
public class RunAll {
}
