using System;

namespace lab4._3._5
{
    public class Book
    {
        private int Year = 0;
        private string Title, Author;

        public Book(int year, string title, string author)
        {
            Year = year;
            Title = title;
            Author = author;
        }

        public void SetYear(int year)
        {
            Year = year;
        }

        public int GetYear()
        {
            return Year;
        }

        public void SetTitle(string title)
        {
            Title = title;
        }

        public string GetTitle()
        {
            return Title;
        }

        public void SetAuthor(string author)
        {
            Author = author;
        }

        public string GetAuthor()
        {
            return Author;
        }

        public bool _Equals(object c_Other)
        {
            if (GetYear().Equals(((Book)c_Other).GetYear()) && GetTitle().Equals(((Book)c_Other).GetTitle()) && GetAuthor().Equals(((Book)c_Other).GetAuthor()))
            {
                return true;
            }
            return false;
        }
    }
}
