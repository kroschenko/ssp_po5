using System;
using System.Collections.Generic;
using System.Text;

namespace lab3._2._9
{
    class Product
    {
        private int id;
        private string name;
        private string upc;
        private string producer;
        private int price;
        private DateTime date;
        private int quantity;

        public int ID
        {
            get
            {
                return id;
            }
            set
            {
                id = value;
            }
        }

        public string Name
        {
            get
            {
                return name;
            }
            set
            {
                name = value;
            }
        }

        public string UPC
        {
            get
            {
                return upc;
            }
            set
            {
                upc = value;
            }
        }

        public string Producer
        {
            get
            {
                return producer;
            }
            set
            {
                producer = value;
            }
        }

        public int Price
        {
            get
            {
                return price;
            }
            set
            {
                price = value;
            }
        }

        public DateTime Date
        {
            get
            {
                return date;
            }
            set
            {
                date = value;
            }
        }

        public int Quantity
        {
            get
            {
                return quantity;
            }
            set
            {
                quantity = value;
            }
        }

        public Product()
        {
            Random temp = new Random();
            string[] name_ = new string[] { "Ручка", "Карандаш", "Тетрадь", "Ластик", "Скребка", "Бумага", "Степлер", "Ножницы" };
            string[] producer_ = new string[] { "Bogue_Dream", "Cerciocastro", "Fournachem", "Rittenhouse", "Grant_Design", "Fine_Lotus", "River_And_Neck", "Creative_Space" };
            Name = name_[temp.Next(0, 8)];
            UPC = temp.Next(100000000, 999999999).ToString();
            Producer = producer_[temp.Next(0, 8)];
            Price = temp.Next(1, 10);
            Date = RandomDay();
            Quantity = temp.Next(0, 1001);
        }

        DateTime RandomDay()
        {
            Random temp = new Random();
            DateTime start = new DateTime(2021, 1, 1);
            DateTime end = new DateTime(2025, 1, 1);
            int range = (end - start).Days;
            return start.AddDays(temp.Next(range));
        }

        public void Print()
        {
            Console.WriteLine("ID #{0}\t Наименование: {1}\t UPC: {2}\t Производитель: {3}\t Цена: {4}\t Срок хранения: {5:d}\t Количество: {6}", ID, Name, UPC, Producer, Price, Date, Quantity);
        }

        public void PrintName(string name)
        {
            if(name == Name)
            {
                Print();
            }
        }

        public void PrintNameAndLowerPrices(string name, int price)
        {
            if(price > Price)
            {
                PrintName(name);
            }
        }

        public void PrintDate()
        {
            var periodNow = DateTime.Now;
            if (Date < periodNow)
            {
                Print();
            }
        }
    }
}
