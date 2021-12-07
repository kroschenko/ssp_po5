using System;
using System.Collections.Generic;
using System.Text;

namespace lab4._3._9
{
    public class TrainStation
    {
        private List<Train> Trains = new List<Train>();

        public TrainStation()
        {
        }

        public TrainStation(List<Train> train)
        {
            Trains = train;
        }

        public void SetTrains(List<Train> train)
        {
            Trains = train;
        }

        public List<Train> GetTrains()
        {
            return Trains;
        }

        public void AddTrain(Train train)
        {
            Trains.Add(train);
        }

        public void RemoveTrain(Train train)
        {
            Trains.Remove(train);
        }

        public Tuple<int, Train> TrainSearch(string StartStation, string EndStation)
        {
            List<string> temp;
            for (int i = 0; i < Trains.Count; i++)
            {
                temp = Trains[i].GetStations();
                if (temp.IndexOf(StartStation) < temp.IndexOf(EndStation) && temp.IndexOf(StartStation) != -1)
                {
                    return Tuple.Create(i, Trains[i]);
                }
            }

            Train train = null;
            return Tuple.Create(-1, train);
        }

        public Train GiveTrain(Train train)
        {
            int index = -1;

            for (int i = 0; i < Trains.Count; i++)
            {
                if (Trains[i].GetStations() == train.GetStations() && Trains[i].GetTrainTime() == train.GetTrainTime() && Trains[i].GetPrice() == train.GetPrice() && Trains[i].GetID() == train.GetID())
                {
                    index = i;
                }
            }

            if (index == -1)
            {
                return null;
            }

            Train result = Trains[index];
            RemoveTrain(train);

            return result;
        }
    }
}
