package main2;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.IntStream;


public class App1 {

    public static void main(String[] args) throws IOException {
        var stream = App1.class.getResourceAsStream("file.txt");
        if (stream == null){
            return;
        }
        var text = new String(stream.readAllBytes());
        text = text.toLowerCase(Locale.ROOT);
        var lines= text.split("\n");
        var wordsToLines = new HashMap<String, Set<Integer>>();
        for (var i = 0; i < lines.length; i++){
            var words = lines[i].split("\\W+");
            for (var word : words) {
                wordsToLines.merge(word, Set.of(i), App1::merge);
            }
        }
        System.out.println(wordsToLines);
    }

    private static Set<Integer> merge(Set<Integer> a, Set<Integer> b) {
        var newSet = new HashSet<>(a);
        newSet.addAll(b);
        return newSet;
    }
}
