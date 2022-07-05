package queue;

import java.util.Scanner;

public class QueueClient {

    /**
     * A test client.
     */
    public static void main(String[] args) {
        Queue<String> q = new Queue<String>();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Start...");
        System.out.println("Enter your values. If you entered '-', the element will be showed");

        while (scanner.hasNext()) {
            String item = scanner.next();

            if (!item.equals("-")) {
                q.enqueue(item);
                System.out.println("Elements has: "+q.size());
            }
            else if (!q.isEmpty()) {
                System.out.println(q.dequeue() + " ");
                System.out.println("Elements has: "+q.size());
            }
        }
    }
}
