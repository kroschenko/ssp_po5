package main4.task2;

public class App2 {

    public static void main(String[] args) {
        var page = new Page(new Paragraph("Hello there"), new Paragraph("there"));
        var found = page.findAll("there");
        System.out.println(found);
        System.out.println(page.read());
    }
}
