using System;

namespace lab5._2._9
{
    public abstract class Vehicle
    {
        private int Speed = 0, PassengerTransportationCost = 0, CargoTransportationCost = 0;
        public Vehicle(int speed, int passengerTransportationCost, int сargoTransportationCost)
        {
            Speed = speed;
            PassengerTransportationCost = passengerTransportationCost;
            CargoTransportationCost = сargoTransportationCost;
        }

        public int GetSpeed()
        {
            return Speed;
        }
        public void SetSpeed(int speed)
        {
            Speed = speed;
        }
        public int GetPassengerTransportationCost()
        {
            return PassengerTransportationCost;
        }
        public void SetPassengerTransportationCost(int passengerTransportationCost)
        {
            PassengerTransportationCost = passengerTransportationCost;
        }
        public int GetCargoTransportationCost()
        {
            return CargoTransportationCost;
        }
        public void SetCargoTransportationCost(int cargoTransportationCost)
        {
            CargoTransportationCost = cargoTransportationCost;
        }
        public void printSpeed()
        {
            Console.WriteLine("\tСкорость = " + Speed + "км/ч");
        }
        public void printPassengerTransportationCost()
        {
            Console.WriteLine("\tСтоимость перевозки пассажира = " + PassengerTransportationCost + "$/km");
        }
        public void printCargoTransportationCost()
        {
            Console.WriteLine("\tСтоимость перевозки груза = " + CargoTransportationCost + "$/km");
        }
        public abstract void printTypeOfTransport();
        public abstract void calculateMovement(int distance);
    }
}