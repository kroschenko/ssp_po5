package lab;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
    ArrayList<Pet> pets = new ArrayList<>();
    pets.add(new Cat("Max", "Munchkin", 3));
    pets.add(new Dog("Isaak", "Husky", 7));
    pets.add(new Parrot("Mike", "Amazon", 4));

	for (Pet i: pets)
	    i.show();

    }
}

abstract class Pet {
    private String name;
    private String breed;
    private int age;
    public Pet (String _name, String _breed, int _age) {
        name = _name;
        breed = _breed;
        age = _age;
    }
    public String getName() {
        return name;
    }
    public String getBreed() {
        return breed;
    }
    public int getAge() {
        return age;
    }

    public abstract void show();
}

class Dog extends Pet {
    private String voice = "Aww-Aww";
    public Dog (String _name, String _breed, int _age) {
        super(_name, _breed, _age);
    }
    public void show () {
        System.out.println(voice + "\nHi, my name is " + super.getName() + ". My breed is " + super.getBreed() +
                " and I'm " + super.getAge() + " years old.\n");
    }
}

class Cat extends Pet {
    private String voice = "Meowww";
    public Cat  (String _name, String _breed, int _age) {
        super(_name, _breed, _age);
    }
    public void show () {
        System.out.println(voice + "\nHi, my name is " + super.getName() + ". My breed is " + super.getBreed() +
                " and I'm " + super.getAge() + " years old.\n");
    }
}

class Parrot extends Pet {
    private String voice = "Have a nice day";
    public Parrot  (String _name, String _breed, int _age) {
        super(_name, _breed, _age);
    }
    public void show () {
        System.out.println(voice + "\nMy name is " + super.getName() + " and I'm a talking parrot. My breed is " + super.getBreed() +
                " and I'm " + super.getAge() + " years old.\n");
    }
}