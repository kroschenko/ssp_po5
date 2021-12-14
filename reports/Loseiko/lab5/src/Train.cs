using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

namespace lab4._3._9
{
    public class Train
    {
        private List<string> Stations = new List<string>();
        private List<DateTime> TrainTime = new List<DateTime>();
        private int Price = 1;
        private int ID = 0;
        public Train(List<string> stations, List<DateTime> trainTime, int price, int id)
        {
            Stations = stations;
            TrainTime = trainTime;
            Price = price;
            ID = id;
        }

        public Train(List<string> stations, List<DateTime> trainTime)
        {
            Stations = stations;
            TrainTime = trainTime;
        }

        public void SetStations(List<string> stations)
        {
            Stations = stations;
        }

        public List<string> GetStations()
        {
            return Stations;
        }

        public void SetTrainTime(List<DateTime> trainTime)
        {
            TrainTime = trainTime;
        }

        public List<DateTime> GetTrainTime()
        {
            return TrainTime;
        }

        public void SetPrice(int price)
        {
            Price = price;
        }

        public int GetPrice()
        {
            return Price;
        }

        public void SetID(int id)
        {
            ID = id;
        }

        public int GetID()
        {
            return ID;
        }

        public bool _Equals(object Other)
        {
            if (GetStations().Equals(((Train)Other).GetStations()) && GetTrainTime().Equals(((Train)Other).GetTrainTime()) && GetPrice().Equals(((Train)Other).GetPrice()) && GetID().Equals(((Train)Other).GetID()))
            {
                return true;
            }
            return false;
        }
    }
}
