package lab;
import java.nio.file.Files;
import java.nio.file.Paths;


class Main {
    public static void main(String args[]) {
        try {

            Files.lines(Paths.get(args[0])).limit(Long.valueOf(args[1]).longValue()).forEach(System.out::println);
        } catch (IllegalArgumentException e) {
            System.out.println("You enter wrong number of lines. Please, enter positive number");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

