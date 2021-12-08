using System;

namespace lab5._2._5
{
    public class Accountant : Employee
    {
        public Accountant(int Age, string Name, double MinimalSalary) : base(Age, Name, MinimalSalary)
        {

        }

        public Accountant(int Age, string Name, double MinimalSalary, double Salary) : base(Age, Name, MinimalSalary, Salary)
        {
            
        }

        public override void Work()
        {
            if (IsWorking())
            {
                Console.WriteLine("The accountant " + GetName() + " is working...");
                return;
            }

            Console.WriteLine("Accountant " + GetName() + " does not work...");
        }
    }
}