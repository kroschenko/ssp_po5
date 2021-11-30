using System;
using System.Collections.Generic;

namespace lab4._2._9
{
    class Wheel
    {
        public int radius;
        public int width;

        public Wheel(int r, int w)
        {
            radius = r;
            width = w;
        }
    }

    class Car
    {
        string model = "Porsche Panamera";
        Wheel wheel;
        public Car(Wheel someWheel)
        {
            wheel = someWheel;
        }

        public void Print()
        {
            Console.WriteLine($"Модель: {model}. Колёса: радиус - {wheel.radius}, ширина - {wheel.width}");
        }

        public void ChangeWheel(int r, int w)
        {
            wheel.radius = r;
            wheel.width = w;
        }
    }
}
