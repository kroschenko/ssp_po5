using System;

namespace lab6._1._5
{
    class Program
    {
        static void Main(string[] args)
        {
            Phone phone1 = new Phone(new AndroidFactory());
            phone1.OperationSystem();
            phone1.installCamera();
            phone1.installCPU();

            Console.WriteLine();

            Phone phone2 = new Phone(new IOSFactory());
            phone2.OperationSystem();
            phone2.installCamera();
            phone2.installCPU();
        }
    }
}