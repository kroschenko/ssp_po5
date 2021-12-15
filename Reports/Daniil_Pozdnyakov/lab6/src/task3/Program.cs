namespace lab6._3._5
{
    class Program
    {
        static void Main(string[] args)
        {
            Person Bob = new Person("Bob", 1000, 1234);
            ATM atm = new ATM(new Authentication(Bob));
            atm.Expectation();
            atm.Authentication();
            atm.PerformingOperation();
        }
    }
}
