using System;

namespace lab5._1._5
{
    class Program
    {
        static void Main(string[] args)
        {
            Theatre v_Theater = new Theatre(new string("Opera de Paris"), new string("Pl. de I'Opera, 75009"), 2000, 14.00, new string("10:00 - 18:00"));

            Console.WriteLine(new string("Name: ") + v_Theater.GetName());
            Console.WriteLine(new string("Address: ") + v_Theater.GetAddress());
            Console.WriteLine(new string("Visitors count: ") + v_Theater.GetVisitorsCount());
            Console.WriteLine(new string("Visit price: ") + v_Theater.GetVisitPrice());
            Console.WriteLine(new string("Work time: ") + v_Theater.GetWorkTime());

            Console.WriteLine();
            v_Theater.ShowPerformance();
        }
    }
}