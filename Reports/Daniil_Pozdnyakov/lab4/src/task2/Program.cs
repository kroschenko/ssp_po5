using System;
using System.Collections.Generic;

namespace lab4._2._5
{
    class Program
    {
        static void Main(string[] args)
        {
            Paragraph par1;
            List<Word> words = new List<Word>();
            Random rand = new Random();
            string[] temp = { "da", "net", "ladno", "vozmojno", "pochemu"};
            for (int i = 0; i < 10; i++)
            {
                string str = temp[rand.Next(0, 5)];
                Word word = new Word(str, str.Length);
                words.Add(word);
                par1 = new Paragraph(words[i]);
                par1.Print();
            }
        }
    }
}
