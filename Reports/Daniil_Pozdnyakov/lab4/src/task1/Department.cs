using System.Collections.Generic;

namespace lab4._1._5
{
    public class Department
    {
        private string Name;
        private List<Position> Positions = new List<Position>();

        public Department()
        {
        }

        public Department(string name)
        {
            Name = name;
        }

        public Department(string name, List<Position> positions)
        {
            Name = name;
            Positions = positions;
        }

        public void SetName(string name)
        {
            Name = name;
        }

        public string GetName()
        {
            return Name;
        }

        public void SetPositions(List<Position> positions)
        {
            Positions = positions;
        }

        public List<Position> GetPositions() {
            return Positions;
        }

        public void AddPosition(Position position)
        {
            Positions.Add(position);
        }

        public void RemovePosition(Position position)
        {
            Positions.Remove(position);
        }

        public class Position
        {
            private string Name;
            private List<Employee> Employees = new List<Employee>();

            public Position()
            {
            }

            public Position(string name)
            {
                Name = name;
            }

            public Position(string name, List<Employee> employees)
            {
                Name = name;
                Employees = employees;
            }

            public void SetName(string name)
            {
                Name = name;
            }

            public string GetName()
            {
                return Name;
            }

            public void SetEmployees(List<Employee> employees)
            {
                Employees = employees;
            }

            public List<Employee> GetEmployees() {
                return Employees;
            }

            public void AddEmployee(Employee employee)
            {
                Employees.Add(employee);
            }

            public void RemoveEmployee(Employee employee)
            {
                Employees.Remove(employee);
            }

            public class Employee
            {
                private int Age;
                private string Name;

                public Employee(int age, string name)
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
    }
}