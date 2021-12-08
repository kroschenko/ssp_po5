using System;
using System.Collections.Generic;
using System.Text;

namespace lab5._3._5
{
    public abstract class WorkingPerson : Person, Worker
    {
        private bool isWorking = false;

        public WorkingPerson(int Age, string Name) : base(Age, Name)
        {
        }

        public void Work()
        {
            isWorking = true;
        }

        public bool IsWorking()
        {
            return isWorking;
        }

        public void StopWorking()
        {
            isWorking = false;
        }
    }
}