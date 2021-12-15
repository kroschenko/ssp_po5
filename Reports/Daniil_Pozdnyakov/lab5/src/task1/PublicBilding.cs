namespace lab5._1._5
{
    public abstract class PublicBuilding : TownBuilding
    {
        private int VisitorsCount = 0;
        private double VisitPrice = 0.0;
        private string WorkTime = new string("00:00 - 00:00");

        public PublicBuilding(string name, string address) : base (name, address)
        {

        }

        public PublicBuilding(string  name, string address, int visitorsCount) : base ( name, address)
        {
            VisitorsCount = visitorsCount;
        }

        public PublicBuilding(string  name, string address, int visitorsCount, double visitPrice) : base( name, address)
        {
            VisitorsCount = visitorsCount;
            VisitPrice = visitPrice;
        }

        public PublicBuilding(string  name, string address, int visitorsCount, double visitPrice, string workTime) : base( name, address)
        {
            VisitorsCount = visitorsCount;
            VisitPrice = visitPrice;
            WorkTime = workTime;
        }

        public string GetWorkTime()
        {
            return WorkTime;
        }

        public void SetWorkTime(string workTime)
        {
            WorkTime = workTime;
        }

        public int GetVisitorsCount()
        {
            return VisitorsCount;
        }

        public void SetVisitorsCount(int visitorsCount)
        {
            VisitorsCount = visitorsCount;
        }

        public double GetVisitPrice()
        {
            return VisitPrice;
        }

        public void SetVisitPrice(double visitPrice)
        {
            VisitPrice = visitPrice;
        }
    }
}