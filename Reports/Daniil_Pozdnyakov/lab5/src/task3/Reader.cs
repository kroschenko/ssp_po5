using System.Collections.Generic;

namespace lab5._3._5
{
    public class Reader : Person
    {
        private List<Order> Orders = new List<Order>();

        public Reader(int Age, string Name) : base(Age, Name)
            {
        }

        public Reader(int Age, string Name, List<Order> Order) : base(Age, Name)
            {
            Orders = Order;
        }

        public void SetOrders(List<Order> Order)
        {
            Orders = Order;
        }

        public List<Order> GetOrders()
        {
            return Orders;
        }

        public void AddOrder(Order order)
        {
            Orders.Add(order);
        }

        public void RemoveOrder(Order order)
        {
            Orders.Remove(order);
        }

        public bool RequestBook(Library Library, Book Book)
        {
            if (Library.BookSearch(Book))
            {
                Order order = Library.ProcessOrder(this, Book);

                if (order == null)
                {
                    return false;
                }

                AddOrder(order);
                return true;
            }

            return false;
        }
    }
}