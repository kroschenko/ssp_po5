using System;

namespace lab5._2._5
{
    public class Analyst : Employee
    {
        public Analyst(int Age, string Name, double MinimalSalary) : base(Age, Name, MinimalSalary)
        {
        
        }

        public Analyst(int Age, string Name, double MinimalSalary, double Salary) : base(Age, Name, MinimalSalary, Salary)
        {
        
        }

        public override void Work()
        {
            if (IsWorking())
            {
                Console.WriteLine("The analyst " + GetName() + " is working...");
                return;
            }

            Console.WriteLine("Analyst " + GetName() + " does not work...");
        }
    }
}
