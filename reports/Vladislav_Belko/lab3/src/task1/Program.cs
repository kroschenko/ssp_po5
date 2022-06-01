using System;
using System.ComponentModel.Design;
using System.Threading;
namespace spp_lab3
{
    class Program
    {
        static void Main(string[] args)
        {
            try
            {
                Equilateral obj1 = new Equilateral();
                Equilateral obj2 = new Equilateral(4, 4, 4);
                if (obj1.Equals(obj2))
                {
                    Console.WriteLine("Equils");
                }
                else Console.WriteLine("Not equils");
                Console.WriteLine(obj1.ToString());
            }
            catch (Exception Ex)
            {
                Console.WriteLine(Ex.Message);
            }
        }
    }
    class Equilateral
    {
        private double Side { get; set; }
        private bool Checking(double _side1, double _side2, double _side3)
        {
            if (_side1 == _side2 && _side2 == _side3)
            {
                return true;
            }
            else return false;
        }
        public Equilateral()
        {
            Side = 1;
        }
        public Equilateral(double _side1, double _side2, double _side3)
        {
            if (Checking(_side1, _side2, _side3))
            {
                Side = _side1;
            }
            else throw new Exception("Wrong values!");
        }
        public double Area()
        {
            return Math.Pow(Side, 2) * Math.Sqrt(3) / 4;
        }
        public double Perimeter()
        {
            return Side * 3;
        }
        public override bool Equals(object obj)
        {
            Equilateral other = obj as Equilateral;
            return Side == other.Side;
        }
        public override string ToString()
        {
            return new string("Side is " + Side);
        }
    }
}