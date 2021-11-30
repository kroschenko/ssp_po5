using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

namespace lab4._3._9
{
    class Train
    {
        public List<string> Stations = new List<string>();
        public List<DateTime> TrainTime = new List<DateTime>();
        public int Price { get; set; }
        public int ID { get; set; }

        public Train()
        {

        }
        public Train(int Number)
        {
            string Line = File.ReadLines("trains.txt").ElementAtOrDefault(--Number);
            if(Line == null)
            {
                return;
            }
            string[] info = Line.Split(" ", StringSplitOptions.RemoveEmptyEntries);
            ID = int.Parse(info[0]);
            Price = 10;

            DateTime time;
            for (int i = 1; i < info.Length; i++)
            {
                if (i % 2 == 0)
                {
                    time = DateTime.ParseExact(info[i], "dd.MM.yyyy_HH:mm", null);
                    TrainTime.Add(time);
                }
                else
                {
                    Stations.Add(info[i]);
                }
            }
        }

        public void Print()
        {
            Console.WriteLine($"Номер поезда - {ID}, станция отправления - {Stations[0]}, время отправления - {TrainTime[0]}, конечная станция - {Stations[^1]}, время прибытия - {TrainTime[^1]}");
        }
    }
}
