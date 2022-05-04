package task2;

public class Commands {

    public ExecContext PopCommand(ExecContext context, String command) throws Exception
    {
        if(!command.equals("POP"))
            throw new Exception();

        if(context.stackIsEmpty())
            throw new Exception();

        context.popFromStack();

        return context;
    }

    public ExecContext PushCommand(ExecContext context, String command) throws Exception
    {
        String[] args = command.split(" ");

        if(args.length!=2)
            throw new Exception();

        if(!args[0].equals("PUSH"))
            throw new Exception();

        Double value = null;
        try{
            value = Double.parseDouble(args[1]);
        }
        catch(NumberFormatException e)
        {
            value = context.getParam(args[1]);
        }

        if(value==null)
            throw new Exception();

        context.pushInStack(value);

        return context;
    }

    public ExecContext PlusCommand(ExecContext context, String command) throws Exception
    {
        if(!command.equals("+"))
            throw new Exception();

        double value1, value2;

        if(context.stackIsEmpty())
            throw new Exception();

        value2 = context.popFromStack();

        if(context.stackIsEmpty()) {
            context.pushInStack(value2);
            throw new Exception();
        }

        value1 = context.popFromStack();

        context.pushInStack(value1+value2);

        return context;
    }

    public ExecContext MinusCommand(ExecContext context, String command) throws Exception
    {
        if(!command.equals("-"))
            throw new Exception();

        double value1, value2;

        if(context.stackIsEmpty())
            throw new Exception();

        value2 = context.popFromStack();

        if(context.stackIsEmpty()) {
            context.pushInStack(value2);
            throw new Exception();
        }

        value1 = context.popFromStack();

        context.pushInStack(value1-value2);

        return context;
    }

    public ExecContext MultiplyCommand(ExecContext context, String command) throws Exception
    {
        if(!command.equals("*"))
            throw new Exception();

        double value1, value2;

        if(context.stackIsEmpty())
            throw new Exception();

        value2 = context.popFromStack();

        if(context.stackIsEmpty()) {
            context.pushInStack(value2);
            throw new Exception();
        }

        value1 = context.popFromStack();

        context.pushInStack(value1*value2);

        return context;
    }

    public ExecContext DivideCommand(ExecContext context, String command) throws Exception
    {
        if(!command.equals("/"))
            throw new Exception();

        double value1, value2;

        if(context.stackIsEmpty())
            throw new Exception();

        value2 = context.popFromStack();

        if(value2==0) {
            context.pushInStack(value2);
            throw new Exception();
        }

        if(context.stackIsEmpty()) {
            context.pushInStack(value2);
            throw new Exception();
        }

        value1 = context.popFromStack();

        context.pushInStack(value1/value2);

        return context;
    }

    public ExecContext SqrtCommand(ExecContext context, String command) throws Exception
    {
        if(!command.equals("SQRT"))
            throw new Exception();

        double value;

        if(context.stackIsEmpty())
            throw new Exception();

        value = context.popFromStack();

        if(value<0) {
            context.pushInStack(value);
            throw new Exception();
        }

        context.pushInStack(Math.sqrt(value));

        return context;
    }

    public void PrintCommand(ExecContext context, String command) throws Exception
    {
        if(!command.equals("PRINT"))
            throw new Exception();

        if(context.stackIsEmpty())
            throw new Exception();

        System.out.println(context.peekFromStack());
    }

    public ExecContext DefineCommand(ExecContext context, String command) throws Exception
    {
        String[] args = command.split(" ");

        if(args.length!=3)
            throw new Exception();

        if(!args[0].equals("DEFINE"))
            throw new Exception();

        Double value = null;
        try{
            value = Double.parseDouble(args[2]);
        }
        catch(NumberFormatException e)
        {
            throw new Exception();
        }

        context.setParam(args[1], value);

        return context;

    }
}
