namespace lab6._3._5
{
    public class ATM
    {
        private ATMState State;

        public ATMState GetState()
        {
            return State;
        }

        public void SetState(ATMState state)
        {
            State = state;
        }

        public ATM(ATMState state)
        {
            State = state;
        }

        public void Expectation()
        {
            State.Expectation_(this);
        }
        public void Authentication()
        {
            State.Authentication_(this);
        }
        public void PerformingOperation()
        {
            State.PerformingOperation_(this);
        }
        public void Blocking()
        {
            State.Blocking_(this);
        }
    }
}