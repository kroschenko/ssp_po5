package lab_2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

public class SSP_lab2_task_2 {
    public static void main(String [] args) {
        String [] arr = new String[3];
        int count = 0;
        for(String s : args) {
            arr[count] = s;
            count++;
            System.out.println(s);
        }
        try {
            int lens = 0, size_byte = 0; //кол всего строк в файле, кол всего байтов в файле
            int len = Integer.parseInt(arr[1]); //передаваемое кол строк вывести с конца ############################
            int start = 0, end = 0; //начало и конец нужных строк в байтах
            String filePath = arr[2]; // путь к файлу ############################
            int result[] = see_cout_string_inFile(filePath); //подсчет кол всего строк в файле, кол всего байтов в файле
            lens = result[0];
            size_byte = result[1];
            System.out.println("lens = " + lens + " bytes = " + size_byte);
            start = get_seek_inFile(filePath, len, lens); //получение начала
            end = size_byte - start; //подсчет конца
            System.out.println("START = " + start + " END = " + end);
            System.out.println("RESUUULT");
            System.out.println(new String(readCharsFromFile(filePath, start, end)));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static byte[] readCharsFromFile(String filePath, int seek, int chars) throws IOException{ //считывваение из файла от начала байтов до конца нужжных строк
        RandomAccessFile reader = new RandomAccessFile(filePath, "r");
        reader.seek(seek);
        byte[] bytes = new byte[chars];
        reader.read(bytes);
        reader.close();
        return bytes;
    }

    public static int []see_cout_string_inFile(String filePath) {
        int count = 0;
        int size_byte = 0;
        try {
            FileReader fr = new FileReader(filePath);//arr[2]  
            BufferedReader read = new BufferedReader(fr);
            String line = read.readLine();
                while (line != null) {
                    count++;
                    size_byte += line.length(); //считаем длинну всех строк
                    System.out.println(line);
                    //считываем остальные строки в цикле
                    line = read.readLine();
                }
                read.close();
            } 
            catch (FileNotFoundException e) {
                e.printStackTrace();
            } 
            catch (IOException e) {
                e.printStackTrace();
            }
            size_byte += (count*2) - 2; //увеличение кол байтов, так как переход на новую строку 2 байта
        return new int[] {count, size_byte}; //возвращаем кол строк и кол байтов
    }

    public static int get_seek_inFile(String filePath, int len, int maxlen) {
        int count = maxlen - len, i = 0, byte_size = 0; //находим строку после которой будем начинать начинать вывод строк из файла
        int seek_byte = 0;
        try {
            FileReader fr = new FileReader(filePath);//arr[2]  
            BufferedReader read = new BufferedReader(fr);
            String line = read.readLine();
                while (line != null) {
                    i++;
                    byte_size += line.length(); //находим начало в байтах
                    if(i == count) seek_byte = byte_size;
                    System.out.println(line);
                    //считываем остальные строки в цикле
                    line = read.readLine();
                }
                read.close();
            } 
            catch (FileNotFoundException e) {
                e.printStackTrace();
            } 
            catch (IOException e) {
                e.printStackTrace();
            }
            seek_byte += (count*2) - 2; //увеличение кол байтов, так как переход на новую строку 2 байта
        return seek_byte;
    }
}
