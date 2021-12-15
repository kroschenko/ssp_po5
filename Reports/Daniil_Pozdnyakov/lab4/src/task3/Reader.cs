using System.Collections.Generic;

namespace lab4._3._5
{
    public class Reader : Person
    {
        private List<Order> Orders = new List<Order>();

        public Reader(int Age, string Name) : base(Age, Name)
        {

        }

        public Reader(int Age, string Name, List<Order> Orders) : base(Age, Name)
        {
            this.Orders = Orders;
        }
        public void SetOrders(List<Order> orders)
        {
            Orders = orders;
        }

        public List<Order> GetOrders()
        {
            return Orders;
        }

        public void AdrOrder(Order order)
        {
            Orders.Add(order);
        }

        public void RemoveOrder(Order order)
        {
            Orders.Remove(order);
        }

        public bool RequestBook(Library library, Book book)
        {
            if (library.BookSearch(book))
            {
                Order order = library.ProcessOrder(this, book);

                if (order == null)
                {
                    return false;
                }

                AdrOrder(order);
                return true;
            }
            return false;
        }
    }
}