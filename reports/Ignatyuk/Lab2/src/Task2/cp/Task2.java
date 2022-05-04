package cp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Task2 {
    private static boolean f_flag = false, i_flag = false, n_flag = false;
    private static String src_file = "", dst_file = "";

    public static void main(String[] args) throws Exception {
        FileInputStream fin = null;
        FileOutputStream fout = null;

        try {
            parseInput(args);

            File fin_check = new File(src_file), fout_check = new File(dst_file);

            if (!fin_check.exists() || !fin_check.isFile() || !fin_check.canRead()) {
                throw new Exception("Invalid source file!");
            }

            if (!f_flag && fout_check.exists()) {
                throw new Exception("Unable to overwrite the file!");
            }

            fin = new FileInputStream(src_file);

            if (f_flag && i_flag && fout_check.exists()) {
                System.out.print("You want to owerride existing file \"" + dst_file + "\"? ");

                if (System.in.read() == 'y') {
                    fout = new FileOutputStream(dst_file, false);
                } else {
                    throw new Exception("Terminated by user!");
                }
            } else if (f_flag) {
                fout = new FileOutputStream(dst_file, false);
            } else {
                fout = new FileOutputStream(dst_file);
            }

            int symbol = 0;

            while ((symbol = fin.read()) != -1) {
                fout.write(symbol);
            }
        }

        finally {
            if (fin != null) {
                fin.close();
            }

            if (fout != null) {
                fout.close();
            }

            System.out.println("Completed.");
        }
    }

    private static void parseInput(String[] args) throws Exception {
        if (args.length < 2) {
            throw new Exception("Invalid parameters!");
        }

        if (!args[0].equals("cp")) {
            throw new Exception("Invalid command!");
        }

        args[0] = "";

        for (String arg : args) {
            if (arg.startsWith("-")) {
                for (int i = 1, size = arg.length(); i < size; ++i) {
                    if (arg.charAt(i) == 'f') {
                        f_flag = true;
                    } else if (arg.charAt(i) == 'i') {
                        i_flag = true;
                        n_flag = false;
                    } else if (arg.charAt(i) == 'n') {
                        i_flag = false;
                        n_flag = true;
                    } else {
                        System.out.println("Unknown flag \"" + arg.charAt(i) + "\" ignored.");
                    }
                }
            } else if (src_file == "") {
                src_file = arg;
            } else if (dst_file == "") {
                dst_file = arg;
            } else {
                System.out.println("Value \"" + arg + "\" ignored.");
            }
        }

        if (src_file.equals("") || src_file.endsWith("\\")) {
            throw new Exception("Source file not passed!");
        }

        if (dst_file.equals("")) {
            String[] path = src_file.split("\\");
            dst_file = path[path.length - 1];
        }

        if (src_file.equals(dst_file)) {
            throw new Exception("Same file passed!");
        }
    }
}
