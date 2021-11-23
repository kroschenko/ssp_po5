package SSP.Lab4.ThirdTask;

public class CityVehicle{
    boolean isAlive;
    boolean isArrive = false;
    double speed;
    int number;
    String name;
    boolean  start(){

        if(isAlive) {
            System.out.println(this.name +" №"+this.number + " начал движение");
        }
        else{
            System.out.println(this.name +" №"+this.number + " поломан");
        }
        return isAlive;
    }

    public CityVehicle(int number, int speed) {
        isAlive = true;
        this.number = number;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return name + " №" + number;
    }
}
