using System;

namespace lab4._2._9
{
    class Program
    {
        static void Main(string[] args)
        {
            Wheel Continental = new Wheel(15, 220);
            Car Porsche = new Car(Continental);
            Porsche.Print();
        }
    }
}
