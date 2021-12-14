using System;
using System.Collections.Generic;
using System.Text;

namespace lab4._3._9
{
    public abstract class Person
    {
        private int Age = 0;
        private string Name;

        public Person(int age, string name)
        {
            Age = age;
            Name = name;
        }

        public void SetAge(int age)
        {
            Age = age;
        }

        public int GetAge()
        {
            return Age;
        }

        public void SetName(string name)
        {
            Name = name;
        }

        public string GetName()
        {
            return Name;
        }
    }
}
