
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Core{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String regex = "\\s*(nl)\\s+(-i)\\s+([0-9]+)\\s+(-l)\\s+([01])\\s+(-n)\\s+(ln|rn|rz)(\\s+((-|[a-z]+.txt)+\\s*([a-z]+.txt)*)*)*\\s*";
        Boolean result = str.matches(regex);

        while(!result){
            System.out.println("\nInput template: nl [-i] [-l] [-n] input_file [output_file]\n" +
            "Example: nl -i 2 -l 0 -n ln in.txt\n\n|  1 - Continue  |  2 - Exit   |  3 - Help    |\n");
            byte lever = in.nextByte();
            if(lever == 2){
                in.close();
                return;
            }
            else if(lever == 3){
                System.out.println(
                "-i NUMBER Specifies the row number increment step\n" +
                "-l [1/0] Specifies the numbering flag for empty rows\n" +
                "-n FORMAT Use the specified format for line numbers.\n" +
                "ln - number is aligned to the left with no initial zeros\n" +
                "rn - number is aligned to the right with no initial zeros\n" +
                "rz - number is aligned to the right with initial zeros\n"     
                );
            }
            in.nextLine();
            System.out.print("Enter: ");
            str = in.nextLine();
            result = str.matches(regex);
        }

        String[] commands = str.split(" ");

        int shag = Integer.parseInt(commands[2]);
        byte flag = Byte.parseByte(commands[4]); 
        String alignment = commands[6];
        int len_com = commands.length;

        List<String> sentences = new ArrayList<>();

        if(len_com == 7){
            sentences = Input_Console();
            Output_Console(sentences, shag, flag, alignment);
        }
        else if(len_com == 8){
            String fileName = commands[7];
            if(fileName.equals("-")){
                sentences = Input_Console();
                Output_Console(sentences, shag, flag, alignment);
            }
            else{
                sentences = Input_File(fileName, shag, flag, alignment);
                Output_Console(sentences, shag, flag, alignment);
            }
        }
        else if(len_com == 9){
            String fileName = commands[7];
            String OutFile = commands[8];
            if(fileName.equals("-")){
                sentences = Input_Console();
                Output_File(OutFile, sentences, shag, flag, alignment);
            } 
            else{
                sentences = Input_File(fileName, shag, flag, alignment); 
                Output_File(OutFile, sentences, shag, flag, alignment);
            }
        }
    
        in.close();
    }

    public static List<String> Input_Console() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter text (character of a new string - [%n]):");
        String text = input.nextLine();
        List<String> sentences = Arrays.stream(text.split("%n"))
        .map(String::trim) // Обрезаем строки в потоке (stream)
        .collect(Collectors.toList()); // Собираем их в список
        input.close();
        return sentences;
    }

    public static List<String> Input_File(String fileName, int shag, Byte flag, String alignment) {
        List<String> sentences = new ArrayList<>();

        try(Scanner file = new Scanner(new File(fileName)))
        {
            while (file.hasNextLine()) {
                sentences.add(file.nextLine());
            }
            file.close();
        }
        catch(IOException ex){
         
            System.out.println(ex.getMessage());
        } 
        return sentences.stream().map(String::trim).collect(Collectors.toList());
    }

    public static void Output_Console(List<String> sentences, int shag, Byte flag, String alignment) {
        int num = 1;

        if(alignment.equals("ln")){
            for (String str : sentences) {
                if (flag == 0 && str.isEmpty()){ // && - для более быстрой проверки, так как
                    System.out.printf("%-2s %s %n", ' ', str); // & - проверяет оба условия
                    continue;
                }
                System.out.printf("%-2d %s %n", num, str);
                num += shag;
            }
        }
        else if(alignment.equals("rn")){             
            for (String str : sentences) {
                if (flag == 0 && str.isEmpty()){ 
                    System.out.printf("%15s %s %n", ' ', str);
                    continue;
                }
                System.out.printf("%15d %s %n", num, str);
                num += shag;
            }
        }
        else if(alignment.equals("rz")){
            for (String str : sentences) {
                if (flag == 0 && str.isEmpty()){
                    System.out.printf("%015d %s %n", flag, str);
                    continue;
                }
                System.out.printf("%015d %s %n", num, str);
                num += shag;
            }
        }
    }

    public static void Output_File(String OutFile, List<String> sentences, 
    int shag, Byte flag, String alignment) {
        try(PrintStream writer = new PrintStream(new File(OutFile))){  
                int num = 1;

                if(alignment.equals("ln")){
                    for (String str : sentences) {
                        if (flag == 0 && str.isEmpty()){ 
                            writer.printf("%-2s %s %n", ' ', str); 
                            continue;
                        }
                        writer.printf("%-2d %s %n", num, str);
                        num += shag;
                    }
                }
                else if(alignment.equals("rn")){             
                    for (String str : sentences) {
                        if (flag == 0 && str.isEmpty()){ 
                            writer.printf("%15s %s %n", ' ', str);
                            continue;
                        }
                        writer.printf("%15d %s %n", num, str);
                        num += shag;
                    }
                }
                else if(alignment.equals("rz")){
                    for (String str : sentences) {
                        if (flag == 0 && str.isEmpty()){
                            writer.printf("%015d %s %n", flag, str);
                            continue;
                        }
                        writer.printf("%015d %s %n", num, str);
                        num += shag;
                    }
                }
                writer.close();
            }
        catch(IOException ex){
            System.out.println(ex.getMessage());    
        }
    }
}
