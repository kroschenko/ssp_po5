using System;

namespace lab6._2._5
{
    public class ElectronicThermometer : Thermometer
    {
        private int Temperature = 0;

        public int GetTemperature()
        {
            return Temperature;
        }

        public void SetTemperature(int temperature)
        {
            Temperature = temperature;
        }
        public void MeasureTheTemperature()
        {
            Random rand = new Random();
            SetTemperature(rand.Next(35, 40));
            Console.WriteLine($"Температура тела: {Temperature}");
        }
    }
}
