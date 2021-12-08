using System;

namespace lab4._3._5
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

            Library Library = new Library();
            Library.SetCatalog(Catalog);

            Librarian Librarian = new Librarian(23, "Michael Hunt", Library);
            Administrator Administrator = new Administrator(31, "Bill Ford", Library);
            Reader Reader = new Reader(17, "Charles Holloway");

            Library.AddLibrarian(Librarian);
            Library.AddAdministrator(Administrator);
            Library.AddReader(Reader);

            Librarian.Work();
            Administrator.Work();

            if (Reader.RequestBook(Library, new Book(1949, "1984", "George Orwell")))
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