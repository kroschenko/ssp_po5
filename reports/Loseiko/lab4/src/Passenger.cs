using System;
using System.Collections.Generic;
using System.Text;

namespace lab4._3._9
{
    public class Passenger : Person
    {
        private List<Order> Orders = new List<Order>();
        private int Bill = 0;
        private Check Check = null;

        public Passenger(int Age, string Name) : base(Age, Name)
        {

        }

        public Passenger(int Age, string Name, int Bill) : base(Age, Name)
        {
            this.Bill = Bill;
        }

        public Passenger(int Age, string Name, int Bill, List<Order> Orders) : base(Age, Name)
        {
            this.Bill = Bill;
            this.Orders = Orders;
        }

        public Passenger(int Age, string Name, int Bill, List<Order> Orders, Check Check) : base(Age, Name)
        {
            this.Bill = Bill;
            this.Orders = Orders;
            this.Check = Check;
        }

        public void SetOrders(List<Order> orders)
        {
            Orders = orders;
        }

        public List<Order> GetOrders()
        {
            return Orders;
        }

        public void SetCheck(Check check)
        {
            Check = check;
        }

        public Check GetCheck()
        {
            return Check;
        }

        public void SetBill(int bill)
        {
            Bill = bill;
        }

        public int GetBill()
        {
            return Bill;
        }

        public void AddOrder(Order order)
        {
            Orders.Add(order);
        }

        public void RemoveOrder(Order order)
        {
            Orders.Remove(order);
        }

        public bool AddCheck(Train train)
        {
            if(Bill - train.GetPrice() >= 0)
            {
                Bill -= train.GetPrice();
                return true;
            }
            return false;
        }

        public bool RequestOrderAndCheck(RailwayTicketOffice railwayTicketOffice, string StartStation, string EndStation, TrainStation trainStation)
        {
            var temp = railwayTicketOffice.TrainSearch(StartStation, EndStation);
            if (temp.Item1 != -1)
            {
                Order order = railwayTicketOffice.ProcessOrder(this, temp.Item2);

                if (order == null)
                {
                    return false;
                }

                AddOrder(order);
                return AddCheck(temp.Item2);
            }
            return false;
        }
    }
}
