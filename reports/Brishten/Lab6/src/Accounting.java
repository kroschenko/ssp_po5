// STRATEGY 

/*
    В зависимости от ситуации мы можем легко заменить один используемый алгоритм другим.
    Обеспечивается выбор из нескольких вариантов алгоритмов, 
    которые можно легко менять в зависимости от условий.
*/

public class Accounting {
    public static void main(String[] args) {
        Buyer Volodya = new Buyer("Volodya", "High", new HighLevel());
        Volodya.info();
        Volodya.Opportunities();
        System.out.println("Dropped a book");
        Volodya.setLevel(new AverageLevel());
        Volodya.Opportunities();
        System.out.println("Tore up a book");
        Volodya.setLevel(new LowLevel());
        Volodya.Opportunities();
    }
}

interface ILevel
{
    void Opportunities();
}
 
class LowLevel implements ILevel
{
    public void Opportunities()
    {
        System.out.println("Reader can buy a book");
    }
}
 
class AverageLevel implements ILevel
{
    public void Opportunities()
    {
        System.out.println("Reader can buy a book at 30% discount");
    }
}

class HighLevel implements ILevel
{
    public void Opportunities()
    {
        System.out.println("Reader can get the secong book as a gift after buying the first one");
    }
}

class Buyer
{
    private ILevel Level;
    protected String name;
    protected String activity;
 
    public Buyer()
    {
        this.name = "None";
        this.activity = "None";
        this.Level = null;
    }

    public Buyer(String name, String activity, ILevel level)
    {
        this.name = name;
        this.activity = activity;
        Level = level;
    }

    public void info() 
    { 
        System.out.println("The buyer is " + this.name); 
    }

    public void setLevel(ILevel Level) { this.Level = Level; }

    public void Opportunities()
    {
        Level.Opportunities();
    }
}
