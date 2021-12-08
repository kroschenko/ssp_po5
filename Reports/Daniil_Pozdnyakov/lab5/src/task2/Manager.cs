using System;
using System.Collections.Generic;
using System.Text;

namespace lab5._2._5
{
    public class Manager : Employee
    {
        public Manager(int Age, string Name, double MinimalSalary) : base(Age, Name, MinimalSalary)
        {
        
        }

        public Manager(int Age, string Name, double MinimalSalary, double SalaryK) : base(Age, Name, MinimalSalary, SalaryK)
        {
        
        }

        public override void Work()
        {
            if (this.IsWorking())
            {
                Console.WriteLine("The manager " + this.GetName() + " is working...");
                return;
            }

            Console.WriteLine("Manager " + this.GetName() + " does not work...");
        }
    }
}
