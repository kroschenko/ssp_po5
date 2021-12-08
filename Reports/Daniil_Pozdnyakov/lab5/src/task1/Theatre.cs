using System;
using System.Collections.Generic;
using System.Text;

namespace lab5._1._5
{
    public class Theatre : PublicBuilding
    {
        public Theatre(string name, string address) : base (name, address)
        {

        }

        public Theatre(string name, string address, int visitorsCount) : base(name, address, visitorsCount)
        {

        }

        public Theatre(string name, string address, int visitorsCount, double visitPrice) : base(name, address, visitorsCount, visitPrice)
        {

        }

        public Theatre(string name, string address, int visitorsCount, double visitPrice, string c_WorkTime) : base(name, address, visitorsCount, visitPrice, c_WorkTime)
        {

        }

        public void ShowPerformance()
        {
            Console.WriteLine("Very interesting performance...");
        }
    }
}