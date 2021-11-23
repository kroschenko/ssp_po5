package SSP.Lab2.FirstTask;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FirstTask {
    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();
        File file = new File("D:\\SSP\\src\\SSP\\Lab2\\test.txt");
        BufferedReader readerFile = new BufferedReader(new FileReader(file)) ;
        while(readerFile.ready()){
            String str = readerFile.readLine();
            list.add(str);
        }
        Collections.sort(list, (k,v)->{
            return (k.length() > v.length())?1:(k.length() < v.length()?-1:0);
        });
        list.forEach(k->{
            System.out.println(k);
        });
    }
}
