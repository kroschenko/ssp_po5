import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) throws IOException {
        String combinedInput = "";
        Scanner scanner = new Scanner(System.in);

        for (int index = 1; index < args.length; index++) {
            switch (args[index]) {
                case "-" -> combinedInput += scanner.nextLine() + System.lineSeparator();
                case ">" -> {
                    Files.writeString(Path.of(args[0], args[index + 1]), combinedInput);
                    return;
                }
                default -> combinedInput += Files.readString(Path.of(args[0], args[index])) + System.lineSeparator();
            }
        }

        System.out.print(combinedInput);
    }
}
