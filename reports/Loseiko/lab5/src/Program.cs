using System;

namespace lab5._1._9
{
    class Program
    {
        static void Main(string[] args)
        {
            Tanker tanker = new Tanker("ULCC", 415, 500000, 200);

            Console.WriteLine("Name: " + tanker.GetName());
            Console.WriteLine("Size: " + tanker.GetSize());
            Console.WriteLine("Max weight: " + tanker.GetWeightLimit() + " tons");
            Console.WriteLine("Stuff: " + tanker.GetNumOfStaff() + " man");
        }
    }
}