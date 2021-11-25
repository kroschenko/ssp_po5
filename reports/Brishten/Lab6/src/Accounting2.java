/*
    DECORATOR
    Когда надо динамически добавлять к объекту новые функциональные возможности.
    В моём случае в зависимости от уровня есть разные возможности.
*/

import java.util.ArrayList;

public class Accounting2 {
    public static void main(String[] args)
    {
        ArrayList<Human> People = new ArrayList<Human>();

        Human Ivan = new Low();
        Human Petr = new Average();
        Human Vera = new High();

        People.add(Ivan);
        People.add(Petr);
        People.add(Vera);

        System.out.println("|Stock for New Year and Christmas|");

        for (Human buyer: People)
        {
            System.out.print("The " + buyer.getName() + " reader ");

            if(buyer.GetActivity() > 9)
            {
                buyer = new Discount(buyer);
                buyer = new Gift(buyer);
                System.out.println("get " + buyer.getName());
            }
            else if (buyer.GetActivity() < 5) { System.out.println("nothing get"); }
            else 
            { 
                buyer = new Discount(buyer); 
                System.out.println("get " + buyer.getName());
            }
        }
    }
}
 
abstract class Human
{
    public String name;
    public Human(String n)
    {
        this.name = n;
    }
    public String getName() { return this.name; }
    public abstract int GetActivity();
}

class High extends Human
{
    public High() 
    { 
        super("high-level");
    }

    @Override
    public int GetActivity()
    {
        return 10;
    }
}

class Average extends Human
{
    public Average()
    {
        super("average-level");
    }

    @Override
    public int GetActivity()
    {
        return 8;
    }
}

class Low extends Human
{
    public Low()
    {
        super("low-level");
    }

    @Override
    public int GetActivity()
    {
        return 4;
    }
}
 
abstract class HumanDecorator extends Human
{
    protected Human human;
    public HumanDecorator(String name, Human human)
    {
        super(name);    
        this.human = human;
    }
}
 
class Discount extends HumanDecorator
{
    public Discount(Human p)
    {
        super(p.getName() + "at 20% discount ", p);
    }
 
    @Override
    public int GetActivity()
    {
        return human.GetActivity() - 3;
    }
}
 
class Gift extends HumanDecorator
{
    public Gift(Human p)
    {
        super(p.getName() + " and a gift", p);
    }
 
    @Override
    public int GetActivity()
    {
        return human.GetActivity() - 5;
    }
}
