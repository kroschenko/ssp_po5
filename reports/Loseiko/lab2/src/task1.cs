using System;
using System.IO;

namespace lab2_SPP
{
    class Program
    {

        static int rand(int min, int max)
        {
            Random rand = new Random();
            int res = rand.Next(min, max);
            return res;
        }
        static void Main(string[] args)
        {
            string path1 = "noun.txt";
            string path2 = "adjective.txt";
            string path3 = "preposition.txt";
            string path4 = "verb.txt";
            char[] separators = new char[] { ' ', '.', ',', '!', '?', '-', '(', ')', '\n', '\t', '\"', ';', ':', '\r' };

            FileStream fstream = File.OpenRead(path1);//считываем из 1-го файла
            byte[] array = new byte[fstream.Length];
            fstream.Read(array, 0, array.Length);
            string FileText = System.Text.Encoding.Default.GetString(array);
            string[] noun = FileText.Split(separators, StringSplitOptions.RemoveEmptyEntries);

            fstream = File.OpenRead(path2);//считываем из 2-го файла
            array = new byte[fstream.Length];
            fstream.Read(array, 0, array.Length);
            FileText = System.Text.Encoding.Default.GetString(array);
            string[] adjective = FileText.Split(separators, StringSplitOptions.RemoveEmptyEntries);

            fstream = File.OpenRead(path3);//считываем из 3-го файла
            array = new byte[fstream.Length];
            fstream.Read(array, 0, array.Length);
            FileText = System.Text.Encoding.Default.GetString(array);
            string[] preposition = FileText.Split(separators, StringSplitOptions.RemoveEmptyEntries);

            fstream = File.OpenRead(path4);//считываем из 4-го файла
            array = new byte[fstream.Length];
            fstream.Read(array, 0, array.Length);
            FileText = System.Text.Encoding.Default.GetString(array);
            string[] verb = FileText.Split(separators, StringSplitOptions.RemoveEmptyEntries);


            int random;
            string result="";

            for (int i = 0; i < 20; i++)
            {
                random = rand(0, noun.Length);
                result += noun[random] + " ";
                random = rand(0, verb.Length);
                result += verb[random] + " ";
                random = rand(0, preposition.Length);
                result += preposition[random] + " ";
                random = rand(0, adjective.Length);
                result += adjective[random] + " ";
                random = rand(0, noun.Length);
                result += noun[random] + ".";
                result = result.Substring(0, 1).ToUpper() + result.Substring(1);
                Console.WriteLine(result);
                result = "";
            }

        }
    }
}
