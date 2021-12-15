using System;

namespace lab6._3._5
{
    public class Authentication : ATMState
    {
        Person person;
        public Authentication(Person per)
        {
            person = per;
        }
        public void Expectation_(ATM atm)
        {
            if (person.GetIsBlocked() == true)
            {
                Blocking_(atm);
                return;
            }
            Console.WriteLine("Ожидание ввода данных...");
        }
        public void Authentication_(ATM atm)
        {
            if (person.GetIsBlocked() == true)
            {
                Blocking_(atm);
                return;
            }
            int pin, numTry = 0;

            do
            {
                Console.WriteLine("Введите пароль:");
                pin = Convert.ToInt32(Console.ReadLine());
                if (person.GetPassword() == pin)
                {
                    Console.WriteLine("Пароль введён верно!");
                    return;
                }
                else
                {
                    Console.WriteLine("Пароль введён неверно!");
                    numTry++;
                    if (numTry == 3)
                    {
                        Blocking_(atm);
                        return;
                    }
                }
            }
            while (person.GetPassword() != pin);
        }
        public void PerformingOperation_(ATM atm)
        {
            if (person.GetIsBlocked() == true)
            {
                Blocking_(atm);
                return;
            }
            Console.WriteLine("Введите сууму для снятия: ");
            int sum = Convert.ToInt32(Console.ReadLine());

            if (sum > person.GetBill())
            {
                Console.WriteLine("Недостаточно денег на счёте!");
            }
            if (sum <= person.GetBill())
            {
                person.SetBill(person.GetBill() - sum);
                Console.WriteLine("Выдача денег...");
                Console.WriteLine("Остаток на счёте: " + person.GetBill());
            }
        }
        public void Blocking_(ATM atm)
        {
            person.SetIsBlocked(true);
            Console.WriteLine("Ваша карта заблокирована!");
        }
    }
}
