import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.*;
import java.io.*;

public class Task1 {
    public static void main(String args[]) throws FileNotFoundException{
        Scanner in = new Scanner(new File("file.txt"));
        String s = "";

        while (in.hasNextLine()) {
            s += in.nextLine() + " ";
        }
        String[] words = s.split(" ");
        ConcurrentMap<String, Integer> m = new ConcurrentHashMap<>();
        for(String word: words){
            m.compute(word, (k, v) -> v == null ? 1 : v + 1);
        }
        m.entrySet().stream().sorted(Collections.reverseOrder((n1,n2)->n1.getValue().compareTo(n2.getValue()))).forEach(n->System.out.println(n));
        in.close();
    }  
}
