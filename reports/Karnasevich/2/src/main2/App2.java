package main2;

import java.io.*;
import java.util.Objects;


public class App2 {

    public static void main(String[] args) {
        var argIdx = 0;
        var scriptFolder = args[argIdx++];
        var lineCount = 0;
        if (Objects.equals(args[argIdx], "-n")) {
            argIdx++;
        }
        lineCount = Integer.parseInt(args[argIdx++]);
        var file = args[argIdx];
        var filePath = scriptFolder.concat(file);
        try (var br = new BufferedReader(new FileReader(filePath))) {
            String line;
            for (var i = 0; i < lineCount && (line = br.readLine()) != null; i++) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
