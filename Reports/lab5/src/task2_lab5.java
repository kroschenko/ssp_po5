public class task2_lab5 {

    public static void main(String[] args) {
        Instrument instrument[] = new Instrument[3];
        instrument[0] = new Wind(5,120,10);
        instrument[1] = new Percussion(2, 800, 100);
        instrument[2] = new Stringed (6, 160, 7);
        System.out.println("Orchestra is: ");
        instrument[0].play(3, 0.7);
        instrument[1].play(5, 0.5);
        instrument[2].play(10, 0.8);
    }
}

class Percussion extends Instrument {
    int size;

    public Percussion (int size, double weight, double typeNumber){
        this.size = size;
        this.weight = weight;
        this.typeNumber = typeNumber;
    }

    @Override void play(double time, double speed){
        System.out.println("Percussion is playing " + time + "h with " + speed + " speed");
    }

    void setSize(){
        this.size = 5;
    }
}

class Stringed extends Instrument {
    int stringsNumber;

    public Stringed (int stringsNumber, double weight, double typeNumber){
        this.stringsNumber = stringsNumber;
        this.weight = weight;
        this.typeNumber = typeNumber;
    }

    @Override void play(double time, double speed){
        System.out.println("Stringed is playing " + time + "h with " + speed + " speed");
    }

    void checkNumber(int stringsNumber){
        this.stringsNumber += stringsNumber;
    }
}

abstract class Instrument {
    double weight;
    double typeNumber;

    abstract void play(double time, double speed);
}

class Wind extends Instrument {
    int value;

    public Wind (int value, double weight, double typeNumber){
        this.value = value;
        this.weight = weight;
        this.typeNumber = typeNumber;
    }

    @Override void play(double time, double speed){
        System.out.println("Wind is playing " + time + "h with " + speed + " speed");
    }

    void getValue(int value){
        this.value -= value;
    }
} 