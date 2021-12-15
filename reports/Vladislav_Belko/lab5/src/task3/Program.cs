using System;
using System.Collections.Generic;
namespace task3
{
    class Program
    {
        static void Main(string[] args)
        {
            Payments.Client client1 = new Payments.Client();
            Payments.Client client2 = new Payments.Client();
            Good good1 = new Good
            {
                Sum = 200,
            };
            Payments.Administrator admin = new Payments.Administrator();
            Console.WriteLine("Count client1: " + client1.GetCount());
            client1.Pay(good1);
            Console.WriteLine("Count client1: " + client1.GetCount());
            Console.WriteLine("Count client2: " + client2.GetCount());
            client1.PayTo(client2.GetAccount(), 10000);
            Console.WriteLine("Count client1: " + client1.GetCount());
            Console.WriteLine("Count client2: " + client2.GetCount());
            Console.WriteLine("Close Account client2");
            client2.CloseAccount();
            Console.WriteLine("Close Card client2");
            client2.CloseCard();
            Console.WriteLine("Admin close Card client1");
            admin.BlockClientCard(client1);
            admin.ShowInfo();
            client2.ShowInfo();
        }
    }
    public class Good
    {
        public int Sum { get; set; }
    }
    public class Payments
    {
        static public List<Client> Clients = new List<Client>();
        public abstract class User
        {
            public virtual void ShowInfo() { }
        }
        public class Client : User
        {
            Account account;
            CCard card;
            int _code;
            public override void ShowInfo()
            {
                Console.WriteLine(_code + " root");
            }
            public Client()
            {
                Random random = new Random();
                _code = random.Next(100, 999);
                account = new Account(5000);
                card = new CCard(account);
                Clients.Add(this);
            }
            public void Pay(Good good) // using Card
            {
                card.Pay(good);
            }
            public void PayTo(Account other, int sum) // using Card
            {
                card.PayTo(other, sum);
            }
            public void CloseCard() // using Card
            {
                card.Close();
            }
            public void CloseAccount() // using Account
            {
                account.CloseAccount();
            }
            public int GetCount()
            {
                return card.Count();
            }
            public Account GetAccount()
            {
                return account;
            }
        }
        public class Administrator : User
        {
            public override void ShowInfo()
            {
                Console.WriteLine("Admin root");
            }
            public void BlockClientCard(Client obj)
            {
                if (obj.GetCount() < 0)
                {
                    obj.CloseCard();
                }
                else Console.WriteLine("Card is not blocked. The count is correct.");
            }
        }
        public class CCard
        {
            public Account Account;
            public bool Closed;
            public CCard(Account _account) // any Card has Account
            {
                Closed = false;
                Account = _account;
            }
            public void Close()
            {
                Closed = true;
                Console.WriteLine("The card was closed.");
            }
            public int Count() // return Count from Account
            {
                if (Closed)
                {
                    Console.WriteLine("Card is locked");
                    return 0;
                }
                else return Account.Count;
            }
            public void Pay(Good obj) // taking Good and change our Count
            {
                if (Closed)
                {
                    Console.WriteLine("Card is locked");
                    return;
                }
                else
                {
                    Account.TakeSum(obj.Sum);
                    Console.WriteLine("The good was paid.");
                }
            }
            public void PayTo(Account other, int sum)
            {
                if (Closed)
                {
                    Console.WriteLine("Card is locked");
                    return;
                }
                else
                {
                    Account.TakeSum(sum);
                    other.AddSum(sum);
                    Console.WriteLine("The sum was sent to the other client.");
                }
            }
        }
        public class Account
        {
            public int Number { get; private set; } // the private number of the Account
            public int Count { get; set; } // the Count
            public bool Validation { get; private set; } // private Validation
            public void CloseAccount()
            {
                Validation = false;
                Console.WriteLine("The account was closed.");
            }
            public Account(int _count)
            {
                Random random = new Random();
                Number = random.Next(1000, 9999); // the number is random value
                Count = _count; // open on our private Sum
                Validation = true; // default - Account is valid
            }
            public void AddSum(int sum) // add some sum to Count
            {
                if (!Validation)
                {
                    Console.WriteLine("Account is not valid");
                    return;
                }
                else Count += sum;
            }
            public void TakeSum(int sum) // take some sum from Count
            {
                if (!Validation)
                {
                    Console.WriteLine("Account is not valid");
                    return;
                }
                else
                {
                    Count -= sum;
                }
            }
        }
    }
}
