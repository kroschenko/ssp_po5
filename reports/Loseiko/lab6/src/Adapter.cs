using System;

namespace lab6._2._9
{
    public class Adapter : ElectronicClock, Clock
    {
        MechanicalClock mechanicalClock;

        public Adapter(MechanicalClock clock)
        {
            mechanicalClock = clock;
        }

        public new void MeasureTime()
        {
            double time = mechanicalClock.GetAngle() / 15f;
            double hour = Math.Round(time, MidpointRounding.ToZero);
            double minute = (time - hour) * 60;
            DateTime datetime = new DateTime(2021, 7, 20, Convert.ToInt32(hour), Convert.ToInt32(minute), 25);
            ElectronicClock electronicClock = new ElectronicClock();
            electronicClock.SetTime(datetime);
            Console.WriteLine($"Время: {datetime}");
        }
    }
}