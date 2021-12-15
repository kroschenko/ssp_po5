using System;

namespace lab5._3._5
{
    public abstract class TownBuilding : Building
    {
        private bool IsCreated = false, IsOpen = false;
        private string Name, Address;

        public TownBuilding(string name, string address)
        {
            Name = name;
            Address = address;
        }

        public void SetName(string name)
        {
            Name = name;
        }

        public string GetName()
        {
            return Name;
        }

        public void SetAddress(string address)
        {
            Address = address;
        }

        public string GetAddress()
        {
            return Address;
        }

        public void create()
        {
            IsCreated = true;
        }

        public void destroy()
        {
            IsCreated = false;
        }

        public bool isCreated()
        {
            return IsCreated;
        }

        public void open()
        {
            IsOpen = true;
        }

        public void close()
        {
            IsOpen = false;
        }

        public bool isOpen()
        {
            return IsOpen;
        }
    }
}