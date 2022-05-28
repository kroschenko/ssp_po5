namespace lab6._2._9
{
    class Program
    {
        static void Main(string[] args)
        {
            Person person = new Person();

            ElectronicClock electronic_Thermometer = new ElectronicClock();

            person.MeasureYourTemperature(electronic_Thermometer);

            MechanicalClock mercuryThermometer = new MechanicalClock();

            Clock mercury_Thermometer = new Adapter(mercuryThermometer);

            person.MeasureYourTemperature(mercury_Thermometer);
        }
    }
}