using System.Collections.Generic;

namespace lab4._3._5
{
    public class Library
    {
        private Catalog Catalog = new Catalog();
        private List<Administrator> Administrators = new List<Administrator>();
        private List<Librarian> Librarians = new List<Librarian>();
        private List<Reader> Readers = new List<Reader>(), BlackList = new List<Reader>();
        private List<Order> Orders = new List<Order>();

        private string Deadline = new string("20/12/2021");

        public Library()
        {

        }

        public Library(Catalog catalog)
        {
            Catalog = catalog;
        }

        public Library(Catalog catalog, List<Administrator> administrators)
        {
            Catalog = catalog;
            Administrators = administrators;
        }

        public Library(Catalog catalog, List<Administrator> administrators, List<Librarian> librarians)
        {
            Catalog = catalog;
            Administrators = administrators;
            Librarians = librarians;
        }

        public Library(Catalog catalog, List<Administrator> administrators, List<Librarian> librarians, List<Reader> readers)
        {
            Catalog = catalog;
            Administrators = administrators;
            Librarians = librarians;
            Readers = readers;
        }

        public Library(Catalog catalog, List<Administrator> administrators, List<Librarian> librarians, List<Reader> readers, List<Reader> blackList)
        {
            Catalog = catalog;
            Administrators = administrators;
            Librarians = librarians;
            Readers = readers;
            BlackList = blackList;
        }

        public Library(Catalog catalog, List<Administrator> administrators, List<Librarian> librarians, List<Reader> readers, List<Reader> blackList, List<Order> orders)
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

        public List<Administrator> GetAdministrators() 
        {
            return Administrators;
        }

        public void SetLibrarians(List<Librarian> librarians)
        {
            Librarians = librarians;
        }

        public List<Librarian> GetLibrarians() 
        {
            return Librarians;
        }

        public void SetReaders(List<Reader> readers)
        {
            Readers = readers;
        }

        public List<Reader> GetReaders()
        {
            return Readers;
        }

        public void SetBlackList(List<Reader> blackList)
        {
            BlackList = blackList;
        }

        public List<Reader> GetBlackList()
        {
            return BlackList;
        }

        public void SetOrders(List<Order> orders)
        {
            Orders = orders;
        }

        public List<Order> GetOrders() 
        {
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

        public void AddToBack(Reader reader)
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
            Book orderedBook =  Catalog.GiveBook(book);

            if (orderedBook == null)
            {
                return null;
            }

            string deadline =  GenerateDeadline();
            Order order = new Order(orderedBook, reader, deadline);

            bool processed = false;

            while (!processed)
            {
                foreach (Librarian librarian in Librarians)
                {
                    if (librarian.IsWorking())
                    {
                        librarian.AddOrder(order);
                        processed = true;
                        break;
                    }
                }
            }

            Orders.Add(order);
            return order;
        }

        public void Update()
        {
            bool updated = false;

            while (!updated)
            {
                foreach (Administrator administrator in Administrators)
                {
                    if (administrator.IsWorking())
                    {
                        administrator.Update();
                        updated = true;
                        break;
                    }
                }
            }
        }
    }
}