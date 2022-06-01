using System;
using System.Collections.Generic;
using System.IO;
namespace Task2
{
    class Program
    {
        static void ReadFile(int number, string path)
        {
            List<string> values = new List<string>();
            string value;
            using (StreamReader sr = new StreamReader(path))
            {
                while ((value = sr.ReadLine()) != null)
                {
                    values.Add(value);
                }
            }
            for (int i = values.Count - number; i < values.Count; ++i)
            {
                Console.WriteLine(values[i]);
            }
        }
        static void task2(string[] args)
        {
            if (args.Length > 4 || args.Length < 2) throw new Exception("Wrong command");
            if (args[0] != "tail") throw new Exception("Wrong command");
            if (args.Length == 2)
            {
                if (File.Exists(args[1]))
                {
                    ReadFile(10, args[1]);
                }
                else throw new Exception("File not exists");
            }

            if (args.Length == 3)
            {
                if (File.Exists(args[2]))
                {
                    int number;
                    int.TryParse(args[1], out number);
                    ReadFile(number, args[2]);
                }
                else throw new Exception("File not exists");
            }
            if (args.Length == 4)
            {
                if (File.Exists(args[3]))
                {
                    int number;
                    int.TryParse(args[2], out number);
                    ReadFile(number, args[3]);
                }
                else throw new Exception("File not exists");
            }
        }
        static void Main(string[] args)
        {
            try
            {
                task2(args);
                Console.ReadKey();
            }
            catch (Exception Ex)
            {
                Console.WriteLine(Ex.Message);
            }
        }
    }
}
