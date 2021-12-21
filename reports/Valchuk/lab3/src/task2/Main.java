import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InvalidExpressionException {
	    String mathExpression = Utilities.getMathExpression(args.length == 0 ? null : args[0]);
        StackCalculator stackCalculator = new StackCalculator();
        System.out.print(stackCalculator.processExpression(mathExpression));
    }
}

