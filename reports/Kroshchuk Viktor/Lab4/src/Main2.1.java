package com.company;

public class Main {

    public static void main(String[] args) {
        Paragraph paragraph1 = new Paragraph();
        paragraph1.addString("First string in first paragraph.");
        paragraph1.addString("Second string in first \nparagraph.");
        paragraph1.addString("Third string in first paragraph.");
        Paragraph paragraph2 = new Paragraph();
        paragraph2.addString("First string in second paragraph.");
        paragraph2.addString("Second string in second \nparagraph.");
        paragraph2.addString("Third string in second paragraph.");
        Paragraph paragraph3 = new Paragraph();
        paragraph3.addString("First string in third paragraph.");
        paragraph3.addString("Second string in third \nparagraph.");
        paragraph3.addString("Third string in third paragraph.");
        paragraph3.deleteString(2);
        Text text = new Text();
        text.addParagraph(paragraph1);
        text.addParagraph(paragraph2);
        text.addParagraph(paragraph3);
        text.printText();
        text.deleteParagraph(1);
        System.out.println("After removing second paragraph:");
        text.printText();
    }
}
