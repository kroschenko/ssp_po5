import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public final class Utilities {
    public static String getMathExpression(String fileName) throws IOException {
        if (fileName == null) {
            Scanner scanner = new Scanner(System.in);

            return scanner.nextLine();
        }

        return Files.readString(Path.of(fileName));
    }
}