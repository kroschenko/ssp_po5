using System;
using System.Collections.Generic;
using System.Text;

namespace lab5._3._5
{
    public class Catalog
    {
        private List<Book> Books = new List<Book>();

        public Catalog()
        {
        }

        public Catalog(List<Book> books)
        {
            Books = books;
        }

        public void SetBooks(List<Book> books)
        {
            Books = books;
        }

        public List<Book> GetBooks() {
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
            for(int i = 0; i < Books.Count; i++)
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
            int Index = -1;

            for (int i = 0; i < Books.Count; i++)
            {
                if (Books[i].GetAuthor() == book.GetAuthor() && Books[i].GetTitle() == book.GetTitle() && Books[i].GetYear() == book.GetYear())
                {
                    Index = i;
                    break;
                }
            }

            if (Index == -1)
            {
                return null;
            }

            Book Result = Books[Index];
            RemoveBook(book);

            return Result;
        }
    }
}