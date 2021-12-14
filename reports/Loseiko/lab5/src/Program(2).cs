using System;
using System.Collections.Generic;

namespace lab5._2._9
{
    class Program
    {
        static void Main(string[] args)
        {
            List<Vehicle> list = new List<Vehicle>();
            list.Add(new Car(120, 30, 3));
            list.Add(new Carriage(60, 20, 2));
            list.Add(new Bicycle(40, 10, 1));
            Console.WriteLine("Вывод скорости и стоимости (для пассажиров и груза) транспортов:");
            foreach(Vehicle lis in list)
            {
                lis.printTypeOfTransport();
                lis.printSpeed();
                lis.printPassengerTransportationCost();
                lis.printCargoTransportationCost();
            }

            int distance = 1500;
            Console.WriteLine("\nРассчет для каждого транспорта, расстояние = " + distance + "км");
            foreach (Vehicle lis in list)
            {
                lis.calculateMovement(distance);
            }
        }
    }
}