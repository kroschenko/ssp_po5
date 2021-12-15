package task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        ExecContext context = new ExecContext();
        Commands commands = new Commands();

        File file;
        Scanner scanner;

        if(args.length==0)
            scanner = new Scanner(System.in);
        else if(args.length==1) {
            try {
                file = new File(args[0]);
                scanner = new Scanner(file, "utf-8");
            }
            catch(FileNotFoundException e){
                System.out.println("Error: file not found");
                return;
            }
        }
        else{
            System.out.println("Error: unexpected params");
            return;
        }

        while(scanner.hasNextLine())
        {
            String command = scanner.nextLine();

            if(command.indexOf("#")==0)
                continue;
            else if(command.indexOf("POP")==0)
            {
                try
                {
                    context = commands.PopCommand(context, command);
                }
                catch(Exception e)
                {
                    System.out.println("Error");
                }
            }
            else if(command.indexOf("PUSH")==0)
            {
                try
                {
                    context = commands.PushCommand(context, command);
                }
                catch(Exception e)
                {
                    System.out.println("Error");
                }
            }
            else if(command.indexOf("+")==0)
            {
                try
                {
                    context = commands.PlusCommand(context, command);
                }
                catch(Exception e)
                {
                    System.out.println("Error");
                }
            }
            else if(command.indexOf("-")==0)
            {
                try
                {
                    context = commands.MinusCommand(context, command);
                }
                catch(Exception e)
                {
                    System.out.println("Error");
                }
            }
            else if(command.indexOf("*")==0)
            {
                try
                {
                    context = commands.MultiplyCommand(context, command);
                }
                catch(Exception e)
                {
                    System.out.println("Error");
                }
            }
            else if(command.indexOf("/")==0)
            {
                try
                {
                    context = commands.DivideCommand(context, command);
                }
                catch(Exception e)
                {
                    System.out.println("Error");
                }
            }
            else if(command.indexOf("SQRT")==0)
            {
                try
                {
                    context = commands.SqrtCommand(context, command);
                }
                catch(Exception e)
                {
                    System.out.println("Error");
                }
            }
            else if(command.indexOf("PRINT")==0)
            {
                try
                {
                    commands.PrintCommand(context, command);
                }
                catch(Exception e)
                {
                    System.out.println("Error");
                }
            }
            else if(command.indexOf("DEFINE")==0)
            {
                try
                {
                    commands.DefineCommand(context, command);
                }
                catch(Exception e)
                {
                    System.out.println("Error");
                }
            }
            else if(command.indexOf("EXIT")==0)
                break;
            else
            {
                System.out.println("Error: unknown command");
            }
        }
    }
}