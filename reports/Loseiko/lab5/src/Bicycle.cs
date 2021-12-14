using System;

namespace lab5._2._9
{
    class Bicycle : Vehicle
    {
        public Bicycle(int speed, int passengerTransportationCost, int сargoTransportationCost) : base(speed, passengerTransportationCost, сargoTransportationCost)
        {

        }
        public override void printTypeOfTransport()
        {
            Console.WriteLine("Велосипед: ");
        }
        public override void calculateMovement(int distance)
        {
            int hour = distance / GetSpeed();
            Console.WriteLine("Поездка на велосипеде займет " + hour + " час(ов) и будет стоить " + GetPassengerTransportationCost() * hour + " рублей для пассажиров, и " + GetCargoTransportationCost() * hour + " рублей для товара ");
        }
    }
}
