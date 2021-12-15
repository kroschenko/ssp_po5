namespace lab6._2._5
{
    class Program
    {
        static void Main(string[] args)
        {
            Person person = new Person();

            ElectronicThermometer electronic_Thermometer = new ElectronicThermometer();

            person.MeasureYourTemperature(electronic_Thermometer);

            MercuryThermometer mercuryThermometer = new MercuryThermometer();

            Thermometer mercury_Thermometer = new MercuryThermometerToElectronicThermometer(mercuryThermometer);

            person.MeasureYourTemperature(mercury_Thermometer);
        }
    }
}