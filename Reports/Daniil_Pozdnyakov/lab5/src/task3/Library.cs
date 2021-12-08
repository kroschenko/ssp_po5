using System;
using System.Collections.Generic;
using System.Text;

namespace lab5._3._5
{
    public class Library : PublicBuilding
    {
        private Catalog Catalog = new Catalog();
        private List<Administrator> Administrators = new List<Administrator>();
        private List<Librarian> Librarians = new List<Librarian>();
        private List<Reader> Readers = new List<Reader>(), BlackList = new List<Reader>();
        private List<Order> Orders = new List<Order>();

        private string Deadline = new string("11/12/2021");

        public Library(string Name, string Address) : base(Name, Address)
        {
        }

        public Library(string Name, string Address, int VisitorsCount) : base(Name, Address, VisitorsCount)
        {
        }

        public Library(string Name, string Address, int VisitorsCount, double VisitPrice) : base(Name, Address, VisitorsCount, VisitPrice)
        {
        }

        public Library(string Name, string Address, int VisitorsCount, double VisitPrice, string WorkTime) : base(Name, Address, VisitorsCount, VisitPrice, WorkTime)
        {
        }

        public Library(string Name, string Address, Catalog catalog) : base(Name, Address)
        {
            Catalog = catalog;
        }

        public Library(string Name, string Address, Catalog catalog, List<Administrator> administrators) : base(Name, Address)
        {
            Catalog = catalog;
            Administrators = administrators;
        }

        public Library(string Name, string Address, Catalog catalog, List<Administrator> administrators, List<Librarian> librarians) : base(Name, Address)
        {
            Catalog = catalog;
            Administrators = administrators;
            Librarians = librarians;
        }

        public Library(string Name, string Address, Catalog catalog, List<Administrator> administrators, List<Librarian> librarians, List<Reader> readers) : base(Name, Address)
        {
            Catalog = catalog;
            Administrators = administrators;
            Librarians = librarians;
            Readers = readers;
        }

        public Library(string Name, string Address, Catalog catalog, List<Administrator> administrators, List<Librarian> librarians, List<Reader> readers, List<Reader> blackList) : base(Name, Address)
        {
            Catalog = catalog;
            Administrators = administrators;
            Librarians = librarians;
            Readers = readers;
            BlackList = blackList;
        }

        public Library(string Name, string Address, Catalog catalog, List<Administrator> administrators, List<Librarian> librarians, List<Reader> readers, List<Reader> blackList, List<Order> orders) : base(Name, Address)
        {
            Catalog = catalog;
            Administrators = administrators;
            Librarians = librarians;
            Readers = readers;
            BlackList = blackList;
            Orders = orders;
        }

        public void SetCatalog(Catalog catalog)
        {
            Catalog = catalog;
        }

        public Catalog GetCatalog()
        {
            return Catalog;
        }

        public void SetAdministrators(List<Administrator> administrators)
        {
            Administrators = administrators;
        }

        public List<Administrator> GetAdministrators() {
            return Administrators;
        }

        public void SetLibrarians(List<Librarian> librarians)
        {
            Librarians = librarians;
        }

        public List<Librarian> GetLibrarians() {
            return Librarians;
        }

        public void SetReaders(List<Reader> readers)
        {
            Readers = readers;
        }

        public List<Reader> GetReaders() {
            return Readers;
        }

        public void SetBlackList(List<Reader> blackList)
        {
            BlackList = blackList;
        }

        public List<Reader> GetBlackList() {
            return BlackList;
        }

        public void SetOrders(List<Order> orders)
        {
            Orders = orders;
        }

        public List<Order> GetOrders() {
            return Orders;
        }

        public void AddBook(Book book)
        {
            Catalog.AddBook(book);
        }

        public void RemoveBook(Book book)
        {
            Catalog.RemoveBook(book);
        }

        public void AddAdministrator(Administrator administrator)
        {
            Administrators.Add(administrator);
        }

        public void RemoveAdministrator(Administrator administrator)
        {
            Administrators.Remove(administrator);
        }

        public void AddLibrarian(Librarian librarian)
        {
            Librarians.Add(librarian);
        }

        public void RemoveLibrarian(Librarian librarian)
        {
            Librarians.Remove(librarian);
        }

        public void AddReader(Reader reader)
        {
            Readers.Add(reader);
        }

        public void RemoveReader(Reader reader)
        {
            Readers.Remove(reader);
        }

        public void AddToBlackList(Reader reader)
        {
            BlackList.Add(reader);
        }

        public void RemoveFromBlackList(Reader reader)
        {
            BlackList.Remove(reader);
        }

        public void AddOrder(Order order)
        {
            Orders.Add(order);
        }

        public void RemoveOrder(Order order)
        {
            Orders.Remove(order);
        }

        public bool BookSearch(Book book)
        {
            return Catalog.BookSearch(book);
        }

        public string GenerateDeadline()
        {
            return Deadline;
        }

        public bool CheckDeadline(Order order)
        {
            return Deadline.Equals(order.GetDeadline());
        }

        public Order ProcessOrder(Reader reader, Book book)
        {
            Book OrderedBook = Catalog.GiveBook(book);

            if (OrderedBook == null)
            {
                return null;
            }

            string Deadline = this.GenerateDeadline();
            Order order = new Order(OrderedBook, reader, Deadline);

            bool Processed = false;

            while (!Processed)
            {
                foreach (Librarian librarian in Librarians)
                {
                    if (librarian.IsWorking())
                    {
                        librarian.AddOrder(order);
                        Processed = true;
                        break;
                    }
                }
            }

            Orders.Add(order);
            return order;
        }

        public void Update()
        {
            bool Updated = false;

            while (!Updated)
            {
                foreach (Administrator administrator in Administrators)
                {
                    if (administrator.IsWorking())
                    {
                        administrator.Update();
                        Updated = true;
                        break;
                    }
                }
            }
        }
    }
}