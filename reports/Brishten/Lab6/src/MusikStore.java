// ABSTRACT FACTORY

/* 
    Позволяет создавать семейства независимых продуктов.
    Общий интерфейс для отдельных продуктов.
*/

public class MusikStore {
    public static void main(String[] args) {
        Client Ivan = new Client(new BrestFactory());
        Ivan.Hit();
        Ivan.Run();
 
        Client Vasya = new Client(new MinskFactory());
        Vasya.Hit();
        Vasya.Run();
    }
}

abstract class Percussion
{
    public abstract void Hit();
}

abstract class Folk
{
    public abstract void Move();
}
 
class Dish extends Percussion
{
    @Override
    public void Hit()
    {
        System.out.println("Dish");
    }
}

class Drum extends Percussion
{
    @Override
    public void Hit()
    {
        System.out.println("Drum");
    }
}

class Garmon extends Folk
{
    @Override
    public void Move()
    {
        System.out.println("Garmon");
    }
}
// 
class Bayan extends Folk
{
    @Override
    public void Move()
    {
        System.out.println("Bayan");
    }
}

abstract class ClientFactory
{
    public abstract Folk CreateFolkTool(); 
    public abstract Percussion CreatePecussionTool();
}

class BrestFactory extends ClientFactory
{
    @Override
    public Folk CreateFolkTool()
    {
        return new Garmon();
    }
    @Override
    public Percussion CreatePecussionTool()
    {
        return new Drum();
    }
}

class MinskFactory extends ClientFactory
{
    @Override
    public Folk CreateFolkTool()
    {
        return new Bayan();
    }
    @Override
    public Percussion CreatePecussionTool()
    {
        return new Dish();
    }
}
// клиент
class Client
{
    static int num = 0;
    private Percussion perTool;
    private Folk filkTool;
    public Client(ClientFactory factory)
    {
        num += 1;
        System.out.println("\n=========== Client #" + num + " ============");
        perTool = factory.CreatePecussionTool();
        filkTool = factory.CreateFolkTool();
    }
    public void Run()
    {
        filkTool.Move();
    }
    public void Hit()
    {
        perTool.Hit();
    }
}