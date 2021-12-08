namespace lab4._3._5
{
    public class Order
    {
        private Book Book = null;
        private Reader Reader = null;
        private string Deadline;

        public Order(Book book, Reader reader, string deadline)
        {
            Book = book;
            Reader = reader;
            Deadline = deadline;
        }

        public void SetBook(Book book)
        {
            Book = book;
        }

        public Book GetBook()
        {
            return Book;
        }

        public void SetReader(Reader reader)
        {
            Reader = reader;
        }

        public Reader GetReader()
        {
            return Reader;
        }

        public void SetDeadline(string deadline)
        {
            Deadline = deadline;
        }

        public string GetDeadline()
        {
            return Deadline;
        }
    }
}