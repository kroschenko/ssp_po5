using System;

namespace lab5._2._5
{
    public class Designer : Employee
    {
        public Designer(int Age, string Name, double MinimalSalary) : base(Age, Name, MinimalSalary)
        {
        
        }

        public Designer(int Age, string Name, double MinimalSalary, double Salary) : base(Age, Name, MinimalSalary, Salary)
        {
        
        }

        public override void Work()
        {
            if (IsWorking())
            {
                Console.WriteLine("The designer " + GetName() + " is working...");
                return;
            }

            Console.WriteLine("Designer " + GetName() + " does not work...");
        }
    }
}