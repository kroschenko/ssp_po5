using System;
using System.Collections.Generic;
using System.Text;

namespace lab5._3._5
{
    public interface Worker
    {
        public void Work();

        public bool IsWorking();

        public void StopWorking();
    }
}