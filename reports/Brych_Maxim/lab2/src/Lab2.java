import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab2 {
    
    static int COUNT_LINE = 10;
    public static void main(String[] args) {
        if (args[0].equals("task1")) {
            Task1(args[1]);// Text1.txt
        }
        else if (args[0].equals("task2") && args[1].equals("head")) {
            Task2(args);// /var/log/syslog.1
        }
        else System.err.println("invalid args");
    }

    public static void Task1(String url) {
        try {
            int numLine = 0;
            Map<String,List<Integer>> map = new HashMap<>();        
            Pattern p = Pattern.compile("[a-zA-Z0-9]+");
            Matcher m;
            File file = new File(url);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null || numLine == 0) {
                numLine++;
                m = p.matcher(line);
                while (m.find()) {
                    String word = m.group();
                    List<Integer> values = map.get(word);
                    // System.out.println("map.get = " + map.get(word) + ", word = " + word + ", numLine = " + numLine);
                    if (values == null) 
                        values = new ArrayList<>();
                    if (CheckExist(values, numLine)) 
                        break;
                    values.add(numLine);
                    map.put(word, values);
                }
                line = reader.readLine();
            }
            System.out.println("Initial Mappings are: " + map);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void Task2(String[] args) {
        try {
            String url;
            if (args[2].equals("-n")) {
                COUNT_LINE = Integer.parseInt(args[3]);
                url = args[4];
            }
            else url = args[2];

            File file = new File(url);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            for (int i = 0; i < COUNT_LINE; i++)
                if (line != null) 
                    System.out.println(reader.readLine());
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean CheckExist(List<Integer> values, int num) {
        for(Integer val : values)
            if (val.equals(num)) 
                return true;
        return false;
    }
}