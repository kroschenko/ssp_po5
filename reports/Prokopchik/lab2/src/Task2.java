import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Task2 {
    public static void main(String args[]) throws IOException {

        RandomAccessFile raf = new RandomAccessFile(args[1], "r");

        for (int i=0; i<Integer.parseInt(args[0]); i++)
        {
            String text1 = raf.readLine();
            System.out.println(text1);
        }

    }
}
