using System;
using System.Collections.Generic;

namespace lab4._3._9
{
    class Administrator
    {
        public void AddTrain(List<Train> trains, int id, string[] Stations, DateTime[] dateTimes, int price)
        {
            Train train = new Train();
            train.ID = id;
            train.Price = price;
            for(int i = 0; i < Stations.Length; i++)
            {
                train.Stations.Add(Stations[i]);
                train.TrainTime.Add(dateTimes[i]);
            }
            trains.Add(train);
        }
    }
}
