using System;
using System.Collections.Generic;
using System.Text;

namespace lab4._3._9
{
    class Passenger
    {
        int Bill { get; set; }

        public Passenger()
        {
            Bill = 100;
        }
        public void Application(string DepartureStation, string DestinationStation, DateTime date, List<Train> train)
        {
            for(int i = 0; i < train.Count; i++)
            {
                int index1 = train[i].Stations.IndexOf(DepartureStation);
                int index2 = train[i].Stations.IndexOf(DestinationStation);

                if (index1 != -1 && index2 != -1)
                {
                    if (index1 < index2)
                    {
                        if (train[i].TrainTime[index1] > date)
                        {
                            train[i].Print();
                            continue;
                        }
                    }
                }
            }
        }

        public void TrainSelection(int Num, List<Train> train)
        {
            Num--;
            if(Bill - train[Num].Price < 0)
            {
                Console.WriteLine("На счёте на хватает средств!");
                return;
            }
            Bill -= train[Num].Price;
            Console.WriteLine($"Остаток на счёте {Bill}");
        }
    }
}
