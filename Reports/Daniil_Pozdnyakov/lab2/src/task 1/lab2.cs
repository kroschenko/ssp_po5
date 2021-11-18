using System;
using System.IO;

namespace lab2
{
    class lab2
    {
        static void Main(string[] args)
        {
            string path = @"D:\repos\spp\lab2\SomeText.txt";

            // чтение из файла
            FileStream fstream = File.OpenRead(path);

            // преобразуем строку в байты
            byte[] array = new byte[fstream.Length];

            // считываем данные
            fstream.Read(array, 0, array.Length);

            // декодируем байты в строку
            string FileText = System.Text.Encoding.Default.GetString(array);
            Console.WriteLine($"Текст из файла:\n{FileText}");

            char[] separators = new char[] { ' ', '.', ',', '!', '?', '-', '(', ')' , '\n', '\t', '\"', ';', ':', '\r'};

            string[] subs = FileText.Split(separators, StringSplitOptions.RemoveEmptyEntries);

            int[] frequency = new int[15];

            for (int i = 0; i < subs.Length; i++)
            {
                frequency[subs[i].Length]++;
            }

            for (int i = 1; i < frequency.Length; i++)
            {
                Console.WriteLine($"{frequency[i]}\t {i}-буквенных");
            }
        }
    }
}
