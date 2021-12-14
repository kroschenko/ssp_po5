using System;
using System.Collections.Generic;

namespace lab4._3._9
{
    public class Administrator : Person
    {
        private RailwayTicketOffice railwayTicketOffice = new RailwayTicketOffice();

        public Administrator(int age, string name, RailwayTicketOffice railwayTicketOffice) : base(age, name)
        {
            this.railwayTicketOffice = railwayTicketOffice;
        }

        public void SetRailwayTicketOffice(RailwayTicketOffice railwayTicketOffice)
        {
            this.railwayTicketOffice = railwayTicketOffice;
        }

        public RailwayTicketOffice GetRailwayTicketOffice()
        {
            return railwayTicketOffice;
        }

        public void AddOrder(Order order)
        {
            railwayTicketOffice.AddOrder(order);
        }
    }
}