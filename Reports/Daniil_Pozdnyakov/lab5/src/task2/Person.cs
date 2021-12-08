using System;
using System.Collections.Generic;
using System.Text;

namespace lab5._2._5
{
    public abstract class Person
    {
        private int Age = 0;
        private string Name;

        public Person(int age, string name)
        {
            this.Age = age;
            this.Name = name;
        }

        public void SetAge(int age)
        {
            this.Age = age;
        }

        public int GetAge()
        {
            return this.Age;
        }

        public void SetName(string name)
        {
            this.Name = name;
        }

        public string GetName()
        {
            return this.Name;
        }
    }
}