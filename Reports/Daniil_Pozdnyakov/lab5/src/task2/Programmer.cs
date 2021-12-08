using System;
using System.Collections.Generic;
using System.Text;

namespace lab5._2._5
{
    public class Programmer : Employee
    {
        public Programmer(int Age, string Name, double MinimalSalary) : base(Age, Name, MinimalSalary)
        {
        
        }

        public Programmer(int Age, string Name, double MinimalSalary, double SalaryK) : base(Age, Name, MinimalSalary, SalaryK)
        {
        
        }

        public override void Work()
        {
            if (this.IsWorking())
            {
                Console.WriteLine("The programmer " + this.GetName() + " is working...");
                return;
            }

            Console.WriteLine("Programmer " + this.GetName() + " does not work...");
        }
    }
}