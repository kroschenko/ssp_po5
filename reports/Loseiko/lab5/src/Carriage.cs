using System;

namespace lab5._2._9
{
    class Carriage : Vehicle
    {
        public Carriage(int speed, int passengerTransportationCost, int сargoTransportationCost) : base(speed, passengerTransportationCost, сargoTransportationCost)
        {

        }
        public override void printTypeOfTransport()
        {
            Console.WriteLine("Повозка: ");
        }
        public override void calculateMovement(int distance)
        {
            int hour = distance / GetSpeed();
            Console.WriteLine("Поездка на повозке займет " + hour + " час(ов) и будет стоить " + GetPassengerTransportationCost() * hour + " рублей для пассажиров, и " + GetCargoTransportationCost() * hour + " рублей для товара ");
        }
    }
}
