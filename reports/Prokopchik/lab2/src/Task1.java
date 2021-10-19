import java.util.Scanner;
import java.util.Random;
import java.io.*;

public class Task1 {
    public static void main(String args[]) throws FileNotFoundException {
       Scanner in = new Scanner(new File("fileT1.txt"));
        Random random = new Random();

         String s = "";

        while (in.hasNextLine()) {
            s += in.nextLine() + " ";
        }
        System.out.println ("изначальная строка: " + s);

            for ( String w : s.split("\\s+") ) {
                char[] b = w.toCharArray();
                for ( int i = 0; i < b.length; ++i ) {
                    int j = random.nextInt(b.length-1) + 1;
                    char t = b[i];
                    b[i] = b[j];
                    b[j] = t;
                }
                System.out.print(new String(b) + " ");
            }
            System.out.println();

            in.close();
        }
    }


