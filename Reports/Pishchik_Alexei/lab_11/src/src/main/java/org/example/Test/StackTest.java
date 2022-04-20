package org.example.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith( Suite. class )
@Suite.SuiteClasses( { // Список тестовых классов в наборе для запуска
        StackTest1.class,
        StackTest2.class,
        StackTest3.class,
})
public class StackTest {
}
