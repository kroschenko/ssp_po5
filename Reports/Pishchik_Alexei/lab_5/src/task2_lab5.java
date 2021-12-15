import java.util.ArrayList;
import java.util.List;

public class task2lab5 {
    public static void main(String[] args) {
        List<Instrument> instrument= new ArrayList<>();
        instrument.add(new Wind(5,120,10));
        instrument.add(new Percussion(2, 800, 100));
        instrument.add(new Stringed (6, 160, 7));
        System.out.println("Orchestra is: ");
        instrument.get(0).play(3, 0.7);
        instrument.get(1).play(5, 0.5);
        instrument.get(2).play(10, 0.8);
        for (Instrument inst: instrument) {
            System.out.println(inst.toString());
        }
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

    @Override
    public String toString() {
        return "Percussion{" +
                "size=" + size +
                ", weight=" + weight +
                ", typeNumber=" + typeNumber +
                '}';
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

    @Override
    public String toString() {
        return "Stringed{" +
                "stringsNumber=" + stringsNumber +
                ", weight=" + weight +
                ", typeNumber=" + typeNumber +
                '}';
    }
}

abstract class Instrument {
    double weight;
    double typeNumber;

    abstract void play(double time, double speed);

    @Override
    public String toString() {
        return "Instrument{" +
                "weight=" + weight +
                ", typeNumber=" + typeNumber +
                '}';
    }
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

    @Override
    public String toString() {
        return "Wind{" +
                "weight=" + weight +
                ", typeNumber=" + typeNumber +
                ", value=" + value +
                '}';
    }
}
