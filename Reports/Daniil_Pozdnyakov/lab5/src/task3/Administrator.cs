using System;
using System.Collections.Generic;
using System.Text;

namespace lab5._3._5
{
    public class Administrator : WorkingPerson
    {
        private Library Library = null;

        public Administrator(int Age, string Name, Library Library) : base(Age, Name)
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

        public void AddToBlackList(Reader Reader)
        {
            Library.AddToBlackList(Reader);
        }

        public void Update()
        {
            foreach (Order Order in Library.GetOrders())
            {
                if (!Library.CheckDeadline(Order))
                {
                    AddToBlackList(Order.GetReader());
                }
            }
        }
    }
}