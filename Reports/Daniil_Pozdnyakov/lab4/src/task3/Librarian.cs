namespace lab4._3._5
{
    public class Librarian : WorkingPerson
    {
        private Library Library = new Library();

        public Librarian(int age, string name, Library library) : base(age, name)
        {
            Library = library;
        }

        public void SetLibrary(Library library)
        {
            Library = library;
        }

        public Library GetLibrary()
        {
            return Library;
        }

        public void AddOrder(Order order)
        {
            Library.AddOrder(order);
        }
    }
}