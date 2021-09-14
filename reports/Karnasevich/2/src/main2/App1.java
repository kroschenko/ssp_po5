package main2;

import java.io.*;
import java.net.URL;
import java.util.*;


public class App1 {

    public static void main(String[] args) throws IOException {
        URL path = App1.class.getResource("file.txt");
        assert path != null;
        File f = new File(path.getFile());
        var reader = new BufferedReader(new FileReader(f));
        var wordsToLines = new HashMap<String, Set<Integer>>();
        for (var i = 0; ; i++) {
            var content = reader.readLine();
            if (content == null) {
                break;
            }
            var words = content.split("\\W+");
            for (var word : words) {
                wordsToLines.merge(word, new HashSet<>(List.of(i)), (a, b) -> {
                    a.addAll(b);
                    return a;
                });
            }
        }
        System.out.println(wordsToLines);
    }
}
