

public class Program {
    public static void main(String[] args) {
            Car electricCar = new Car(new ElectricCarFactory());
            electricCar.Drive();
            electricCar.Fuel();
 
            Car gasolineCar = new Car(new GasolineCarFactory());
            gasolineCar.Drive();
            gasolineCar.Fuel();
    }
}

    abstract class Fuel
    {
        public abstract void ToFill();
    }

    abstract class Movement
    {
        public abstract void Move();
    }


    class NuclearFuel extends Fuel
    {
        @Override
        public void ToFill()
        {
            System.out.println("Заправляем ядерным топливом!");
        }
    }

    class Gasoline extends Fuel
    {
        @Override
        public void ToFill()
        {
            System.out.println("Заправляем бензином!");
        }
    }

    class Electric extends Fuel
    {
        @Override
        public void ToFill()
        {
            System.out.println("Поставили на зарядку!");
        }
    }

    class FlyMovement extends Movement
    {
        @Override
        public void Move()
        {
            System.out.println("Летим");
        }
    }

    class DriveMovement extends Movement
    {
        @Override
        public void Move()
        {
            System.out.println("Едем");
        }
    }

    class NuclearFuelCarFactory extends CarFactory
    {
        @Override
        public Movement CreateVehicle()
        {
            return new DriveMovement();
        }
 
        @Override
        public Fuel FuelVehicle()
        {
            return new NuclearFuel();
        }
    }
    class GasolineCarFactory extends CarFactory
    {
        @Override
        public Movement CreateVehicle()
        {
            return new DriveMovement();
        }
 
        @Override
        public Fuel FuelVehicle()
        {
            return new Gasoline();
        }
    }
    class ElectricCarFactory extends CarFactory
    {
        @Override
        public Movement CreateVehicle()
        {
            return new FlyMovement();
        }
 
        @Override
        public Fuel FuelVehicle()
        {
            return new Electric();
        }
    }
    
    abstract class CarFactory
    {
        public abstract Movement CreateVehicle();
        public abstract Fuel FuelVehicle();
    }

    class Car
    {
        private Fuel fuel;
        private Movement car;
        public Car(CarFactory factory)
        {
            car = factory.CreateVehicle();
            fuel = factory.FuelVehicle();
        }
        public void Drive()
        {
            car.Move();
        }
        public void Fuel()
        {
            fuel.ToFill();
        }
    }