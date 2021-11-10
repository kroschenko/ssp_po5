using System;
using System.Linq;
using System.IO;
using System.Collections.Generic;

namespace lab3._2._9
{
    class Program
    {
        static Product[] TakeDataFromFile(string[] args_)
        {
            string[] arr = ReadFile();

            Product[] storage = new Product[Convert.ToInt32(args_[0])];
            char[] separators = new char[] { ' ', '\r', '\n' };
            string[] subs;
            for (int i = 0; i < storage.Length; i++)
            {
                storage[i] = new Product();
                string str = arr[i];
                subs = str.Split(separators, StringSplitOptions.RemoveEmptyEntries);

                storage[i].ID = i + 1;
                storage[i].Name = subs[0];
                storage[i].UPC = subs[1];
                storage[i].Producer = subs[2];
                storage[i].Price = Convert.ToInt32(subs[3]);
                storage[i].Date = DateTime.Parse(subs[4]);
                storage[i].Quantity = Convert.ToInt32(subs[5]);
            }
            return storage;
        }
        static string[] ReadFile()
        {
            StreamReader read = new StreamReader("1.txt", System.Text.Encoding.Default);
            var list = new List<string>();
            while (!read.EndOfStream)
            {
                string line = read.ReadLine();
                list.Add(line);
            }

            //Массив string[]              
            string[] arr = list.ToArray();

            return arr;
        }

        static void GenerateStorage(Product[] storage)
        {
            for (int i = 0; i < storage.Length; i++)
            {
                storage[i] = new Product();
                storage[i].ID = i + 1;
            }
        }
        static void Main(string[] args)
        {
            Product[] Storage = new Product[Convert.ToInt32(args[0])];

            Console.WriteLine("Сгенерировать склад (1) или Загрузить склад из файла (2): ");
            
            switch(Console.ReadLine())
            {
                case "1":
                    GenerateStorage(Storage);

                    Console.WriteLine("Весь список склада:\n");
                    for (int i = 0; i < Storage.Length; i++)
                    {
                        Storage[i].Print();
                    }

                    Console.WriteLine("\nСписок товаров, срок хранения которых истек:\n");
                    for (int i = 0; i < Storage.Length; i++)
                    {
                        Storage[i].PrintDate();
                    }

                    Console.WriteLine("\nСписок товаров для заданного наименования:\n");
                    for (int i = 0; i < Storage.Length; i++)
                    {
                        Storage[i].PrintName("Карандаш");
                    }

                    Console.WriteLine("\nСписок товаров для заданного наименования, цена которых не превосходит заданную:\n");
                    for (int i = 0; i < Storage.Length; i++)
                    {
                        Storage[i].PrintNameAndLowerPrices("Карандаш", 5);
                    }
                    break;
                case "2":
                    Storage = TakeDataFromFile(args);

                    Console.WriteLine("Весь список склада:\n");
                    for (int i = 0; i < Storage.Length; i++)
                    {
                        Storage[i].Print();
                    }

                    Console.WriteLine("\nСписок товаров, срок хранения которых истек:\n");
                    for (int i = 0; i < Storage.Length; i++)
                    {
                        Storage[i].PrintDate();
                    }

                    Console.WriteLine("\nСписок товаров для заданного наименования:\n");
                    for (int i = 0; i < Storage.Length; i++)
                    {
                        Storage[i].PrintName("Карандаш");
                    }

                    Console.WriteLine("\nСписок товаров для заданного наименования, цена которых не превосходит заданную:\n");
                    for (int i = 0; i < Storage.Length; i++)
                    {
                        Storage[i].PrintNameAndLowerPrices("Карандаш", 5);
                    }
                    break;
                default:
                    Console.WriteLine("Введено неверное значение!");
                    break;
            }
        }
    }
}
