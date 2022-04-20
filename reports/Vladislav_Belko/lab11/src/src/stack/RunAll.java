package stack;

import org . junit . runner . RunWith ;
import org . junit . runners . Suite ;
import org . junit . runners . Suite . SuiteClasses ;
@RunWith ( Suite . class ) // Запустить класс как тестовый набор
@SuiteClasses ({ // Список тестовых классов в наборе для запуска
        StackTest1.class ,
        StackTest2 .class ,
        StackTest3 .class ,
})
class RunAll {

}
