namespace lab6._3._5
{
    public class Person
    {
        string Name;
        int Bill, Password;
        bool isBlocked = false;

        public Person(string name, int bill, int password)
        {
            Name = name;
            Bill = bill;
            Password = password;
        }
        public void SetName(string name)
        {
            Name = name;
        }
        public string GetName()
        {
            return Name;
        }
        public void SetBill(int bill)
        {
            Bill = bill;
        }
        public int GetBill()
        {
            return Bill;
        }
        public void SetPassword(int password)
        {
            Password = password;
        }
        public int GetPassword()
        {
            return Password;
        }
        public void SetIsBlocked(bool is_Blocked)
        {
            isBlocked = is_Blocked;
        }
        public bool GetIsBlocked()
        {
            return isBlocked;
        }
    }
}