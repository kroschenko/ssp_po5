using System;
using System.Collections.Generic;

namespace lab4._1._5
{
    class Program
    {
        static void Main(string[] args)
        {
            Department.Position.Employee James =     new Department.Position.Employee(20, "James Grant"),
                                         Ronnie =    new Department.Position.Employee(21, "Ronnie Harris"),
                                         John =      new Department.Position.Employee(22, "John Torres"),
                                         Matthew =   new Department.Position.Employee(23, "Matthew McKinney"),
                                         Francisco = new Department.Position.Employee(24, "Francisco Hall"),
                                         Jerry =     new Department.Position.Employee(25, "Jerry Ramsey"),
                                         Chris =     new Department.Position.Employee(26, "Chris Hamilton"),
                                         Brian =     new Department.Position.Employee(27, "Brian Gonzalez"),
                                         David =     new Department.Position.Employee(28, "David Riley");

            Department.Position Security =       new Department.Position("Security"),
                                TechnicalGroup = new Department.Position("Technical group"),
                                HeadOfService =  new Department.Position("Head of service");

            Security.AddEmployee(James);
            Security.AddEmployee(Ronnie);
            Security.AddEmployee(John);

            TechnicalGroup.AddEmployee(Matthew);
            TechnicalGroup.AddEmployee(Francisco);
            TechnicalGroup.AddEmployee(Jerry);

            HeadOfService.AddEmployee(Chris);
            HeadOfService.AddEmployee(Brian);
            HeadOfService.AddEmployee(David);

            List<Department.Position> SecurityPositions = new List<Department.Position>();
            SecurityPositions.Add(Security);
            SecurityPositions.Add(TechnicalGroup);
            SecurityPositions.Add(HeadOfService);

            Department security = new Department(new string("Security Department"));
            security.SetPositions(SecurityPositions);

            Console.WriteLine(security.GetName() + ":");

            foreach (Department.Position Position in security.GetPositions())
            {
                Console.WriteLine("\t" + Position.GetName() + ":");

                foreach (Department.Position.Employee Employee in Position.GetEmployees())
                {
                    Console.WriteLine("\t\t" + Employee.GetName());
                }
                Console.WriteLine();
            }

/*=============================================================================================================================================================*/

            Department.Position.Employee Robert =  new Department.Position.Employee(20, "Robert Rogers"),
                                         Todd =    new Department.Position.Employee(21, "Todd Reed"),
                                         Ronald =  new Department.Position.Employee(22, "Ronald White"),
                                         William = new Department.Position.Employee(23, "William Gomez"),
                                         Leroy =   new Department.Position.Employee(24, "Leroy Torres"),
                                         Claude =  new Department.Position.Employee(25, "Claude McDonald"),
                                         Terry =   new Department.Position.Employee(26, "Terry Cook"),
                                         Clifton = new Department.Position.Employee(27, "Clifton Simmons"),
                                         Thomas =  new Department.Position.Employee(28, "Thomas Hill");

            Department.Position Programmer =         new Department.Position("Programmer"),
                                Administrator =      new Department.Position("Administrator"),
                                SecuritySpecialist = new Department.Position("Security Specialist");

            Administrator.AddEmployee(Robert);
            Administrator.AddEmployee(Todd);
            Administrator.AddEmployee(Ronald);

            Programmer.AddEmployee(William);
            Programmer.AddEmployee(Leroy);
            Programmer.AddEmployee(Claude);

            SecuritySpecialist.AddEmployee(Terry);
            SecuritySpecialist.AddEmployee(Clifton);
            SecuritySpecialist.AddEmployee(Thomas);

            Department IT = new Department(new string("IT Department"));
            IT.AddPosition(Administrator);
            IT.AddPosition(Programmer);
            IT.AddPosition(SecuritySpecialist);

            Console.WriteLine(IT.GetName() + ":");

            foreach (Department.Position Position in IT.GetPositions())
            {
                Console.WriteLine("\t" + Position.GetName() + ":");

                foreach (Department.Position.Employee Employee in Position.GetEmployees())
                {
                    Console.WriteLine("\t\t" + Employee.GetName());
                }
                Console.WriteLine();
            }
        }
    }
}