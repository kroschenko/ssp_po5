using System;
using System.Collections.Generic;
using System.Text;

namespace lab4._3._9
{
    public class Order
    {
        private Train Train = null;
        private Passenger Passenger = null;

        public Order(Train train, Passenger passenger)
        {
            Train = train;
            Passenger = passenger;
        }

        public void SetTrain(Train train)
        {
            Train = train;
        }

        public Train GetTrain()
        {
            return Train;
        }

        public void SetPassenger(Passenger passenger)
        {
            Passenger = passenger;
        }

        public Passenger GetPassenger()
        {
            return Passenger;
        }
    }
}