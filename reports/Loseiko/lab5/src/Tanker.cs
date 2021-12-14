namespace lab5._1._9
{
    public class Tanker : CargoShip
    {
        int WeightLimit = 1;
        int NumOfStaff = 1;

        public Tanker(string name, int size) : base (name, size)
        {

        }

        public Tanker(string name, int size, int weightLimit) : base(name, size)
        {
            WeightLimit = weightLimit;
        }

        public Tanker(string name, int size, int weightLimit, int numOfStaff) : base(name, size)
        {
            WeightLimit = weightLimit;
            NumOfStaff = numOfStaff;
        }

        public void SetWeightLimit(int weightLimit)
        {
            WeightLimit = weightLimit;
        }

        public int GetWeightLimit()
        {
            return WeightLimit;
        }

        public void SetNumOfStaff(int numOfStaff)
        {
            NumOfStaff = numOfStaff;
        }

        public int GetNumOfStaff()
        {
            return NumOfStaff;
        }
    }
}
