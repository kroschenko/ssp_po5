using System;

namespace lab5._2._5
{
    public class Tester : Employee
    {
        public Tester(int Age, string Name, double MinimalSalary) : base(Age, Name, MinimalSalary)
        {

        }

        public Tester(int Age, string Name, double MinimalSalary, double SalaryK) : base(Age, Name, MinimalSalary, SalaryK)
        {

        }

        public override void Work()
        {
            if (this.IsWorking())
            {
                Console.WriteLine("The tester " + this.GetName() + " is working...");
                return;
            }

            Console.WriteLine("Tester " + this.GetName() + " does not work...");
        }
    }
}