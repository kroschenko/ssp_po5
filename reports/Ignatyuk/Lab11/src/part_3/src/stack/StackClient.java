package stack;

import java.util.Scanner;

public final class StackClient {
    public final static void main(final String[] args) {
        Stack<String> stack = new Stack<String>();
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String item = scanner.next();

            if (!item.equals("-")) {
                stack.push(item);
            } else if (!stack.isEmpty()) {
                System.out.println(stack.pop());
            }
        }

        scanner.close();
        System.out.println("Stack size: " + Integer.toString(stack.size()));
        System.out.println("Stack content: " + stack.toString());
    }
}
