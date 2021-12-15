using System;
using System.Collections.Generic;
using System.Text;

namespace lab5._3._5
{
    public class Librarian : WorkingPerson
    {
        private Library Library = null;

        public Librarian(int Age, string Name, Library Library) : base(Age, Name)
        {
            this.Library = Library;
        }

        public void SetLibrary(Library Library)
        {
            this.Library = Library;
        }

        public Library GetLibrary()
        {
            return Library;
        }

        public void AddOrder(Order Order)
        {
            Library.AddOrder(Order);
        }
    }
}