using System;

namespace lab6._2._9
{
    public class MechanicalClock : AnalogClock
    {
        private int Angle = 123;

        public MechanicalClock()
        {
            Random rand = new Random();
            Angle = rand.Next(0, 361);
        }
        public int GetAngle()
        {
            return Angle;
        }

        public void SetTemperature(int angle)
        {
            Angle = angle;
        }

        public void MeasureTime()
        {
            Console.WriteLine($"Угол поворота стрелки {Angle}");
        }
    }
}