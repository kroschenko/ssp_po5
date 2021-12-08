namespace lab4._3._5
{
    public class WorkingPerson : Person, Worker
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

        public void f_stop_working()
        {
            isWorking = false;
        }
    }
}