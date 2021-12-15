using System;

namespace lab6._2._5
{
    public class MercuryThermometerToElectronicThermometer : Thermometer
    {
        MercuryThermometer mercuryThermometer;

        public MercuryThermometerToElectronicThermometer(MercuryThermometer thermometer)
        {
            mercuryThermometer = thermometer;
        }

        public void MeasureTheTemperature()
        {
            Random rand = new Random();
            mercuryThermometer.SetTemperature(rand.Next(35, 40));
            Console.WriteLine($"Температура тела: {mercuryThermometer.GetTemperature()}");
        }
    }
}
