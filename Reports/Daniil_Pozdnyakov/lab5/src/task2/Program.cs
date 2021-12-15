using System;
using System.Collections.Generic;

namespace lab5._2._5
{
    class Program
    {
        public enum Speciality
        {
            MANAGER, 
            ANALYST, 
            PROGRAMMER, 
            TESTER, 
            DESIGNER, 
            ACCOUNTANT
        }

        public static int RandomInt(int Min, int Max)
        {
            Random rand = new Random();
            return rand.Next(Min, Max);
        }

        public static double RandomDouble(double Min, double Max)
        {
            Random random = new Random();
            return Math.Round(random.NextDouble() * (Max - Min) + Min, 2);
        }

        static void Main(string[] args)
        {
            List<string> Names = new List<string>();
            Names.Add(new string("Maya Rogerson"));
            Names.Add(new string("Liana Roy"));
            Names.Add(new string("Liza Thomson"));
            Names.Add(new string("Phoebe Teel"));
            Names.Add(new string("Erika Herbertson"));
            Names.Add(new string("Vicky Nixon"));
            Names.Add(new string("Donelle Joiner"));
            Names.Add(new string("Brynlee Alden"));
            Names.Add(new string("Mae Isaacson"));
            Names.Add(new string("Ocean Sharp"));
            Names.Add(new string("Phil Stephenson"));
            Names.Add(new string("Tilly Ellington"));
            Names.Add(new string("Richmal Statham"));
            Names.Add(new string("Margo Gadsby"));
            Names.Add(new string("Trudie George"));
            Names.Add(new string("Kortney Abbott"));
            Names.Add(new string("Amery Lyon"));
            Names.Add(new string("Brooklyn Knight"));

            int NumberOfWorkers = Names.Count, MinAge = 18, MaxAge = 65;

            double  MinimalSalary = 100.0, MinSalaryK = 1.0, MaxSalaryK = 2.0, ManagerMaxMinSalary = 1000.0,
                    AnalystMaxMinSalary = 800.0, ProgrammerMaxMinSalary = 900.0, TesterMaxMinSalary = 500.0,
                    DesignerMaxMinSalary = 700.0, AccountantMaxMinSalary = 450.0;

            List<Employee> Employees = new List<Employee>();
            Random rand = new Random();
            Type type = typeof(Speciality);
            Array values = type.GetEnumValues();

            for (int i = 0; i < NumberOfWorkers; ++i)
            {
                int tempIndex = rand.Next(values.Length);
                switch ((Speciality)values.GetValue(tempIndex))
                {
                    case Speciality.MANAGER:
                        Employees.Add(new Manager(RandomInt(MinAge, MaxAge), Names[i],
                                RandomDouble(MinimalSalary, ManagerMaxMinSalary),
                                RandomDouble(MinSalaryK, MaxSalaryK)));
                        break;
                    case Speciality.ANALYST:
                        Employees.Add(new Analyst(RandomInt(MinAge, MaxAge), Names[i],
                                RandomDouble(MinimalSalary, AnalystMaxMinSalary),
                                RandomDouble(MinSalaryK, MaxSalaryK)));
                        break;
                    case Speciality.PROGRAMMER:
                        Employees.Add(new Programmer(RandomInt(MinAge, MaxAge), Names[i],
                                RandomDouble(MinimalSalary, ProgrammerMaxMinSalary),
                                RandomDouble(MinSalaryK, MaxSalaryK)));
                        break;
                    case Speciality.TESTER:
                        Employees.Add(new Tester(RandomInt(MinAge, MaxAge), Names[i],
                                RandomDouble(MinimalSalary, TesterMaxMinSalary),
                                RandomDouble(MinSalaryK, MaxSalaryK)));
                        break;
                    case Speciality.DESIGNER:
                        Employees.Add(new Designer(RandomInt(MinAge, MaxAge), Names[i],
                                RandomDouble(MinimalSalary, DesignerMaxMinSalary),
                                RandomDouble(MinSalaryK, MaxSalaryK)));
                        break;
                    case Speciality.ACCOUNTANT:
                        Employees.Add(new Accountant(RandomInt(MinAge, MaxAge), Names[i],
                                RandomDouble(MinimalSalary, AccountantMaxMinSalary),
                                RandomDouble(MinSalaryK, MaxSalaryK)));
                        break;
                }

                Employees[i].StartWorking();
            }

            for (int i = 0; i < NumberOfWorkers; ++i)
            {
                Employee Employee = Employees[i];

                Employee.Work();

                Console.WriteLine("Salary = " + Employee.GetMinimalSalary() + " * " + Employee.GetSalary()
                        + " = " + Employee.Get_Salary() + '\n');

            }
        } 
    }
}