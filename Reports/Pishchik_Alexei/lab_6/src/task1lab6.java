import java.util.ArrayList;
import java.util.List;

public class task1lab6 {
    public static void main(String[] args) {
        CoffeeMachine macchiatoFactory = new MacchiattoFactory();
        CoffeeMachine latteFactory = new LatteFactory();
        CoffeeMachine cappuccinoFactory = new CappuccinoFactory();
        CoffeeMachine espressoFactory = new EspressoFactory();
        CoffeeMachine americanoFactory = new AmericanoFactory();

        Coffee macchiato = macchiatoFactory.makeCoffee();
        Coffee latte = latteFactory.makeCoffee();
        Coffee cappuccino = cappuccinoFactory.makeCoffee();
        Coffee espresso = espressoFactory.makeCoffee();
        Coffee americano = americanoFactory.makeCoffee();

        System.out.println(macchiato);
        System.out.println(latte);
        System.out.println(cappuccino);
        System.out.println(espresso);
        System.out.println(americano);
    }
}

interface CoffeeMachine {
    Coffee makeCoffee();
}
class MacchiattoFactory implements CoffeeMachine {
    @Override
    public Coffee makeCoffee() {
        return new Machiatto();
    }
}
class LatteFactory implements CoffeeMachine {
    @Override
    public Coffee makeCoffee() {
        return new Latte();
    }
}
class CappuccinoFactory implements CoffeeMachine {
    @Override
    public Coffee makeCoffee() {
        return new Cappuccino();
    }
}

class EspressoFactory implements CoffeeMachine {
    @Override
    public Coffee makeCoffee() {
        return new Espresso();
    }
}

class AmericanoFactory implements CoffeeMachine {
    @Override
    public Coffee makeCoffee() {
        return new Americano();
    }
}

abstract class Coffee {
    String name;
    public List<String> ingredients = new ArrayList<>();

    public String toString() {
        return name + " - Ingredients: " + ingredients;
    }
}
class Machiatto extends Coffee {
    Machiatto() {
        name = "Machiatto";
        ingredients.add("espresso");
        ingredients.add("whipped milk");
    }
}

class Latte extends Coffee {
    Latte() {
        name = "Latte";
        ingredients.add("espresso");
        ingredients.add("milk");
        ingredients.add("whipped milk");
    }
}

class Cappuccino extends Coffee {
    Cappuccino() {
        name = "Cappuccino";
        ingredients.add("espresso");
        ingredients.add("milk");
        ingredients.add("whipped milk");
    }
}

class Espresso extends Coffee {
    Espresso() {
        name = "Espresso";
        ingredients.add("espresso");
    }
}

class Americano extends Coffee {
    Americano() {
        name = "Americano";
        ingredients.add("espresso");
        ingredients.add("water");
    }
}

