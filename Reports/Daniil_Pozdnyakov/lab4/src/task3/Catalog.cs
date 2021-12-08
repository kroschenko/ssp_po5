using System.Collections.Generic;

namespace lab4._3._5
{
    public class Catalog
    {
        private List<Book> Books = new List<Book>();
        
        public Catalog()
        {
        }

        public Catalog(List<Book> book)
        {
            Books = book;
        }

        public void SetBooks(List<Book> book)
        {
            Books = book;
        }

        public List<Book> GetBooks() 
        {
            return Books;
        }

        public void AddBook(Book book)
        {
            Books.Add(book);
        }

        public void RemoveBook(Book book)
        {
            Books.Remove(book);
        }

        public bool BookSearch(Book book)
        {
            for (int i = 0; i < Books.Count; i++)
            {
                if (Books[i].GetAuthor() == book.GetAuthor() && Books[i].GetTitle() == book.GetTitle() && Books[i].GetYear() == book.GetYear())
                {
                    return true;
                }
            }

            return false;
        }

        public Book GiveBook(Book book)
        {
            int index = -1;

            for (int i = 0; i < Books.Count; i++)
            {
                if (Books[i].GetAuthor() == book.GetAuthor() && Books[i].GetTitle() == book.GetTitle() && Books[i].GetYear() == book.GetYear())
                {
                    index = i;
                }
            }

            if (index == -1)
            {
                return null;
            }
            
            Book result = Books[index];
            RemoveBook(book);

            return result;
        }
    }
}