import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Task1 {

    public static void main(String[] args) {
        try {
            String fileContents = Files.readString(Path.of("files/text.txt"));
            String fileContentsWithoutDuplicates = Arrays.stream(fileContents.split(" "))
                    .distinct()
                    .collect(Collectors.joining(" "));

            System.out.println(fileContentsWithoutDuplicates);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
