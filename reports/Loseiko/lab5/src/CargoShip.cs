namespace lab5._1._9
{
    public abstract class CargoShip
    {
        private bool isCreated = false, isSail = false;
        private string Name = "";
        private int Size = 1;

        public CargoShip(string name, int size)
        {
            Name = name;
            Size = size;
        }

        public void SetName(string name)
        {
            Name = name;
        }

        public string GetName()
        {
            return Name;
        }

        public void SetSize(int size)
        {
            Size = size;
        }

        public int GetSize()
        {
            return Size;
        }

        public bool IsCreate()
        {
            return isCreated;
        }

        public bool IsSail()
        {
            return isSail;
        }

        public void Create()
        {
            isCreated = true;
        }

        public void Destroy()
        {
            isCreated = false;
        }

        public void Sail()
        {
            isSail = true;
        }

        public void DontSail()
        {
            isSail = false;
        }
    }
}