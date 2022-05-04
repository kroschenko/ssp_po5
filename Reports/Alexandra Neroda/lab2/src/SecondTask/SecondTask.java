package SSP.Lab2.SecondTask;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SecondTask {
    public static void main(String[] args) throws IOException {
        List<BufferedReader> readers = new ArrayList<>();
        List<PrintStream> print = new ArrayList<>();
        print.add(System.out);

        if(args.length == 0 || !args[0].equals("cat")){
            System.out.println("Неизвестная команда");
            return;
        }

        int i = 1;
        for (i = 1; i < args.length && !args[i].equals(">"); i++) {
            if(args[i].equals("-"))
                readers.add(new BufferedReader(new InputStreamReader(System.in)));
            else
                readers.add(new BufferedReader(new FileReader(args[i])));
        }

        if(i+1 < args.length)
            print.clear();

        for(int j = i+1; j< args.length;j++){
            print.add(new PrintStream(args[j]));
        }

        for (int j = 0; j < readers.size(); j++) {
            String read="";
            while ((read = readers.get(j).readLine()) != null && read.length() != 0) {
                for (int k = 0; k < print.size(); k++) {
                    print.get(k).println(read);
                }
            }
        }
    }
}
