using System;

namespace lab6._2._9
{
    public class ElectronicClock : Clock
    {
        private DateTime Time = new DateTime(2021, 7, 20, 18, 30, 25);

        public DateTime GetTime()
        {
            return Time;
        }

        public void SetTime(DateTime time)
        {
            Time = time;
        }
        public void MeasureTime()
        {
            SetTime(Time);
            Console.WriteLine($"Время: {Time}");
        }
    }
}
