import java.util.Scanner;

public class Task3 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter string: ");
        String s = in.nextLine();
        String result = swapStringCase(s);
        System.out.println(result);
        in.close();
    }  

    static String swapStringCase(String str){
        if(str.isEmpty()){
            return str;
        }
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if(Character.isLetter(ch)){
                if (Character.isUpperCase(ch)){
                    chars[i] = Character.toLowerCase(ch);
                }
                else{
                    chars[i] = Character.toUpperCase(ch);
                }
            }
        }
        return new String(chars);
    }
}

