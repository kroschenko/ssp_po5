using System;

namespace lab5._1._5
{
    public abstract class TownBuilding : Building
    {
        private bool isCreated = false, isOpen = false;
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

        public void SetAdress(string address)
        {
            Address = address;
        }

        public string GetAddress()
        {
            return Address;
        }

        public void Create()
        {
            isCreated = true;
        }

        public void Destroy()
        {
            isCreated = false;
        }

        public bool IsCreated()
        {
            return isCreated;
        }

        public void Open()
        {
            isOpen = true;
        }

        public void Close()
        {
            isOpen = false;
        }

        public bool IsOpen()
        {
            return isOpen;
        }
    }
}