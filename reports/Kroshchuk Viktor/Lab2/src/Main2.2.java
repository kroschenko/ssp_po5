package lab1_2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Lab1_2 {
    public static void main(String[] args) {
        int index;
        boolean isSoption = false;
        String separator = "\t";
        Scanner scanner = new Scanner(System.in);
        List<String> list = Arrays.asList(scanner.nextLine().split("\\s"));
        if (!list.get(0).equals("paste")) {
            System.out.println("You entered incorrect command");
        } else {
            if ((index = list.indexOf("-s")) > 0 && index <= 7) {
                isSoption = true;
            }
            if ((index = list.indexOf("-d")) > 0 && index <= 5) {
                separator = list.get(index + 1);
            }
            int size = list.size();
            makePasteCommand(isSoption, separator, list.get(size - 2), list.get(size - 1));
        }
    }
    private static void makePasteCommand(boolean isSoption, String separator, String file1, String file2) {
        List<String> file1Strings = readFile(file1);
        List<String> file2Strings = readFile(file2);
        if (isSoption) {
            printString(file1Strings, separator);
            printString(file2Strings, separator);
        } else {
            for (int i = 0; i < file1Strings.size(); i++) {
                System.out.println(file2Strings.get(i) + separator +
                        file1Strings.get(i));
            }
        }
    }
    private static void printString(List<String> list, String separator) {
        int indexLast = list.size() - 1;
        for (int i = 0; i < indexLast; i++) {
            System.out.print(list.get(i) + separator);
        }
        System.out.println(list.get(indexLast));
    }
    private static List<String> readFile(String fileName) {
        List<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String string;
            while ((string = br.readLine()) != null) {
                list.add(string);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
}
