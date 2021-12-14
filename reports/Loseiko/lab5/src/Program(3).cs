using System;
using System.Collections.Generic;

namespace lab4._3._9
{
    class Program
    {
        static List<string> RandomStatoins(int NumStations)
        {
            List<string> stations = new List<string>();
            if (NumStations <= 0)
            {
                return stations;
            }
            string[] stationsName = { "Брест", "Минск", "Витебск", "Гомель", "Гродно", "Могилёв", "Бобруйск", "Барановичи", "Новополоцк", "Пинск", "Борисов", "Лида", "Мозырь", "Полоцк", "Слоним", "Орша", "Молодечно", "Жлобин", "Кобрин", "Слуцк" };
            Random rand = new Random();
            for(int i = 0; i < NumStations; i++)
            {
                stations.Add(stationsName[rand.Next(0, stationsName.Length)]);
            }
            return stations;
        }

        public static DateTime RandomDateTime(DateTime min, DateTime max)
        {
            Random _ran = new Random();

            return DateTime.MinValue.Add(TimeSpan.FromTicks(min.Ticks + (long)(_ran.NextDouble() * (max.Ticks - min.Ticks))));
        }

        static List<DateTime> GenerateTime(int NumStations)
        {
            List<DateTime> dateTimes = new List<DateTime>();
            DateTime maxdate = new DateTime(2021, 12, 10, 0, 0, 0);
            for(int i = 0; i < NumStations; i++)
            {
                dateTimes.Add(RandomDateTime(DateTime.Now, maxdate));
            }
            dateTimes.Sort();
            return dateTimes;
        }
        static void Main(string[] args)
        {
            int NumStations = 10;
            TrainStation trainStation = new TrainStation();
            trainStation.AddTrain(new Train(RandomStatoins(NumStations), GenerateTime(NumStations), 10, 1));
            trainStation.AddTrain(new Train(RandomStatoins(NumStations), GenerateTime(NumStations), 15, 2));
            trainStation.AddTrain(new Train(RandomStatoins(NumStations), GenerateTime(NumStations), 12, 3));
            trainStation.AddTrain(new Train(RandomStatoins(NumStations), GenerateTime(NumStations), 11, 4));
            trainStation.AddTrain(new Train(RandomStatoins(NumStations), GenerateTime(NumStations), 13, 5));

            RailwayTicketOffice railwayTicketOffice = new RailwayTicketOffice();
            railwayTicketOffice.SetTrainStation(trainStation);

            Administrator Administrator = new Administrator(38, "Kirill Smekalov", railwayTicketOffice);
            Passenger Passenger = new Passenger(19, "Stas Sokolov", 100);

            railwayTicketOffice.AddAdministrator(Administrator);
            railwayTicketOffice.AddPassenger(Passenger);

            if (Passenger.RequestOrderAndCheck(railwayTicketOffice, "Брест", "Минск", trainStation))
            {
                Console.WriteLine("Train successfully found");
            }
            else
            {
                Console.WriteLine("Train not found");
            }
        }
    }
}