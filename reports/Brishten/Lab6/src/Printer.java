import java.util.Scanner;

//  COMMAND

/* 
    Необходимо обеспечить выполнение очереди запросов, а также их возможную отмену.
*/

public class Printer {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter number of sheets: ");
        int NS = in.nextInt();
        in.nextLine();

        System.out.print("Enter paint percentage: ");
        int PP = in.nextInt();
        in.nextLine();

        Pult pult = new Pult();
        
        Print print = new Print("Bosh", NS, PP);
        pult.SetCommand(new PrinterOnCommand(print));

        if (NS == 0 || PP == 0) { pult.PressOff(); in.close(); return; }

        print.infoPrinter();

        pult.PressOn();

        pult.SetAction(new RefillCommand(print));
        pult.Execute();
        print.waiting();

        pult.SetAction(new LoadOnCommand(print));
        pult.Execute();
        print.clampPaper();

        pult.SetAction(new PrintOnCommand(print));
        pult.Execute();
        print.printDocument();

        pult.SetAction(new ExtractionOnCommand(print));
        pult.Execute();
        print.waiting();

        pult.SetCommand(new PrinterOnCommand(print));
        pult.PressOff();

        in.close();
        return;
    }
}

interface Regimes
{
    void waiting();
    void printDocument();
    void clampPaper();
}

interface StartOperation
{
    void Start();
}

interface Command
{
    void Execute();
    void Undo();
}
 
// Receiver - Получатель
class Print implements Regimes
{
    private String model;
    private int numSheet, paintPercentage, pinchingProbability;
    private int max = 100, min = 0; 

    Print(String model, int numSheet, int paintPercentage) 
    {
        this.model = model;
        this.numSheet = numSheet;
        this.paintPercentage = paintPercentage;
        this.pinchingProbability = (int)(Math.random()*((max-min)+1))+min;
    }

    public void On() { System.out.println("Printer On!"); }
    public void Off() { System.out.println("Printer Off!"); }
    public void Printing() { System.out.println("Printing..."); }
    public void loadPaper() { System.out.println("Paper loading..."); }
    public void extractionPaper() { System.out.println("Paper extraction...") ;}
    public void refillCartridge() { System.out.println("Cartridge refill...") ;}

    public void infoPrinter()
    {
        System.out.println("\nModel \'" + model + "\', number of sheets = " + numSheet +
        ", percentage of paint = " + paintPercentage + "% and pinching probability = " + 
        pinchingProbability + "%");
    }

    public void waiting() 
    { 
        try {
            System.out.println("Waiting...");
            Thread.sleep(10000);
            System.out.println("Ready!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } 
    }

    public void printDocument() 
    { 
        try {
            System.out.println("Printing...");
            Thread.sleep(15000);
            System.out.println("Ready!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } 
    }

    public void clampPaper() 
    { 
        try {
            System.out.println("Clamping...");
            Thread.sleep(5000);
            System.out.println("Ready!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } 
    }
}
 
// ========================================================

class PrinterOnCommand implements Command
{
    Print print;
    public PrinterOnCommand(Print printSet) { print = printSet; }

    public void Execute() { print.On(); }
    public void Undo() { print.Off(); }
}

class PrintOnCommand implements StartOperation
{
    Print print;
    public PrintOnCommand(Print printSet) { print = printSet; }

    public void Start() { print.Printing(); }
}

class LoadOnCommand implements StartOperation
{
    Print print;
    public LoadOnCommand(Print printSet) { print = printSet; }

    public void Start() { print.loadPaper(); }
}

class ExtractionOnCommand implements StartOperation
{
    Print print;
    public ExtractionOnCommand(Print printSet) { print = printSet; }

    public void Start() { print.extractionPaper(); }
}
 
class RefillCommand implements StartOperation
{
    Print print;
    public RefillCommand(Print printSet) { print = printSet; }

    public void Start() { print.refillCartridge(); }
}

// ==============================================================

class Pult
{
    Command command;
    StartOperation start;

    public Pult() { }
    public void SetCommand(Command com) { command = com; }
    public void SetAction(StartOperation operation) { start = operation; }

    public void PressOn() { command.Execute(); }
    public void PressOff() { command.Undo(); }

    public void Execute() { start.Start(); }
}
