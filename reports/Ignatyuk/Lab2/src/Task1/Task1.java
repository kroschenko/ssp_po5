import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) throws IOException {
        Scanner fin = new Scanner(new File("file.txt"));
        Map<Integer, Integer> stats = new HashMap<Integer, Integer>();

        while (fin.hasNext()) {
            String word = fin.next();
            word = word.replaceAll("\\W+", "");

            int key = word.length();

            if (key > 0) {
                if (stats.putIfAbsent(key, 1) != null) {
                    stats.replace(key, stats.get(key) + 1);
                }
            }
        }

        fin.close();

        System.out.println("char:count");

        for (Map.Entry<Integer, Integer> entry : stats.entrySet()) {
            System.out.println(entry.getKey().toString() + ":" + entry.getValue().toString());
        }
    }
}
