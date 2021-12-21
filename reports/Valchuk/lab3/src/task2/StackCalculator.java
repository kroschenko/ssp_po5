import java.util.Stack;

public class StackCalculator {
    private final Stack<Character> operatorStack = new Stack<>();
    private final Stack<Double> valueStack = new Stack<>();

    private boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    private int getPrecedence(char operator) {
        return switch (operator) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            default -> throw new IllegalStateException("Unexpected value: " + operator);
        };
    }

    private void processOperator(char operator) throws InvalidExpressionException {
        if (valueStack.size() < 2) {
            throw new InvalidExpressionException();
        }

        double b = valueStack.pop();
        double a = valueStack.pop();

        double result = switch (operator) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> a / b;
            default -> throw new IllegalStateException("Unexpected value: " + operator);
        };

        valueStack.push(result);
    }

    public double processExpression(String expression) throws InvalidExpressionException {
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
                int valueFirstPosition = i;

                while (i + 1 < expression.length() && (expression.charAt(i + 1) >= '0' && expression.charAt(i + 1) <= '9' || expression.charAt(i + 1) == '.')) {
                    i++;
                }

                double value = Double.parseDouble(expression.substring(valueFirstPosition, i + 1));
                valueStack.push(value);
            }
            else if (isOperator(expression.charAt(i))) {
                while (!operatorStack.empty() && isOperator(operatorStack.peek()) && getPrecedence(expression.charAt(i)) <= getPrecedence(operatorStack.peek())) {
                    processOperator(operatorStack.pop());
                }
                operatorStack.push(expression.charAt(i));
            }
            else if (expression.charAt(i) == '(') {
                operatorStack.push(expression.charAt(i));
            }
            else if (expression.charAt(i) == ')') {
                while (!operatorStack.empty() && isOperator(operatorStack.peek())) {
                    processOperator(operatorStack.pop());
                }
                if (!operatorStack.empty() && operatorStack.peek() == '(') {
                    operatorStack.pop();
                }
                else {
                    throw new InvalidExpressionException("Error: unbalanced parenthesis");
                }
            }
            else if (expression.charAt(i) != ' ') {
                throw new InvalidExpressionException();
            }

        }

        while (!operatorStack.empty() && isOperator(operatorStack.peek())) {
            processOperator(operatorStack.pop());
        }

        double result = valueStack.peek();
        valueStack.pop();

        if (!operatorStack.empty() || !valueStack.empty()) {
            throw new InvalidExpressionException();
        }

        return result;
    }
}