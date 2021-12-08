namespace lab5._2._5
{
    public abstract class Employee : Person
    {
        private bool isWorking = false;
        private double minimalSalary = 0.0, salary = 1.0, _salary = 0.0;

        public Employee(int Age, string Name, double MinimalSalary) : base(Age, Name)
        {
            minimalSalary = MinimalSalary;
            _salary = minimalSalary * salary;
        }

        public Employee(int Age, string Name, double MinimalSalary, double Salary) : base(Age, Name)
        {
            minimalSalary = MinimalSalary;
            salary = Salary;
            _salary = minimalSalary * salary;
        }

        public void StartWorking()
        {
            isWorking = true;
        }

        public void StopWorking()
        {
            isWorking = false;
        }

        public bool IsWorking()
        {
            return isWorking;
        }

        public void SetMinimalSalary(double MinimalSalary)
        {
            minimalSalary = MinimalSalary;
            _salary = minimalSalary * salary;
        }

        public double GetMinimalSalary()
        {
            return minimalSalary;
        }

        public void SetSalary(double Salary)
        {
            salary = Salary;
            _salary = minimalSalary * salary;
        }

        public double GetSalary()
        {
            return salary;
        }

        public double Get_Salary()
        {
            return _salary;
        }

        public abstract void Work();
    }
}