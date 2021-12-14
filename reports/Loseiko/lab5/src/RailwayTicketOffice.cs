using System;
using System.Collections.Generic;
using System.Text;

namespace lab4._3._9
{
    public class RailwayTicketOffice
    {
        private TrainStation TrainStations = new TrainStation();
        private List<Train> Trains = new List<Train>();
        private List<Administrator> Administrators = new List<Administrator>();
        private List<Passenger> Passengers = new List<Passenger>();
        private List<Order> Orders = new List<Order>();

        public RailwayTicketOffice()
        {

        }

        public RailwayTicketOffice(TrainStation trainStations)
        {
            TrainStations = trainStations;
        }

        public RailwayTicketOffice(TrainStation trainStations, List<Train> trains)
        {
            TrainStations = trainStations;
            Trains = trains;
        }

        public RailwayTicketOffice(TrainStation trainStations, List<Train> trains, List<Administrator> administrators)
        {
            TrainStations = trainStations;
            Trains = trains;
            Administrators = administrators;
        }

        public RailwayTicketOffice(TrainStation trainStations, List<Train> trains, List<Administrator> administrators, List<Passenger> passengers)
        {
            TrainStations = trainStations;
            Trains = trains;
            Administrators = administrators;
            Passengers = passengers;
        }

        public RailwayTicketOffice(TrainStation trainStations, List<Train> trains, List<Administrator> administrators, List<Passenger> passengers, List<Order> orders)
        {
            TrainStations = trainStations;
            Trains = trains;
            Administrators = administrators;
            Passengers = passengers;
            Orders = orders;
        }

        public void SetTrainStation(TrainStation trainStations)
        {
            TrainStations = trainStations;
        }

        public TrainStation GetCatalog()
        {
            return TrainStations;
        }

        public void SetTrain(List<Train> train)
        {
            Trains = train;
        }

        public List<Train> GetTrain()
        {
            return Trains;
        }

        public void SetAdministrator(List<Administrator> administrator)
        {
            Administrators = administrator;
        }

        public List<Administrator> GetAdministrator()
        {
            return Administrators;
        }

        public void SetPassengers(List<Passenger> passenger)
        {
            Passengers = passenger;
        }

        public List<Passenger> GetPassenger()
        {
            return Passengers;
        }

        public void SetOrder(List<Order> order)
        {
            Orders = order;
        }

        public List<Order> GetOrder()
        {
            return Orders;
        }

        public void AddTrain(Train train)
        {
            TrainStations.AddTrain(train);
        }

        public void RemoveTrain(Train train)
        {
            TrainStations.RemoveTrain(train);
        }

        public void AddAdministrator(Administrator administrator)
        {
            Administrators.Add(administrator);
        }

        public void RemoveAdministrator(Administrator administrator)
        {
            Administrators.Remove(administrator);
        }

        public void AddPassenger(Passenger passenger)
        {
            Passengers.Add(passenger);
        }

        public void RemovePassenger(Passenger passenger)
        {
            Passengers.Remove(passenger);
        }

        public void AddOrder(Order order)
        {
            Orders.Add(order);
        }

        public void RemoveOrder(Order order)
        {
            Orders.Remove(order);
        }

        public Tuple<int, Train> TrainSearch(string StartStation, string EndStation)
        {
            return TrainStations.TrainSearch(StartStation, EndStation);
        }

        public Order ProcessOrder(Passenger passenger, Train train)
        {
            Train orderedTrain = TrainStations.GiveTrain(train);

            if (orderedTrain == null)
            {
                return null;
            }

            Order order = new Order(orderedTrain, passenger);

            bool processed = false;

            while (!processed)
            {
                foreach (Administrator administrator in Administrators)
                {
                    administrator.AddOrder(order);
                    processed = true;
                    break;
                }
            }

            Orders.Add(order);
            return order;
        }
    }
}
