using System;
using System.Collections.Generic;
using System.Reflection;
namespace task1
{
    class Program
    {
        static void Main(string[] args)
        {
            Payment database = new Payment();
            database.AddToList("Car", 2500);
            database.AddToList("Pen", 17);
            Console.WriteLine(database.FullPrice());
            database.ShowInfo();
            Console.WriteLine();
            database.DeleteFromList(1);
            database.ShowInfo();
        }
    }
    class Payment
    {
        List<Good> Goods = new List<Good>();
        public void AddToList(string _Name, int _Price)
        {
            Good obj = new Good(_Name, _Price);
            Goods.Add(obj);
        }
        public void DeleteFromList(int index)
        {
            Goods.RemoveAt(index);
        }
        public int FullPrice()
        {
            int sum = 0;
            foreach (var item in Goods)
            {
                sum += item.Price;
            }
            return sum;
        }
        public void ShowInfo()
        {
            foreach (var item in Goods)
            {
                Console.WriteLine(item.Name + " " + item.Price);
            }
        }
        public class Good
        {
            public Good(string _Name, int _Price)
            {
                Name = _Name;
                Price = _Price;
            }
            public string Name { get; set; }
            public int Price { get; set; }
        }
    }
}
