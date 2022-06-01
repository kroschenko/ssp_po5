using System;
namespace task2
{
    class Program
    {
        static void Main(string[] args)
        {
            MString str1 = new MString("First example. ");
            MString str2 = new MString("Second example. ");
            Paragraph par = new Paragraph();
            par.Add(str1);
            par.Show();
            par.Add(str2);
            par.Show();
        }
    }
    class Paragraph
    {
        public string Value { get; set; }
        public void Add(MString str)
        {
            Value += str.ToString();
        }
        public void Show()
        {
            Console.WriteLine(Value);
        }
        public override string ToString()
        {
            return Value;
        }
    }
    class MString
    {
        public string Value { get; set; }
        public MString(string _Value)
        {
            Value = _Value;
        }
        public override string ToString()
        {
            return Value;
        }
        public void Show()
        {
            Console.WriteLine(Value);
        }
    }
}