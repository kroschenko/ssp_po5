namespace lab4._3._5
{
    public class Administrator : WorkingPerson
    {
        private Library library = new Library();

        public Administrator(int age, string name, Library library) : base (age, name)
        {
            this.library = library;
        }

        public void SetLibrary(Library library)
        {
            this.library = library;
        }

        public Library GetLibrary()
        {
            return library;
        }

        public void AddToBack(Reader reader)
        {
            library.AddToBack(reader);
        }

        public void Update()
        {
            foreach (Order order in library.GetOrders())
            {
                if (!library.CheckDeadline(order))
                {
                    this.AddToBack(order.GetReader());
                }
            }
        }
    }
}
