using System;

namespace lab3._1._9
{
    class main
    {
        static void Main(string[] args)
        {
            double[] arr1 = { 1.2, 1.1, 3.2, 4.3, 9.3 };
            double[] arr2 = { 1.3, 1.1, 3.1, 4.3, 9.1 };

            Set set1 = new Set(5, arr1);
            Set set2 = new Set(5, arr2);
            Set set3 = new Set();
            set3.Crossing(set1.List, set2.List);
            set3.Print();
            set3.FindElement(1.2);
            set1.AddElement(123.123, 2);
            set1.Print();
            Console.WriteLine(set1.Equals(set2));
            Console.WriteLine(set2.ToString());
        }
    }
}
