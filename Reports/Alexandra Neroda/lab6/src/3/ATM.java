import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите сумму денег в банкомате: ");
        int sum = in.nextInt();
        in.nextLine();

        Bankomat bankomat = new Bankomat(new Waiting(), sum);
        bankomat.Info();
        bankomat.EnterPin();
        bankomat.WithdrawalAmount();
        bankomat.CloseDown();
        in.close();
    }
}

class Bankomat
{
    public IATMState State;
    public boolean ID;
    public int sumMoney;
    
    public IATMState getState() { return State; }
    public void setState(IATMState state) { State = state; }

    public Bankomat(IATMState state, int summoney)
    {
        State = state;
        sumMoney = summoney;
    }

    public void EnterPin()
    {
        State.EnterPIN(this);
    }

    public void WithdrawalAmount()
    {
        State.WithdrawalAmount(this);
    }

    public void CloseDown()
    {
        State.CloseDown(this);
    }

    public void Info()
    {
        System.out.println("ID=" + ID + " и SUM=" + sumMoney);
    }
}
 
interface IATMState
{
    void EnterPIN(Bankomat bankomat);
    void WithdrawalAmount(Bankomat bankomat);
    void CloseDown(Bankomat bankomat);
}
 
class Waiting implements IATMState
{
    @Override
    public void EnterPIN(Bankomat bankomat) 
    {
        if (bankomat.sumMoney == 0) 
        {
            System.out.println("Блокировка...");
            bankomat.State = new Lock();
        }
        else 
        {
            System.out.println("Аутентификация...");
            bankomat.State = new Authentication();
            bankomat.ID = true;
        }
    }

    @Override
    public void WithdrawalAmount(Bankomat bankomat)
    {
        System.out.println("Для выполенения операции выполните вход");
    }

    @Override
    public void CloseDown(Bankomat bankomat)
    {
        System.out.println("Завершение работы...");
        bankomat.ID = false;
    }
}
class Authentication implements IATMState
{
    @Override
    public void EnterPIN(Bankomat bankomat) 
    {
        System.out.println("Вход уже выполнен");
    }

    @Override
    public void WithdrawalAmount(Bankomat bankomat)
    {
        if (bankomat.sumMoney == 0) 
        {
            System.out.println("Блокировка...");
            bankomat.State = new Lock();
        }
        else
        {
            System.out.println("Сумма снята...");
            bankomat.State = new ExecuteOperation();
        }
    }

    @Override
    public void CloseDown(Bankomat bankomat)
    {
        System.out.println("Завершение работы...");
        bankomat.State = new Waiting();
        bankomat.ID = false;
    }
}

class ExecuteOperation implements IATMState
{
    @Override
    public void EnterPIN(Bankomat bankomat) 
    {
        System.out.println("Аутентификация...");
        bankomat.State = new Authentication();
    }

    @Override
    public void WithdrawalAmount(Bankomat bankomat)
    {
        System.out.println("Введите пин для продолжения");
    }

    @Override
    public void CloseDown(Bankomat bankomat)
    {
        System.out.println("Завершение работы...");
        bankomat.State = new Waiting();
        bankomat.ID = false;
    }
}

class Lock implements IATMState 
{
    @Override
    public void EnterPIN(Bankomat bankomat) 
    {
        System.out.println("Банкомат заблокирован! Нет денег");
    }

    @Override
    public void WithdrawalAmount(Bankomat bankomat)
    {
        System.out.println("Банкомат заблокирован! Нет денег");
    }

    @Override
    public void CloseDown(Bankomat bankomat)
    {
        System.out.println("Завершение работы...");
        System.exit(0); // or return
    }
}