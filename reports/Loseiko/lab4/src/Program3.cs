using System;
using System.Collections.Generic;

namespace lab4._3._9
{
    class Program
    {
        static void Main(string[] args)
        {
            List<Train> Trains = new List<Train>();
            Train train1 = new Train(1);
            Trains.Add(train1);
            Train train2 = new Train(2);
            Trains.Add(train2);
            Train train3 = new Train(3);
            Trains.Add(train3);

            Passenger Tom = new Passenger();
            DateTime tom = new DateTime(2021, 10, 10);
            Tom.Application("Брест", "Минск", tom, Trains);
            Tom.TrainSelection(1, Trains);

            Administrator Bob = new Administrator();
            string[] stations = { "Гродно", "Щучин", "Лида", "Воложин", "Минск" };
            DateTime[] dateTimes2 = new DateTime[]
            {
                new DateTime(2021, 10, 10, 8, 10, 0),
                new DateTime(2010, 10, 1, 8, 32, 1),
                new DateTime(2010, 10, 1, 8, 45, 2),
                new DateTime(2010, 10, 1, 9, 0, 3),
                new DateTime(2010, 10, 1, 9, 20, 4),
            };
            Bob.AddTrain(Trains, 4, stations, dateTimes2, 20);
            Trains[3].Print();
        }
    }
}
