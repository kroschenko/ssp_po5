using System;

namespace lab5._3._5
{
    class Program
    {
        static void Main(string[] args)
        {
            Catalog Catalog = new Catalog();
            Catalog.AddBook(new Book(2008, "Fahrenheit 451", "Ray Bradbury"));
            Catalog.AddBook(new Book(1949, "1984", "George Orwell"));
            Catalog.AddBook(new Book(2006, "The Master and Margarita", "Michael Bulgakov"));
            Catalog.AddBook(new Book(2003, "Shantaram", "Gregory David Roberts"));
            Catalog.AddBook(new Book(2002, "The Lovely Bones", "Alice Sebold"));

            Library Library = new Library(new string("Central Library"), new string("blvd. Shevchenko 3"), 400, 10, new string("08:00 - 20:00"));
            Library.SetCatalog(Catalog);

            Librarian Librarian = new Librarian(65, "Mayson Falconer", Library);
            Administrator Administrator = new Administrator(31, "Janette Trueman", Library);
            Reader Reader = new Reader(16, "Conner Thacker");

            Library.AddLibrarian(Librarian);
            Library.AddAdministrator(Administrator);
            Library.AddReader(Reader);

            Librarian.Work();
            Administrator.Work();

            Console.WriteLine(new string("Name: ") + Library.GetName());
            Console.WriteLine(new string("Address: ") + Library.GetAddress());
            Console.WriteLine(new string("Visitors count: ") + Library.GetVisitorsCount());
            Console.WriteLine(new string("Visit price: ") + Library.GetVisitPrice());
            Console.WriteLine(new string("Work time: ") + Library.GetWorkTime());
            Console.WriteLine();

            if (Reader.RequestBook(Library, new Book(2006, "The Master and Margarita", "Michael Bulgakov")))
            {
                Console.WriteLine("Book successfully taken");
            }
            else
            {
                Console.WriteLine("Can not take a book");
            }

            Library.Update();
        }
    }
}