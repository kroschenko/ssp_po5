namespace lab4._3._5
{
    public class Person
    {
        private int Age = 0;
        private string Name;

        public Person(int age, string name)
        {
            Age = age;
            Name = name;
        }

        public void f_set_age(int age)
        {
            Age = age;
        }

        public int f_get_age()
        {
            return Age;
        }

        public void f_set_name(string name)
        {
            Name = name;
        }

        public string f_get_name()
        {
            return Name;
        }
    }
}