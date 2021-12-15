using System;

namespace lab6._2._5
{
    public class MercuryThermometer : AnalogThermometer
    {
        private int HeightOfTheMercuryColumn = 0;
        private int UpperBound = 100, BottomLine = 0;

        public int GetTemperature()
        {
            return HeightOfTheMercuryColumn;
        }

        public void SetTemperature(int heightOfTheMercuryColumn)
        {
            HeightOfTheMercuryColumn = heightOfTheMercuryColumn;
        }

        public int GetUpperBound()
        {
            return UpperBound;
        }

        public void SetUpperBound(int upperBound)
        {
            UpperBound = upperBound;
        }

        public int GetBottomLine()
        {
            return HeightOfTheMercuryColumn;
        }

        public void SetBottomLine(int bottomLine)
        {
            BottomLine = bottomLine;
        }
        public void RoughlyMeasureTheTemperature()
        {
            Console.WriteLine($"Высота ртутного столба: {HeightOfTheMercuryColumn}. Нижняя граница градусника: {BottomLine}, верхняя граница градусника {UpperBound}");
        }
    }
}