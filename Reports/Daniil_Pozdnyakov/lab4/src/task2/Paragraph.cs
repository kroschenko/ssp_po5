using System;
using System.Collections.Generic;
using System.Text;

namespace lab4._2._5
{
    class Word
    {
        public string name;
        public int length;

        public Word(string n, int l)
        {
            name = n;
            length = l;
        }
    }

    class Paragraph
    {
        int NumOfParagraph;
        Word word;
        public Paragraph(Word someWord)
        {
            NumOfParagraph = 1;
            word = someWord;
        }

        public void Print()
        {
            Console.WriteLine($"Номер параграфа: {NumOfParagraph}. Слово: название - {word.name}, длина - {word.length}");
        }

        public void ChangeWord(string n, int l)
        {
            word.name = n;
            word.length = l;
        }

        public void ChangeParagraph(int num)
        {
            NumOfParagraph = num;
        }
    }
}
